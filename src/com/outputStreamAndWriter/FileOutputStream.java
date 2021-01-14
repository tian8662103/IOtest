package com.outputStreamAndWriter;

import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * OutputStream 写入文件
 */
public class FileOutputStream {
    public static void main(String[] args) {
        try {
            //创建一个输入流
            InputStream fis = new FileInputStream("D:\\SSMDemo\\IOText\\src\\com\\outputStreamAndWriter\\FileOutputStream.java");
            //创建一个输出流
            OutputStream fos = new java.io.FileOutputStream("D:\\newFile.txt");
            byte[] bytes = new byte[32];
            int hasRead = 0;
            while ((hasRead = fis.read(bytes)) > 0) {
                //没读取一次，即写入文件的输出类，读了多少 写多少
                fos.write(bytes,0,hasRead);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }


    }
}
