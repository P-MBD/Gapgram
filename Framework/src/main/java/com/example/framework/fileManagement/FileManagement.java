package com.example.framework.fileManagement;


import java.io.File;

/**
 * Created by farzad.sarseify on 06/03/2017.
 */

public class FileManagement {


    public static boolean isFileAvailabel(String filePath) {

        File file = new File(filePath);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }


    }



    public static boolean isFileAvailabel(String path_Full, String name) {

        String path = path_Full + name + ".mp3";
        return FileManagement.isFileAvailabel(path);
    }


}
