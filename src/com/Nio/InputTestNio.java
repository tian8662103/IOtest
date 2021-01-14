package com.Nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 从本地文件读取数据
 */
public class InputTestNio {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\basic.txt");
        FileInputStream fis = new FileInputStream(file);
        //获取通道
        FileChannel channel = fis.getChannel();
        //获取缓冲区
        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
        //通道里读取数据并存到缓冲区中
        channel.read(buffer);
        System.out.println(new String(buffer.array()));
        fis.close();
    }
}
