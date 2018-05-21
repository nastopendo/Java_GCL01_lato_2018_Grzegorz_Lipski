package com.glipski.gallery.controller;

import com.glipski.gallery.entity.Picture;
import com.glipski.gallery.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

//@RestController
@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @GetMapping(value = "/gallery/pictures1")
    public String getAllPictures1(){
        return "login";
    }

    @RequestMapping(value = "/gallery/pictures", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Picture> getAllPictures(){
        return pictureService.getAllPictures();
    }

    @RequestMapping(value = "/gallery/picture/{index}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> getPictureByIndex(@PathVariable("index") int index) throws IOException {

        return pictureService.getPicture(index);
    }

    @RequestMapping(value = "/gallery/picture/{index}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Boolean> deletePictureByIndex(@PathVariable("index") int index){
        Map<String, Boolean> result = new TreeMap<>();

        if(pictureService.pictureDao.pictures.containsKey(index)) {
            pictureService.removePicture(index);
            result.put("result:", true);
            return result;
        }
        else{
            result.put("result:", false);
            return result;
        }
    }

    @RequestMapping(value = "/gallery/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public Map<String, Boolean> uploadPicture(@RequestParam("file")MultipartFile file) throws IOException{
        Map<String, Boolean> result = new TreeMap<>();


        String fileName = file.getOriginalFilename();
        String fileNameWithOutExt = fileName.split(".jpg")[0];
        File convertFile = new File("src/main/resources/static/pictures/" + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(convertFile);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();

        int sizeBefore = pictureService.pictureDao.pictures.size();
        this.pictureService.uploadPicture(fileNameWithOutExt);
        int sizeAfter = pictureService.pictureDao.pictures.size();

        if(sizeBefore == sizeAfter) {
            result.put("result:", false);
            return result;
        }
        else{
            result.put("result:", true);
            return result;
        }

    }

}