package com.example.uploudfiles.service;

import com.example.uploudfiles.entity.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String addImage(String name,byte[] image);

    Image findById(Long id);
}
