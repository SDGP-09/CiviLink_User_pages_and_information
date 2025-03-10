package com.example.demo.services;

import com.example.demo.exception.ResourceNotFoundException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class StorageService {

//    @Value("${gcp.bucket.name}")
//    private String bucketName;
//
//    @Value("${GOOGLE_CLOUD_KEY}")
//    private String jsonKey;
//
//    private Storage getStorage() throws IOException {
//        ByteArrayInputStream stream = new ByteArrayInputStream(jsonKey.getBytes());
//        GoogleCredentials credentials = GoogleCredentials.fromStream(stream);
//        return StorageOptions.newBuilder().setCredentials(credentials).build().getService();
//    }
//
//    public String uploadFile(MultipartFile file) throws IOException {
//        String fileName = "profile-pictures/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
//        Storage storage = getStorage();
//        BlobId blobId = BlobId.of(bucketName, fileName);
//        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
//        storage.create(blobInfo, file.getBytes());
//        return "https://storage.googleapis.com/" + bucketName + "/" + fileName;
//    }
//
//    public void deleteFile(String imageUrl) throws IOException {
//        String fileName = imageUrl.split(bucketName + "/")[1];
//        Storage storage = getStorage();
//        BlobId blobId = BlobId.of(bucketName, fileName);
//        boolean deleted = storage.delete(blobId);
//        if (!deleted) {
//            throw new ResourceNotFoundException("Image not found: " + imageUrl);
//        }
//    }
}
