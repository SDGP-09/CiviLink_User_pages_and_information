package com.example.demo.services.impl;

import com.example.demo.dtos.internal.IdBasedInternalDTO;
import com.example.demo.dtos.response.CompanyDetailsResponseDTO;
import com.example.demo.entities.Contractor;
import com.example.demo.entities.Deal;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.ContractorRepository;
import com.example.demo.repositories.DealRepository;
import com.example.demo.repositories.RatingRepository;
import com.example.demo.services.ContractorService;
import com.example.demo.types.MiniDealPortable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dtos.ContractorDTO;

import java.util.*;

@Service
public class ContractorServiceImpl implements ContractorService {

    @Autowired
    private ContractorRepository contractorRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private DealRepository dealRepository;

    public ContractorDTO addContractor(ContractorDTO contractorDTO) {
        Contractor contractor = new Contractor();
        contractor.setName(contractorDTO.getName());
        contractor.setLocation(contractorDTO.getLocation());
        contractor.setCompanyName(contractorDTO.getCompanyName());
//        contractor.setRating(contractorDTO.getRating());
        contractor.setProfilePicture(contractorDTO.getProfilePicture());

        contractorRepository.save(contractor);
        return contractorDTO;
    }


    public List<ContractorDTO> searchContractors(String query) {
//        List<Contractor> contractors = contractorRepository.findByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(query, query);
//        return contractors.stream()
//                .map(c -> new ContractorDTO(c.getName(), c.getLocation(), c.getCompanyName(), c.getRating(), c.getProfilePicture()))
//                .toList();
        return null;
    }

    public Optional<ContractorDTO> getContractorProfile(Long id) {
//        Optional<Contractor> contractor = contractorRepository.findById(id);
//        if (contractor.isEmpty()) {
//            throw new ResourceNotFoundException("Contractor not found with id: " + id);
//        }
//        Contractor savedContractor = contractor.get();
//        return contractor.map(c -> new ContractorDTO(c.getName(), c.getLocation(), c.getCompanyName(), c.getRating(), c.getProfilePicture()));
        return null;
    }

    @Override
    public CompanyDetailsResponseDTO getCompanyDetailsByContractorId(IdBasedInternalDTO internalDTO) {

        Contractor contractor = contractorRepository.findById(internalDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Contractor not found with id: " + internalDTO.getId()));


        List<Object[]> ratingResults = ratingRepository.findRatingCountsByContractorId(internalDTO.getId());
        Map<Integer, Integer> ratingMap = new HashMap<>();
        for (Object[] row : ratingResults) {
            int ratingValue = (int) row[0];
            long count = (long) row[1];
            ratingMap.put(ratingValue, (int) count);
        }

         for (int i = 1; i <= 5; i++) {
             ratingMap.putIfAbsent(i, 0);
         }


        List<Deal> deals = dealRepository.findByContractorId(internalDTO.getId());
        List<MiniDealPortable> miniDealList = new ArrayList<>();

        for (Deal deal : deals) {

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

        MiniDealPortable[] hotDeals = miniDealList.toArray(new MiniDealPortable[0]);




        return new CompanyDetailsResponseDTO(
                contractor.getName(),
                contractor.getLocation(),
                contractor.getProfilePicture(),
                ratingMap,
                hotDeals
        );
    }

}



