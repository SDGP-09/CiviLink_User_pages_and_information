package com.example.demo.controllers;

import com.example.demo.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private StorageService storageService;

//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
//        try {
//            String url = storageService.uploadFile(file);
//            return ResponseEntity.ok(url);
//        } catch (IOException e) {
//            return ResponseEntity.status(500).body("Upload Failed");
//        }
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<String> deleteImage(@RequestParam("url") String imageUrl) {
//        try {
//            storageService.deleteFile(imageUrl);
//            return ResponseEntity.ok("Image Deleted Successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(404).body(e.getMessage());
//        }
//    }
}
