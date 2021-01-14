package com.file;

import java.io.File;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) throws Exception {
        // 以当前路径来创建一个File对象
        File file = new File(".");
        // 直接获取文件名.输出一点
        System.out.println(file.getName());
        // 获取相对路径的父路径可能出错，null
        System.out.println(file.getParent());
        //获取绝对路径
        System.out.println(file.getAbsoluteFile());
        //获取上一级路径
        System.out.println(file.getAbsoluteFile().getParent());
        //在当前路径下创建一个临时文件
        File tmp = File.createTempFile("aaa", ".txt", file);
        //在jvm退出是删除临时文件
        tmp.deleteOnExit();
        //以系统当前时间作为新文件名来创建新文件
        File newFile = new File(System.currentTimeMillis() + "");
        System.out.println("newFile对象是否存在"+newFile.exists());
        //以指定newFile来创建一个文件
        newFile.createNewFile();
        //以newFile对象来创建一个目录，因为newFile已经存在
        //所以下面方法返回false,无法创建该目录
        newFile.mkdir();
        //使用list()方法列出当前路径下的所有文件和路径
        String[] list = file.list();
        System.out.println("====当前路径下的所有文件和路径如下====");
        for (String s : list) {
            System.out.println(s);
        }
        //listRoots()静态方法列出所有的磁盘根路径
        File[] files = File.listRoots();
        for (File file1 : files) {
            System.out.println(file1);
        }

    }
}
