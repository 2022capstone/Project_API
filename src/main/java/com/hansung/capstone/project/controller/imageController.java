package com.hansung.capstone.project.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/images")
public class imageController {

    @GetMapping(value = "/{category}/{id}/{filename}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte []> getImage(@PathVariable("category") String category, @PathVariable("id") String id, @PathVariable("filename") String fileName) throws IOException {

        byte[] bytes = StreamUtils.copyToByteArray(new ClassPathResource("images/" + category + "/" +id + "/"+ fileName).getInputStream());

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bytes);
    }
}
