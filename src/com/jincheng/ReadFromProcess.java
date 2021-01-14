package com.jincheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromProcess {
    public static void main(String[] args) throws IOException {
        //运行javac命令，返回运行该命令的子进程
        Process p = Runtime.getRuntime().exec("javac");
        //以P进程的错误流创建BufferedReader对象
        //这个错误流对本程序是输入流，对p进程则是输出流
        try ( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()))){
            String buff = null;
            while ((buff = bufferedReader.readLine()) != null) {
                System.out.println(buff);
            }
        } catch (Exception e) {

        }
    }
}
