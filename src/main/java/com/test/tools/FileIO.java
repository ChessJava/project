package com.test.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileIO {

    public static boolean outRecord(String str,String filePath){
        try {
            File file = new File(filePath);
            OutputStream os = new FileOutputStream(file);
            byte[] b = str.getBytes();
            os.write(b);
            os.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
