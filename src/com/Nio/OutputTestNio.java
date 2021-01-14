package com.Nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通过NIO实现文件输出
 */
public class OutputTestNio {
    public static void main(String[] args) throws IOException {
        //1.创建输出流
        FileOutputStream fis = new FileOutputStream("D:\\basic.txt");
        //2.从流中得到一个通道
        FileChannel channel = fis.getChannel();
        //3.创建缓冲区 往缓冲区存入数据
        String str = "helloNio";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());
        //4.翻转缓冲区
        buffer.flip();
        //5.把缓冲区写到通道中
        channel.write(buffer);
        //6.关闭资源
        channel.close();
        fis.close();
    }
}
