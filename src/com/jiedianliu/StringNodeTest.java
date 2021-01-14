package com.jiedianliu;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringNodeTest {
    public static void main(String[] args) throws Exception {
        String src = "1111\n" +
                "222\n" +
                "3333";
        char[] buffer = new char[32];
        int hasRead = 0;
        //创建一个字符串的字符流 读取
        StringReader stringReader = new StringReader(src);
        while ((hasRead = stringReader.read(buffer)) > 0) {
            System.out.println(new String(buffer, 0, hasRead));
        }
        //创建一个StringWriter时，实际上以一个StringBuffer作为输出节点
        //创建一个指定为20的StringBuffer
        StringWriter stringWriter = new StringWriter(20);
        stringWriter.write("1111\n");
        stringWriter.write("2222");
        System.out.println(stringWriter.toString());
    }
}
