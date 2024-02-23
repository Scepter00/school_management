package com.schoolmanagement.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {

    @Value("${cloudinary_name}")
    private String cloudName;

    @Value("${cloudinary_api_key}")
    private String cloudApiKey;

    @Value("${cloudinary_api_secret}")
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name", cloudName,
                        "api_key", cloudApiKey,
                        "api_secret", apiSecret));
    }

}