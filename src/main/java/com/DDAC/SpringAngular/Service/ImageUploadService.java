package com.DDAC.SpringAngular.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.util.IOUtils;

@Service
public class ImageUploadService {
    private final AmazonS3 s3Client;

    @Autowired
    public ImageUploadService(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public String uploadImage(MultipartFile imageFile, String folderPath) throws AmazonS3Exception, AmazonServiceException, SdkClientException, IOException {
        String fileName = UUID.randomUUID().toString() + "-" + imageFile.getOriginalFilename();
        
        // Convert MultipartFile to byte array
        byte[] imageBytes = IOUtils.toByteArray(imageFile.getInputStream());

        // Upload the byte array to the specified folder in the bucket
        s3Client.putObject("web-static-handicraft", folderPath + "/" + fileName, new ByteArrayInputStream(imageBytes), null);

        return fileName; // Return the generated image name
    }
}
