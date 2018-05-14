package com.glipski.gallery.dao;

import com.glipski.gallery.entity.Picture;

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

    static SystemCache systemCache = new SystemCache();
    public static Map<Integer, Picture> pictures;// = new HashMap<>();
    static private String picturesFolderPath = "src/main/resources/static/pictures/";
    static private String serFilePath = "src/main/resources/static/serialization/hashMap.ser";

    static {
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