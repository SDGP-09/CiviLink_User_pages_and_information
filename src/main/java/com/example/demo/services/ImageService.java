package com.example.demo.services;

import com.example.demo.util.UploadImageDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    public List<UploadImageDetails> uploadImage(List<MultipartFile> files);
    public void deleteImage(String imageId);
    public String uploadSingleImage(MultipartFile file);
    public void deleteListOfImages(List<String> imageIds);
}
