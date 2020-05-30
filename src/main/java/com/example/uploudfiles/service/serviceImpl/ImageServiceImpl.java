package com.example.uploudfiles.service.serviceImpl;

import com.example.uploudfiles.entity.Image;
import com.example.uploudfiles.repository.ImageRepository;
import com.example.uploudfiles.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image findById(Long id) {
        Optional<Image> image = imageRepository.findById(id);
        return image.get();
    }

    @Override
    public String addLink(String s) {
        return imageRepository.addLink(s);
    }
    //    @Override
//    public String addImage(String name, byte[] image) {
//       return imageRepository.addImage(name, image);
//    }
}
