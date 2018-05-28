package com.glipski.gallery.controller;

import com.glipski.gallery.dao.PictureDao;
import com.glipski.gallery.service.LoginService;
import com.glipski.gallery.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class AdminController{

    @Autowired
    PictureDao pictureDao;

    LoginService loginService = new LoginService();

//    @RequestMapping(method = RequestMethod.GET)
//    public String index(){
//        return "index";
//    }
//
//    @RequestMapping(value = "gallery", method = RequestMethod.GET)
//    public String gallery(ModelMap modelMap){
//        modelMap.put("picturelist", this.pictureDao.getAllPictures());
//        return "picturelist";
//    }

    @RequestMapping(value = "gallery/panel", method = RequestMethod.GET)
    public String delete(ModelMap modelMap){
        modelMap.put("picturelist", this.pictureDao.getAllPictures());
        return "delete";
//        if(loginService.isLogged()){
//            modelMap.put("picturelist", this.pictureDao.getAllPictures());
//            return "delete";
//        }
//        else return "login";
    }

//    @RequestMapping(value = "picturelist", method = RequestMethod.GET)
//    public String pictureList(ModelMap modelMap){
//        modelMap.put("picturelist", this.pictureDao.getAllPictures());
//        return "picturelist";
//    }

    @RequestMapping(value = "/delete_user", method = RequestMethod.GET)
    public String handleDeleteUser(@RequestParam(name="pictureIndex")String pictureIndex) {
        pictureDao.removePicture(Integer.parseInt(pictureIndex));
        System.out.println("Photo: " + pictureIndex + " deleted successfully");
        return "redirect:/gallery/panel";
    }

    @RequestMapping(value = "/user_name", method = RequestMethod.GET)
    public String handleLogin(@RequestParam(name="log_in")String log_in) {
        if(loginService.login(log_in,"123"))
            return "delete";
        else return "redirect:/gallery/panel";
    }
}
