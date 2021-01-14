package com.outputStreamAndWriter;

import java.io.FileWriter;
import java.io.Writer;

/***
 * 字符流写入文件
 */
public class FileWriterTest {
    public static void main(String[] args) throws Exception {
        //创建一个字符输出流
        Writer fw = new FileWriter("D:\\poem.txt");
        fw.write("1\n");
        fw.write("12\n");
        fw.write("123\n");
        fw.write("1234\n");
        fw.write("12345\n");
        fw.close();
    }
}
