package com.logvynskyy.aptrental.dao;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ImageDAO {
    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    public void uploadImage(MultipartFile[] images){
        try {
            for (MultipartFile file : images) {
                if (!file.isEmpty()) {
                    String uploadFilePath = UPLOAD_DIR + file.getOriginalFilename();// + ".png";

                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(uploadFilePath);
                    Files.write(path, bytes);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public String[] getImageNames(){
//
//    }
}
