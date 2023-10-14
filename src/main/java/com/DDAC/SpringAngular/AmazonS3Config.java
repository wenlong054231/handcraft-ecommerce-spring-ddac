package com.DDAC.SpringAngular;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonS3Config {

    @Bean
    public AmazonS3 amazonS3Client() {
        // Use the default profile name "default" for credentials
        AWSStaticCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(
            new ProfileCredentialsProvider("default").getCredentials()
        );

        Regions awsRegion = Regions.fromName("us-east-1"); // Replace with your desired region
        return AmazonS3ClientBuilder.standard()
                .withRegion(awsRegion)
                .withCredentials(credentialsProvider)
                .build();
    }
}
