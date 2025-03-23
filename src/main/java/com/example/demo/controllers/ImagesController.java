package com.example.demo.controllers;

import com.example.demo.services.ImageService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/images")
public class ImagesController {
    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<StandardResponse> UploadImageList(
            @RequestParam("images") List<MultipartFile> images
    ){

        return new ResponseEntity<>(
                new StandardResponse(200,"Images saved",imageService.uploadImage(images)),
                HttpStatus.OK
        );
    }

    @DeleteMapping(params = {"id", "adId"})
    public ResponseEntity<StandardResponse> DeleteImageList(
            @RequestParam String id,
            @RequestParam long adId
    ){

        imageService.deleteImage(id);


        return new ResponseEntity<>(
                new StandardResponse(204,"Image deleted",id),
                HttpStatus.NO_CONTENT
        );
    }
}
