package com.example.uploudfiles.repository;

import com.example.uploudfiles.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
    @Query(value = "INSERT INTO example_image(name,image) VALUES (:name,:image)",nativeQuery = true)
    String addImage(@Param("name")String name ,@Param("image") byte[] image);
}
