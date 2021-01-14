package com.Nio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Files工具类使用
 */
public class FilesTest {
    public static void main(String[] args) throws IOException {
        //复制文件
        Files.copy(Paths.get("D:\\SSMDemo\\IOText\\src\\com\\Nio2\\FilesTest.java"),
                new FileOutputStream("D:\\a.txt"));
        System.out.println("FileTest.java是否为隐藏文件："+Files.isHidden(Paths.get("D:\\SSMDemo\\IOText\\src\\com\\Nio2\\FilesTest.java")));
        //一次性读取FilesTest.java文件所有行
        List<String> readAllLines = Files.readAllLines(Paths.get("D:\\SSMDemo\\IOText\\src\\com\\Nio2\\FilesTest.java"));
        System.out.println(readAllLines);
        //判断指定文件的大小
        System.out.println("FileTest.java的大小为："+Files.size(Paths.get("D:\\SSMDemo\\IOText\\src\\com\\Nio2\\FilesTest.java")));
        List<String> poem = new ArrayList<>();
        poem.add("水晶潭底银鱼跃");
        poem.add("清徐枫中碧竿横");
        //直接将多个字符串内容写到制定文件
        Files.write(Paths.get("D:\\pome.txt"), poem, Charset.forName("GBK"));
        //使用Java 8新增的Stream API 列出当前目录下所有文件和子目录
        Files.list(Paths.get(".")).forEach(path -> System.out.println(path));
        //使用Java 8新增的Stream API  读取文件内容
        /**
         * 发送异常 java.nio.charset.MalformedInputException: Input length = 1
         * 解决办法：把GBK修改成UTF-8，因为有中文字符串的原因才做这样的修改，除非把中文注释全部删除
         */
        Stream<String> gbk = Files.lines(Paths.get("D:\\SSMDemo\\IOText\\src\\com\\Nio2\\FilesTest.java"), Charset.forName("UTF-8"));
        gbk.forEach(line-> System.out.println(line));
        FileStore store = Files.getFileStore(Paths.get("D:\\SSMDemo\\IOText\\src\\com\\Nio2\\FilesTest.java"));
        //判断c盘的总空间、可用空间
        System.out.println("C盘的总空间："+store.getTotalSpace());
        System.out.println("C盘可用空间："+store.getUsableSpace());
    }
}
