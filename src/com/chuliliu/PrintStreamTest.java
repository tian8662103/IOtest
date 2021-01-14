package com.chuliliu;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 使用处理流来包装字节流 写入文件
 */
public class PrintStreamTest {
    public static void main(String[] args) throws Exception{
        OutputStream fos = new FileOutputStream("D:\\text.txt");
        PrintStream printStream = new PrintStream(fos);
        printStream.println("123213");
        printStream.println(new PrintStreamTest());
        printStream.close();
    }
}
