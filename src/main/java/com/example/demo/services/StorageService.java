package com.example.demo.services;

import java.io.IOException;

public interface StorageService {


    public String uploadFile(byte[] fileBytes, String contentType) throws IOException;

    public byte[] downloadFile(String fileName) throws IOException;

    public String generateSignedUrl(String fileName);


}
