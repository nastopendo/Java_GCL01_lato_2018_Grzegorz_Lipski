package com.glipski.gallery.service;

import com.glipski.gallery.dao.PictureDao;
import com.glipski.gallery.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;

@Service
public class PictureService {

    @Autowired
    public PictureDao pictureDao;

    public Collection<Picture> getAllPictures(){
        return this.pictureDao.getAllPictures();
    }

    public ResponseEntity<byte[]> getPicture(int index) throws IOException {
        return this.pictureDao.getPicture(index);
    }

    public void removePicture(int index) {
        this.pictureDao.removePicture(index);
    }

    public void uploadPicture(String fileNameWithOutExt) throws IOException {
        this.pictureDao.uploadPicture(fileNameWithOutExt);
    }
}


