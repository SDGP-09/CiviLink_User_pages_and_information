package com.example.demo.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class StorageService {

    @Value("${gcp.bucket.civilink}")
    private String civilink;

    @Value("${gcp.key.path}")
    private String keyPath;

    private Storage getStorage() throws IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(new ClassPathResource("gcp-key.json").getInputStream());
        return StorageOptions.newBuilder().setCredentials(credentials).build().getService();
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = "images/" + file.getOriginalFilename();
        Storage storage = getStorage();
        BlobId blobId = BlobId.of(civilink, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
        storage.create(blobInfo, file.getBytes());
        return "https://storage.googleapis.com/" + civilink + "/" + fileName;
    }
}
