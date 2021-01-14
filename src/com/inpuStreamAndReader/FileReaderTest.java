package com.inpuStreamAndReader;


import java.io.FileReader;
import java.io.Reader;

/**
 *字符流读取
 */
public class FileReaderTest {
    public static void main(String[] args) {
        try {
            //创建字符流
            Reader fr = new FileReader("D:\\SSMDemo\\IOText\\src\\com\\inpuStreamAndReader\\FileReaderTest.java");
            //创建一个字符数组
            char[] cbuf = new char[32];
            int hasRead = 0;
            while ((hasRead = fr.read(cbuf)) > 0) {
                //取出字符数组，将字符数组转换为字符串输入
                System.out.println(new String(cbuf, 0, hasRead));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
