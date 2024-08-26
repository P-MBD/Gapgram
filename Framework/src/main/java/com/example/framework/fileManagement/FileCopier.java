package com.example.framework.fileManagement;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by farzad.sarseify on 23/02/2017.
 */

public class FileCopier {

    /**
     * Used to copy files from assets to Sdcard
     *
     * @param context context
     * @param folderName     folderName of assets
     */
    public void copyAssets(Context context,String folderName) {
        AssetManager assetManager = context.getAssets();
        String[] files = null;
        try {
            files = assetManager.list(folderName);
        } catch (IOException e) {
            Log.e("tag", e.getMessage());
        }

        for(String filename : files) {
            System.out.println("File name => "+filename);
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(folderName+File.separator+filename);   // if files resides inside the "Files" directory itself
                out = new FileOutputStream(Environment.getExternalStorageDirectory().toString()+ File.separator+ "" + File.separator+folderName+File.separator + filename);
                copyFile(in, out);
                in.close();
                in = null;
                out.flush();
                out.close();
                out = null;
            } catch(Exception e) {
                Log.e("tag", e.getMessage());
            }
        }
    }
    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }
}
