package com.zhuanhuanliu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyinTest {
    public static void main(String[] args) throws Exception {
        //将System.in转换成reader对象
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        //将普通Reader转换成BufferedReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("exit")) {
                System.exit(1);
            }
            System.out.println("输入内容：" + line);
        }
        bufferedReader.close();

    }
}
