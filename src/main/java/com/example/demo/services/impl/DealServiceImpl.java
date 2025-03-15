package com.example.demo.services.impl;

import com.example.demo.dtos.internal.PostAddInternalDTO;
import com.example.demo.dtos.response.AddResponseDTO;
import com.example.demo.entities.Contractor;
import com.example.demo.entities.Deal;
import com.example.demo.entities.DealImage;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.ContractorRepository;
import com.example.demo.repositories.DealRepository;
import com.example.demo.services.DealService;
import com.example.demo.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private ContractorRepository contractorRepository;

    @Autowired
    private StorageService storageService;

    @Override
    public AddResponseDTO postAdd(PostAddInternalDTO postAddInternalDTO) {

        Contractor contractor = contractorRepository.findById(postAddInternalDTO.getOwnerId())
                .orElseThrow(() -> new ResourceNotFoundException("Contractor not found with id: " + postAddInternalDTO.getOwnerId()));

        Deal deal = new Deal(
                postAddInternalDTO.getTitle(),
                postAddInternalDTO.getDescription(),
                postAddInternalDTO.getField(),
                postAddInternalDTO.getFullDescription(),
                postAddInternalDTO.isShow(),
                postAddInternalDTO.getPerHour(),
                postAddInternalDTO.getPerDay(),
                postAddInternalDTO.getPerWeek(),
                postAddInternalDTO.getPerMonth(),
                postAddInternalDTO.getPerYear(),
                postAddInternalDTO.getPrice(),
                contractor
        );


        List<DealImage> dealImages = new ArrayList<>();
        MultipartFile[] images = postAddInternalDTO.getImages();
        if (images != null) {
            for (MultipartFile multipartFile : images) {
                try {

                    byte[] fileBytes = multipartFile.getBytes();
                    String uploadedFileName = storageService.uploadFile(fileBytes, multipartFile.getContentType());
                    DealImage dealImage = new DealImage();
                    dealImage.setImage(uploadedFileName);
                    dealImage.setDeal(deal);
                    dealImages.add(dealImage);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to upload image: " + multipartFile.getOriginalFilename(), e);
                }
            }
        }

        deal.setImages(dealImages);
        Deal savedDeal = dealRepository.save(deal);

        List<String> imageLinks = new ArrayList<>();
        if (savedDeal.getImages() != null) {
            for (DealImage image : savedDeal.getImages()) {
                String signedUrl = storageService.generateSignedUrl(image.getImage());
                imageLinks.add(signedUrl);
            }
        }

        String[] imageSet = imageLinks.toArray(new String[0]);



        return new AddResponseDTO(
                savedDeal.getId(),
                savedDeal.getContractor().getId(),
                savedDeal.getTitle(),
                savedDeal.getDescriptions(),
                savedDeal.getFields(),
                imageSet,
                savedDeal.getFullDescription(),
                savedDeal.isVisible(),
                savedDeal.getPerHour(),
                savedDeal.getPerDay(),
                savedDeal.getPerWeek(),
                savedDeal.getPerMonth(),
                savedDeal.getPerYear(),
                savedDeal.getPrice()
        );
    }
}
