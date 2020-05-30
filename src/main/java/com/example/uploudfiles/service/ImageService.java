package com.example.uploudfiles.service;

import com.example.uploudfiles.entity.Image;

public interface ImageService {
//    String addImage(String name,byte[] image);
    String addLink(String s);

    Image findById(Long id);
}
