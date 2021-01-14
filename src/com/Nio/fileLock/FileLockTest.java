package com.Nio.fileLock;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {
    public static void main(String[] args) {
        try (FileChannel fileChannel = new FileOutputStream("D:\\a.txt").getChannel()) {
            //获取文件锁
            FileLock lock = fileChannel.tryLock();
            //程序暂停10秒
            Thread.sleep(10000);
            //释放锁
            lock.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
