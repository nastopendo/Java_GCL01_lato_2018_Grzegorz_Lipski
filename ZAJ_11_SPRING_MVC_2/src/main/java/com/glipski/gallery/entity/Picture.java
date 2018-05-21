package com.glipski.gallery.entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Picture implements Serializable{

    private int index;
    private String name;
    private String resolution;
    private double size;
    private String created;
    private File image;

    public Picture(int index, String name) throws IOException {
        this.index = index;
        this.name = name;
        this.created = currentTime();
        this.image = new File("src/main/resources/static/pictures/" + this.name + ".jpg");
        this.size = Math.round(image.length() / 1024.0 * 100.0) / 100.0;
        BufferedImage bufferedImage = ImageIO.read(this.image);
        this.resolution = bufferedImage.getWidth() + "x" + bufferedImage.getHeight();
    }

    public String currentTime(){
        Date date = new java.util.Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+2"));
        String time = sdf.format(date);
        return time;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public double getSize() {
        return size;
    }

    public void setSize() {
        this.size = size;
    }
}