package com.glipski.gallery.dao;

import com.glipski.gallery.config.MyProperties;
import com.glipski.gallery.entity.Picture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Map;

@Repository
public class PictureDao {
    private Environment env;
    static SystemCache systemCache = new SystemCache();
    public static Map<Integer, Picture> pictures;// = new HashMap<>();
    private String picturesFolderPath;
    private String serFilePath;

    @Autowired
    public PictureDao(Environment env) {
        this.env = env;
        picturesFolderPath = env.getProperty("my.pictures-path");
        serFilePath = env.getProperty("my.serialization-file-path");
        try {
            if(new File(serFilePath).exists())
                systemCache.deserialize(serFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        pictures = systemCache.getPictures();
    }

    public Collection<Picture> getAllPictures(){
        return this.pictures.values();
    }

    public ResponseEntity<byte[]> getPicture(int index) throws IOException {
        File imgPath = new File(picturesFolderPath + pictures.get(index).getName() + ".jpg");
        byte[] image = Files.readAllBytes(imgPath.toPath());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        httpHeaders.setContentLength(image.length);
        return new ResponseEntity<>(image, httpHeaders, HttpStatus.OK);
    }

    public void removePicture(int index) {
        this.pictures.remove(index);
        serialization();
    }

    public int firstFreeIndex(){
        int n = 0;
        while (pictures.containsKey(n)) n++;
        return n;
    }

    public void uploadPicture(String fileNameWithOutExt) throws IOException {
        int newIndex = firstFreeIndex();
        pictures.put(newIndex, new Picture(newIndex, fileNameWithOutExt));
        serialization();
    }

    public void serialization(){
        systemCache.setPictures(pictures);
        try{
            systemCache.serialize(serFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}