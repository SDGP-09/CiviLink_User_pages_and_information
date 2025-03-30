package com.example.demo.services.impl;

import com.example.demo.dtos.internal.IdBasedInternalDTO;
import com.example.demo.dtos.internal.UserIdBasedInternalDTO;
import com.example.demo.dtos.request.ContractorCreationRequestDTO;
import com.example.demo.dtos.request.IdPackBasedRequestDTO;
import com.example.demo.dtos.request.NameBasedRequestDTO;
import com.example.demo.dtos.request.PageBasedRequestDTO;
import com.example.demo.dtos.response.CompanyDetailsResponseDTO;
import com.example.demo.dtos.response.ContractorCardResponseDTO;
import com.example.demo.dtos.response.ContractorNameAndPicResponseDTO;
import com.example.demo.entities.Contractor;
import com.example.demo.entities.Deal;
import com.example.demo.entities.Project;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.ContractorRepository;
import com.example.demo.repositories.DealRepository;
import com.example.demo.repositories.RatingRepository;
import com.example.demo.services.ContractorService;
import com.example.demo.types.ContractorCard;
import com.example.demo.types.ContractorNameAndPicture;
import com.example.demo.types.MiniDealPortable;
import com.example.demo.types.ProjectTitleAndImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContractorServiceImpl implements ContractorService {

    @Autowired
    private ContractorRepository contractorRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private DealRepository dealRepository;

//    public ContractorDTO addContractor(ContractorDTO contractorDTO) {
//        Contractor contractor = new Contractor();
//        contractor.setName(contractorDTO.getName());
//        contractor.setLocation(contractorDTO.getLocation());
//        contractor.setCompanyName(contractorDTO.getCompanyName());
////        contractor.setRating(contractorDTO.getRating());
//        contractor.setProfilePicture(contractorDTO.getProfilePicture());
//
//        contractorRepository.save(contractor);
//        return contractorDTO;
//    }


//    public List<ContractorDTO> searchContractors(String query) {
////        List<Contractor> contractors = contractorRepository.findByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(query, query);
////        return contractors.stream()
////                .map(c -> new ContractorDTO(c.getName(), c.getLocation(), c.getCompanyName(), c.getRating(), c.getProfilePicture()))
////                .toList();
//        return null;
//    }

//    public Optional<ContractorDTO> getContractorProfile(Long id) {
////        Optional<Contractor> contractor = contractorRepository.findById(id);
////        if (contractor.isEmpty()) {
////            throw new ResourceNotFoundException("Contractor not found with id: " + id);
////        }
////        Contractor savedContractor = contractor.get();
////        return contractor.map(c -> new ContractorDTO(c.getName(), c.getLocation(), c.getCompanyName(), c.getRating(), c.getProfilePicture()));
//        return null;
//    }


    @Override
    public void createContractor(ContractorCreationRequestDTO contractorCreationRequestDTO) {

        Contractor contractor = new Contractor();

        contractor.setId(contractorCreationRequestDTO.getId());
        contractor.setName(contractorCreationRequestDTO.getName());
        contractor.setLocation(contractorCreationRequestDTO.getLocation());
        contractor.setCompanyName(contractorCreationRequestDTO.getCompanyName());
        contractor.setField(contractorCreationRequestDTO.getField());

        contractorRepository.save(contractor);
    }

    @Override
    public CompanyDetailsResponseDTO getCompanyDetailsByContractorId(UserIdBasedInternalDTO userIdBasedInternalDTO) {

        Contractor contractor = contractorRepository.findById(userIdBasedInternalDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Contractor not found with id: " + userIdBasedInternalDTO.getId()));


        List<Object[]> ratingResults = ratingRepository.findRatingCountsByContractorId(userIdBasedInternalDTO.getId());
        Map<Integer, Integer> ratingMap = new HashMap<>();
        for (Object[] row : ratingResults) {
            int ratingValue = (int) row[0];
            long count = (long) row[1];
            ratingMap.put(ratingValue, (int) count);
        }
        for (int i = 1; i <= 5; i++) {
            ratingMap.putIfAbsent(i, 0);
        }


        List<Deal> deals = dealRepository.findByContractorId(userIdBasedInternalDTO.getId());
        List<MiniDealPortable> miniDealList = new ArrayList<>();
        for (Deal deal : deals) {
            if (deal.isVisible()) {
                String firstImage = null;
                if (deal.getImages() != null && !deal.getImages().isEmpty()) {
                    firstImage = deal.getImages().get(0).getImage();
                }
                MiniDealPortable miniDeal = new MiniDealPortable(
                        deal.getId(),
                        deal.getTitle(),
                        deal.getDescriptions(),
                        firstImage
                );
                miniDealList.add(miniDeal);
            }
        }
        MiniDealPortable[] hotDeals = miniDealList.toArray(new MiniDealPortable[0]);


        List<Project> projects = contractor.getProjects();
        List<ProjectTitleAndImage> onGoingList = new ArrayList<>();
        List<ProjectTitleAndImage> completedList = new ArrayList<>();
        if (projects != null) {
            for (Project project : projects) {
                if (project.isVisible()) {
                    String firstProjectImage = null;
                    if (project.getImages() != null && !project.getImages().isEmpty()) {
                        firstProjectImage = project.getImages().get(0).getImage();
                    }
                    ProjectTitleAndImage projectCard = new ProjectTitleAndImage(
                            project.getId(),
                            project.getName(),
                            firstProjectImage
                    );

                    if (project.getStatus().toString().equalsIgnoreCase("Completed")) {
                        completedList.add(projectCard);
                    } else {
                        onGoingList.add(projectCard);
                    }
                }
            }
        }
        ProjectTitleAndImage[] onGoingProjects = onGoingList.toArray(new ProjectTitleAndImage[0]);
        ProjectTitleAndImage[] completedProjects = completedList.toArray(new ProjectTitleAndImage[0]);


        return new CompanyDetailsResponseDTO(
                contractor.getName(),
                contractor.getLocation(),
                contractor.getProfilePicture(),
                ratingMap,
                hotDeals,
                onGoingProjects,
                completedProjects
        );
    }

    @Override
    public ContractorNameAndPicResponseDTO searchContractorsByName(NameBasedRequestDTO nameBasedRequestDTO) {

        List<Contractor> contractors = contractorRepository.findByNameContainingIgnoreCase(nameBasedRequestDTO.getName());


        List<ContractorNameAndPicture> list = new ArrayList<>();
        for (Contractor c : contractors) {
            list.add(new ContractorNameAndPicture(c.getId(), c.getName(), c.getProfilePicture()));
        }


        ContractorNameAndPicture[] arr = list.toArray(new ContractorNameAndPicture[0]);


        return new ContractorNameAndPicResponseDTO(arr);
    }

    public ContractorNameAndPicResponseDTO searchContractorsByIdPack(IdPackBasedRequestDTO idPackBasedRequestDTO) {

        Iterable<Contractor> contractors = contractorRepository.findAllById(Arrays.asList(idPackBasedRequestDTO.getIds()));
        List<ContractorNameAndPicture> list = new ArrayList<>();
        for (Contractor c : contractors) {
            list.add(new ContractorNameAndPicture(c.getId(), c.getName(), c.getProfilePicture()));
        }
        ContractorNameAndPicture[] arr = list.toArray(new ContractorNameAndPicture[0]);
        return new ContractorNameAndPicResponseDTO(arr);
    }


    @Override
    public ContractorCardResponseDTO searchContractorCardsByName(NameBasedRequestDTO nameBasedRequestDTO) {

        List<Contractor> contractors = contractorRepository.findByNameContainingIgnoreCase(nameBasedRequestDTO.getName());

        if (contractors == null || contractors.isEmpty()) {
            throw new ResourceNotFoundException("No contractor found matching: " + nameBasedRequestDTO.getName());
        }

        List<ContractorCard> cardList = new ArrayList<>();


        for (Contractor contractor : contractors) {

            List<Object[]> ratingResults = ratingRepository.findRatingCountsByContractorId(contractor.getId());
            int totalRatings = 0;
            int totalPoints = 0;
            for (Object[] row : ratingResults) {
                int ratingValue = (int) row[0];
                long count = (long) row[1];
                totalRatings += count;
                totalPoints += ratingValue * count;
            }

            int avgRating = totalRatings > 0 ? (int) Math.round((double) totalPoints / totalRatings) : 0;

            ContractorCard card = new ContractorCard(
                    contractor.getId(),
                    contractor.getName(),
                    avgRating,
                    contractor.getProfilePicture()
            );
            cardList.add(card);
        }


        ContractorCard[] cardsArray = cardList.toArray(new ContractorCard[0]);
        return new ContractorCardResponseDTO(cardsArray);
    }


    @Override
    public ContractorCardResponseDTO getContractorsByPage(PageBasedRequestDTO pageBasedRequestDTO) {

        if (pageBasedRequestDTO.getPageNumber() <= 1) { // changed here
            throw new IllegalArgumentException("Page number must be 1 or greater.");
        }


        Pageable pageable = PageRequest.of(pageBasedRequestDTO.getPageNumber() - 1, 50, Sort.by("id").ascending());


        Page<Contractor> page = contractorRepository.findAll(pageable);

        if (page.isEmpty()) {
            throw new ResourceNotFoundException("No contractors found for page: " + pageBasedRequestDTO.getPageNumber());
        }

        List<ContractorCard> cardList = new ArrayList<>();


        for (Contractor contractor : page.getContent()) {

            List<Object[]> ratingResults = ratingRepository.findRatingCountsByContractorId(contractor.getId());
            int totalRatings = 0;
            int totalPoints = 0;
            for (Object[] row : ratingResults) {
                int ratingValue = (int) row[0];
                long count = (long) row[1];
                totalRatings += count;
                totalPoints += ratingValue * count;
            }
            int avgRating = totalRatings > 0 ? (int) Math.round((double) totalPoints / totalRatings) : 0;


            ContractorCard card = new ContractorCard(
                    contractor.getId(),
                    contractor.getName(),
                    avgRating,
                    contractor.getProfilePicture()
            );
            cardList.add(card);
        }


        ContractorCard[] cardsArray = cardList.toArray(new ContractorCard[0]);
        return new ContractorCardResponseDTO(cardsArray);
    }

}



