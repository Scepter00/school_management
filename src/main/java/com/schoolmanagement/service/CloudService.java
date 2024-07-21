package com.schoolmanagement.service;

import org.springframework.web.multipart.MultipartFile;

public interface CloudService {





    String uploadFile(MultipartFile file);

}