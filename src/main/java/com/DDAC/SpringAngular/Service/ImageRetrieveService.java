package com.DDAC.SpringAngular.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@Service
public class ImageRetrieveService {
    private final AmazonS3 s3Client;

    @Autowired
    public ImageRetrieveService(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public List<String> retrieveImages() {
        String bucketName = "web-static-handicraft"; 
        ListObjectsV2Request request = new ListObjectsV2Request().withBucketName(bucketName);
        ListObjectsV2Result result = s3Client.listObjectsV2(request);

        List<S3ObjectSummary> objectSummaries = result.getObjectSummaries();
        List<String> imageUrls = objectSummaries.stream()
                .map(summary -> s3Client.getUrl(bucketName, summary.getKey()).toString())
                .toList();

        return imageUrls;
    }
}
