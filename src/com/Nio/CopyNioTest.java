package com.Nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * NIO实现文件复制
 */
public class CopyNioTest {
    public static void main(String[] args) throws IOException {
        //1.创建两个流
        FileInputStream fis = new FileInputStream("D:\\basic.txt");
        FileOutputStream fos = new FileOutputStream("E:\\basic.txt");
        //2.得到两个通道
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();
        //3.复制 适合复制大文件
        fosChannel.transferFrom(fisChannel,0, fisChannel.size());
        //4.关闭
        fis.close();
        fos.close();
    }
}
