package com.tuihuishuruliu;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushbackTest {
    public static void main(String[] args) throws IOException {
        //创建一个PushbackReader
        PushbackReader reader = new PushbackReader(new FileReader("D:\\SSMDemo\\IOText\\src\\com\\tuihuishuruliu\\PushbackTest.java"), 64);
        char[] buf = new char[32];
        String lastContent = "";
        int hasRead = 0;
        while ((hasRead = reader.read(buf)) > 0) {
            //将读取到的文本内容转换为字符串
            String content = new String(buf, 0, hasRead);
            int targetIndex = 0;
            //将上次读取的字符串和本次读取的字符串拼起来
            //查看是否包含目标字符串，如果包含目标字符串
            if ((targetIndex = (lastContent + content).indexOf("new 创建一个PushbackReader")) > 0) {
                //将本次内容一起推回缓冲区
                reader.unread((lastContent + content).toCharArray());
                //重新定义一个长度为targetIndex 的char数组
                if (targetIndex > 32) {
                    buf = new char[targetIndex];
                }
                //再次读取指定长度的内容
                reader.read(buf, 0, targetIndex);
                // 打印读取内容
                System.out.println(new String(buf, 0, targetIndex));
                System.exit(0);
            } else {
                //打印上次读取到的内容
                System.out.println(lastContent);
                lastContent = content;
            }
        }
        reader.close();
    }
}
