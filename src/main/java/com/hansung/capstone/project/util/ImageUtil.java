package com.hansung.capstone.project.util;

import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

public class ImageUtil {

    private final static String BASE_URL = "src/main/resources/images";
    public final static String API_BASE_URL = "http://192.168.0.9:90/carsharing/images/";

    public static void saveFile(String encodeFile, String path, String fileName) throws IOException{

        Path uploadPath = Paths.get(BASE_URL + path);

        if(!(Files.exists(uploadPath))){
            Files.createDirectories(uploadPath);
        }else{
            System.out.println(uploadPath.toString());
        }

        try{
            Path filePath = uploadPath.resolve(fileName);
            File file = new File(filePath.toString());

            Base64.Decoder decoder = Base64.getDecoder();
            System.out.println(encodeFile);
            String decodedString = URLDecoder.decode(encodeFile, "UTF-8");
            decodedString = StringUtils.replace(decodedString,"%0", "\n");
            byte[] decodedBytes = Base64Utils.decodeFromUrlSafeString(decodedString);

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(decodedBytes);
            fileOutputStream.close();

        }catch(IOException exception){
            System.out.println("Could not save file" + fileName + exception.toString());
        }

    }

    public static void cleanDir(String path){

        Path cleanPath = Paths.get(BASE_URL + path);

        try{
            Files.list(cleanPath).forEach(file ->{
                if(!Files.isDirectory(file)){
                    try{
                        Files.delete(file);
                    }catch (IOException exception2){
                        System.out.println("Could not delete file : " + file);
                    }
                }
            });
        }catch(IOException exception){
            System.out.println("Could not list directory : " + cleanPath);
        }
    }

}
