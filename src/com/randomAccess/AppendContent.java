package com.randomAccess;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendContent {
    public static void main(String[] args) {
        try(RandomAccessFile raf = new RandomAccessFile("D:\\out.txt","rw")) {
            raf.seek(raf.length());
            raf.write("追加内容！\r\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
