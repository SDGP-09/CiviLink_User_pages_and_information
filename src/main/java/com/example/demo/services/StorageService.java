
package com.example.demo.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
        import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class StorageService {

    @Value("${gcp.bucket.name}")
    private String bucketName;

    @Value("${GOOGLE_CLOUD_KEY}")
    private String jsonKey;

    private Storage getStorage() throws IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(jsonKey.getBytes());
        return StorageOptions.newBuilder().setCredentials(credentials).build().getService();
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = "profile-pictures/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
        Storage storage = getStorage();
        BlobId blobId = BlobId.of(bucketName, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
        storage.create(blobInfo, file.getBytes());
        return "https://storage.googleapis.com/" + bucketName + "/" + fileName;
    }
}
