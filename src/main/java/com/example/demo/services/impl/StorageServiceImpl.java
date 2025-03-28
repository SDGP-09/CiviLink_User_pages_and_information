package com.example.demo.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.repositories.ImageRepository;
import com.example.demo.services.StorageService;
import com.example.demo.util.UploadImageDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;



@SuppressWarnings("ALL")
@Service
public class StorageServiceImpl implements StorageService {


//
//    @Value("${gcp.credentials.path}")
//    private String credentialsPath;
//
//    private Storage storage;
//
//    private static final String BUCKET_NAME = "civilink-bucket";
//
//    @PostConstruct
//    public void initStorageClient() throws IOException {
//        // Convert the path string to a Path object
//        Path serviceAccountPath = Paths.get(credentialsPath);
//
//        // Build the StorageOptions with the credentials from the JSON file
//        StorageOptions.Builder builder = StorageOptions.newBuilder()
//                .setCredentials(ServiceAccountCredentials.fromStream(
//                        new FileInputStream(serviceAccountPath.toFile())
//                ));
//
//
//        this.storage = builder.build().getService();
//    }
//
//    @Override
//    public String uploadFile(byte[] fileBytes, String contentType) throws IOException {
//        // Generate a random file name to avoid collisions
//        String fileName = UUID.randomUUID().toString();
//
//        BlobInfo blobInfo = BlobInfo.newBuilder(BUCKET_NAME, fileName)
//                .setContentType(contentType)
//                .build();
//
//        // Upload the file
//        storage.create(blobInfo, fileBytes);
//
//        // Return the file name (or "gs://bucketName/fileName" if you prefer)
//        return fileName;
//    }
//
//    @Override
//    public byte[] downloadFile(String fileName) throws IOException {
//        Blob blob = storage.get(BUCKET_NAME, fileName);
//        if (blob == null) {
//            throw new IOException("File not found: " + fileName);
//        }
//        return blob.getContent();
//    }
//
//    @Override
//    public String generateSignedUrl(String fileName) {
//        BlobInfo blobInfo = BlobInfo.newBuilder(BUCKET_NAME, fileName).build();
//        // Generate a signed URL valid for 15 minutes
//
//        URL signedUrl = storage.signUrl(blobInfo, 15, TimeUnit.MINUTES);
//        return signedUrl.toString();
//
//    }
//
//    @Override
//    public void deleteFile(String fileName) throws IOException {
//        BlobId blobId = BlobId.of(BUCKET_NAME, fileName);
//        boolean deleted = storage.delete(blobId);
//        if (!deleted) {
//            throw new IOException("Failed to delete file: " + fileName);
//        }
//    }
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public String uploadFile(byte[] fileBytes, String contentType) throws IOException {
        // You may add extra options if needed (for example, setting resource type)
        Map<String, Object> options = ObjectUtils.emptyMap();
        Map uploadResult = cloudinary.uploader().upload(fileBytes, options);
        // Return the secure URL to access the uploaded file
        return (String) uploadResult.get("secure_url");
    }



    @Override
    public void deleteFile(String imageId) {
        try {
            cloudinary.uploader().destroy(imageId, ObjectUtils.emptyMap());
        } catch (Exception e) {
            throw new RuntimeException("Error deleting image " + imageId, e);
        }



    }
}
