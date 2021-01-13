package com.example.uploudfiles.controler;

import com.example.uploudfiles.entity.Image;
import com.example.uploudfiles.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUploadController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/image")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = addImage(file);
        return fileName;
    }

    private String addImage(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        String modifiedFileName = System.currentTimeMillis() + file.getOriginalFilename();
//        Path path = Paths.get("C:\\Users\\user\\Desktop\\" + modifiedFileName);
        Path path = Paths.get("E:\\spring initializr\\uploud-files\\src\\main\\resources\\img\\" + modifiedFileName);
        Files.write(path,bytes);
        System.err.println(path.getFileName());
        imageService.addLink(modifiedFileName);

        return modifiedFileName;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Image getById(@PathVariable("id") Long id){
        return imageService.findById(id);
    }
}
