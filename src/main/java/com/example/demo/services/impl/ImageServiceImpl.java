package com.example.demo.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.repositories.ImageRepository;
import com.example.demo.services.ImageService;
import com.example.demo.util.UploadImageDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<UploadImageDetails> uploadImage(List<MultipartFile> files) {
        List<UploadImageDetails> images = new ArrayList<>();

        for (MultipartFile file : files) {

            try {

                Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                images.add(
                        new UploadImageDetails((String) uploadResult.get("secure_url"),(String) uploadResult.get("public_id"))
                );


            }catch (IOException e){
                throw new RuntimeException("Failed to upload image to Cloudinary");
            }
        }

        return images;
    }

    @Override
    public void deleteImage(String imageId) {
        try {
            cloudinary.uploader().destroy(imageId, ObjectUtils.emptyMap());
        } catch (Exception e) {
            throw new RuntimeException("Error deleting image " + imageId, e);
        }



    }

    @Override
    public String uploadSingleImage(MultipartFile file) {
        String url;
        try {

            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            url = (String) uploadResult.get("secure_url");


        }catch (IOException e){
            throw new RuntimeException("Image upload failed");
        }

        return url;
    }

    @Override
    public void deleteListOfImages(List<String> imageIds) {

        for (String imageId : imageIds) {
            deleteImage(imageId);
        }

    }
}
