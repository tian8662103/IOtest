package com.inpuStreamAndReader;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 字节流读入文件
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws Exception {
        //创建字节流
        InputStream fis = new FileInputStream("D:\\SSMDemo\\IOText\\src\\com\\inpuStreamAndReader\\FileInputStreamTest.java");
        //创建一个1024的byte数组
        byte[] bbuf = new byte[1024];
        int hasRead = 0;
        //使用循环来重复取水过程
        //判断文件是否有内容
        while ((hasRead = fis.read(bbuf)) > 0) {
            //取出数组的字节，将字节数组转换成字符串输入
            System.out.println(new String (bbuf,0,hasRead));

        }
        fis.close();
    }
}
