package com.Nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class RandomFileChannelTest {
    public static void main(String[] args) {
        File file = new File("D:\\a.txt");
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw");
             FileChannel randomChannel = raf.getChannel()) {
            MappedByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            //把Channel的纪录指针移动到最后
            randomChannel.position(file.length());
            //将buffer中的所有数据输出
            randomChannel.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
