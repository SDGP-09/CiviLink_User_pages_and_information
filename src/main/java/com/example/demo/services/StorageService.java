package com.example.demo.services;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
@Service
public class StorageService {



    @Value("${gcp.credentials.path}")
    private String credentialsPath;

    private Storage storage;

    private static final String BUCKET_NAME = "civilink-bucket";

    @PostConstruct
    public void initStorageClient() throws IOException {
        // Convert the path string to a Path object
        Path serviceAccountPath = Paths.get(credentialsPath);

        // Build the StorageOptions with the credentials from the JSON file
        StorageOptions.Builder builder = StorageOptions.newBuilder()
                .setCredentials(ServiceAccountCredentials.fromStream(
                        new FileInputStream(serviceAccountPath.toFile())
                ));


        this.storage = builder.build().getService();
    }


    public String uploadFile(byte[] fileBytes, String contentType) throws IOException {
        // Generate a random file name to avoid collisions
        String fileName = UUID.randomUUID().toString();

        BlobInfo blobInfo = BlobInfo.newBuilder(BUCKET_NAME, fileName)
                .setContentType(contentType)
                .build();

        // Upload the file
        storage.create(blobInfo, fileBytes);

        // Return the file name (or "gs://bucketName/fileName" if you prefer)
        return fileName;
    }


    public byte[] downloadFile(String fileName) throws IOException {
        Blob blob = storage.get(BUCKET_NAME, fileName);
        if (blob == null) {
            throw new IOException("File not found: " + fileName);
        }
        return blob.getContent();
    }


}
