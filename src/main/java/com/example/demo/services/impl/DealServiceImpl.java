package com.example.demo.services.impl;

import com.example.demo.dtos.internal.AddIdBasedInternalDTO;
import com.example.demo.dtos.internal.PostAddInternalDTO;
import com.example.demo.dtos.internal.UpdateAddInternalDTO;
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



    @Override
    public AddResponseDTO updateDTO(UpdateAddInternalDTO updateAddInternalDTO){

        Deal deal = dealRepository.findById(updateAddInternalDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Deal not found with id: " + updateAddInternalDTO.getId()));

        deal.setTitle(updateAddInternalDTO.getTitle());
        deal.setDescriptions(updateAddInternalDTO.getDescription());
        deal.setFields(updateAddInternalDTO.getField());
        deal.setFullDescription(updateAddInternalDTO.getFullDescription());
        deal.setVisible(updateAddInternalDTO.isShow());
        deal.setPerHour(updateAddInternalDTO.getPerHour() != null ? updateAddInternalDTO.getPerHour() : 0);
        deal.setPerDay(updateAddInternalDTO.getPerDay() != null ? updateAddInternalDTO.getPerDay() : 0);
        deal.setPerWeek(updateAddInternalDTO.getPerWeek() != null ? updateAddInternalDTO.getPerWeek() : 0);
        deal.setPerMonth(updateAddInternalDTO.getPerMonth() != null ? updateAddInternalDTO.getPerMonth() : 0);
        deal.setPerYear(updateAddInternalDTO.getPerYear() != null ? updateAddInternalDTO.getPerYear() : 0);
        deal.setPrice(updateAddInternalDTO.getPrice() != null ? updateAddInternalDTO.getPrice() : 0);

        String[] deletedImages = updateAddInternalDTO.getDeletedImages();
        if (deletedImages != null && deletedImages.length > 0) {

            List<DealImage> updatedImages = new ArrayList<>();
            for (DealImage img : deal.getImages()) {
                boolean shouldDelete = false;
                for (String delName : deletedImages) {
                    if (img.getImage().equals(delName)) {

                        try {
                            storageService.deleteFile(delName);
                        } catch (IOException e) {
                            throw new RuntimeException("Failed to delete image: " + delName, e);
                        }
                        shouldDelete = true;
                        break;
                    }
                }
                if (!shouldDelete) {
                    updatedImages.add(img);
                }
            }
            deal.setImages(updatedImages);
        }



        MultipartFile[] newImages = updateAddInternalDTO.getImages();
        if (newImages != null) {

            if (deal.getImages() == null) {
                deal.setImages(new ArrayList<>());
            }
            for (MultipartFile multipartFile : newImages) {

                if (multipartFile != null && !multipartFile.isEmpty()) {
                    try {
                        byte[] fileBytes = multipartFile.getBytes();
                        String uploadedFileName = storageService.uploadFile(fileBytes, multipartFile.getContentType());
                        DealImage newDealImage = new DealImage();
                        newDealImage.setImage(uploadedFileName);
                        newDealImage.setDeal(deal);
                        deal.getImages().add(newDealImage);
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to upload new image: " + multipartFile.getOriginalFilename(), e);
                    }
                }
            }
        }
        Deal updatedDeal = dealRepository.save(deal);

        // 6. Generate signed URLs for each image.
        List<String> imageLinks = new ArrayList<>();
        if (updatedDeal.getImages() != null) {
            for (DealImage image : updatedDeal.getImages()) {
                String signedUrl = storageService.generateSignedUrl(image.getImage());
                imageLinks.add(signedUrl);
            }
        }
        // Convert List<String> to an array if needed.
        String[] imageSet = imageLinks.toArray(new String[0]);



        return new AddResponseDTO(
                updatedDeal.getId(),
                updatedDeal.getContractor().getId(),
                updatedDeal.getTitle(),
                updatedDeal.getDescriptions(),
                updatedDeal.getFields(),
                imageSet,
                updatedDeal.getFullDescription(),
                updatedDeal.isVisible(),
                updatedDeal.getPerHour(),
                updatedDeal.getPerDay(),
                updatedDeal.getPerWeek(),
                updatedDeal.getPerMonth(),
                updatedDeal.getPerYear(),
                updatedDeal.getPrice()
        );
    }

    @Override
    public void toggleVisibility(AddIdBasedInternalDTO addIdBasedInternalDTO) {

        Deal deal = dealRepository.findById(addIdBasedInternalDTO.getAddId())
                .orElseThrow(() -> new ResourceNotFoundException("Deal not found with id: " + addIdBasedInternalDTO.getAddId()));


        if (!deal.getContractor().getId().equals(addIdBasedInternalDTO.getOwnerId())) {
            throw new RuntimeException("Unauthorized: Contractor id mismatch.");
        }


        deal.setVisible(!deal.isVisible());


        dealRepository.save(deal);
    }

    @Override
    public void deleteAdd(AddIdBasedInternalDTO addIdBasedInternalDTO) {


        Deal deal = dealRepository.findById(addIdBasedInternalDTO.getAddId())
                .orElseThrow(() -> new ResourceNotFoundException("Deal not found with id: " + addIdBasedInternalDTO.getAddId()));


        if (!deal.getContractor().getId().equals(addIdBasedInternalDTO.getOwnerId())) {
            throw new RuntimeException("Unauthorized: Contractor id mismatch.");
        }


        if (deal.getImages() != null) {
            for (DealImage image : deal.getImages()) {
                try {

                    storageService.deleteFile(image.getImage());
                } catch (IOException e) {

                    throw new RuntimeException("Failed to delete image: " + image.getImage(), e);
                }
            }
        }


        dealRepository.delete(deal);



    }


}
