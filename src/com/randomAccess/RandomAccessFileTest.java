package com.randomAccess;



import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) {
        try(RandomAccessFile raf = new RandomAccessFile("D:\\SSMDemo\\IOText\\src\\com\\randomAccess\\RandomAccessFileTest.java","r")) {
            //获取RandomAccessFile对象文件指针的位置，初始位置是0
            System.out.println("RandomAccessFile的文件指针的初始位置是：" + raf.getFilePointer());
            //移动raf的文件纪录指针的位置
            raf.seek(0);
            byte[] bytes = new byte[1024];
            //用于保存实际读取的字节数
            int hasRead = 0;
            while ((hasRead = raf.read(bytes)) > 0) {
                System.out.println(new String(bytes,0,hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
