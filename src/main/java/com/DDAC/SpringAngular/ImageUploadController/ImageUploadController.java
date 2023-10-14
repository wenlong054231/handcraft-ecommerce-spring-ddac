package com.DDAC.SpringAngular.ImageUploadController;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.DDAC.SpringAngular.Service.ImageRetrieveService;
import com.DDAC.SpringAngular.Service.ImageUploadService;

@RestController
@RequestMapping("/api/v1/images")
public class ImageUploadController {
    private final ImageUploadService imageUploadService;
    private final ImageRetrieveService imageRetrieveService;
    
    @Autowired
    public ImageUploadController(ImageUploadService imageUploadService, ImageRetrieveService imageRetrieveService) {
        this.imageUploadService = imageUploadService;
        this.imageRetrieveService = imageRetrieveService;
    }
    
    @CrossOrigin
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String folderPath = "assets/items"; // Specify the folder path here
            String imageName = imageUploadService.uploadImage(file, folderPath);
            return ResponseEntity.ok(imageName); // Return the generated image name
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
        }
    }
    
    @CrossOrigin(origins = "http://localhost:5173") 
    @GetMapping("/retrieve")
    public ResponseEntity<List<String>> retrieveImages() {
        List<String> imageUrls = imageRetrieveService.retrieveImages();
        return ResponseEntity.ok(imageUrls);
    }
}
