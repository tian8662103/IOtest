package com.system;

import java.io.FileInputStream;
import java.util.Scanner;

public class RedirectIn {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("D:\\out.txt");
        //将标准输入重定向到fis流
        System.setIn(fileInputStream);
        //使用System.in 创建一个Scanner对象
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        //判断是否有下一项
        while (scanner.hasNext()) {
            System.out.println("键盘输入的内容是：" + scanner.next());
        }
        fileInputStream.close();
    }
}
