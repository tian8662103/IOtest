package com.system;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class RedirectOut {
    public static void main(String[] args) throws IOException {
        OutputStream out = new FileOutputStream("");
        //创建一个PrintStream
        PrintStream printStream = new PrintStream(out);
        //将标准输出重定向到PrintStream
        System.setOut(printStream);
        //向标准输出输出一个字符串
        System.out.println("普通字符串");
        System.out.println(new RedirectOut());
        printStream.close();
    }
}
