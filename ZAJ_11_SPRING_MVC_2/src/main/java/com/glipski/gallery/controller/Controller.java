package com.glipski.gallery.controller;

import com.glipski.gallery.dao.PictureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    PictureDao pictureDao;

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "gallery", method = RequestMethod.GET)
    public String gallery(ModelMap modelMap){
        modelMap.put("picturelist", this.pictureDao.getAllPictures());
        return "picturelist";
    }

//    @RequestMapping(value = "gallery/panel", method = RequestMethod.GET)
//    public String delete(ModelMap modelMap){
//        modelMap.put("picturelist", this.pictureDao.getAllPictures());
//        return "delete";
//    }

    @RequestMapping(value = "picturelist", method = RequestMethod.GET)
    public String pictureList(ModelMap modelMap){
        modelMap.put("picturelist", this.pictureDao.getAllPictures());
        return "picturelist";
    }

//    @RequestMapping(value = "/delete_user", method = RequestMethod.GET)
//    public String handleDeleteUser(@RequestParam(name="pictureIndex")String pictureIndex) {
//        pictureDao.removePicture(Integer.parseInt(pictureIndex));
//        System.out.println("Photo: " + pictureIndex + " deleted successfully");
//        return "redirect:/gallery/panel";
//    }
}
