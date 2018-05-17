package com.glipski.gallery.dao;

import com.glipski.gallery.entity.Picture;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SystemCache implements Serializable {
    public static Map<Integer, Picture> picturesCache = new HashMap<>();

    public static Map<Integer, Picture> getPictures() {
        return picturesCache;
    }

    public static void setPictures(Map<Integer, Picture> pictures) {
        SystemCache.picturesCache = pictures;
    }

    // ------------------- SERIALIZATION -------------------------

    void serialize( String path ) throws IOException {
        FileOutputStream file = new FileOutputStream(path);
        serialize(file);
        file.close();
    }
    void serialize ( FileOutputStream file ) throws IOException{
        ObjectOutputStream stream = new ObjectOutputStream(file);
        serialize(stream);
        stream.close();
    }
    void serialize ( ObjectOutputStream stream ) throws IOException{
        stream.writeObject(picturesCache);
    }


// ------------------- DESERIALIZATION -------------------------

    void deserialize( String path ) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(path);
        deserialize(file);
        file.close();
    }
    void deserialize( FileInputStream file ) throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(file);
        deserialize(stream);
        stream.close();
    }
    void deserialize( ObjectInputStream stream ) throws IOException, ClassNotFoundException {
        picturesCache = (HashMap<Integer, Picture>) stream.readObject();
    }
}
