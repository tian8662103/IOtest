package com.Nio2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Files遍历文件使用
 */
public class FileVisitorTest {
    public static void main(String[] args) throws IOException {
        //遍历文件D:\\SSMDemo\IOTest
        Files.walkFileTree(Paths.get("D:","SSMDemo","IOText"),
                new SimpleFileVisitor<Path>(){
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        System.out.println("正在访问" + file + "文件");
                        //找到了FileVistorTest.java文件
                        if (file.endsWith("FileVisitorTest.java")) {
                            System.out.println("已经找到目标文件");
                            return FileVisitResult.TERMINATE;
                        }
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                        System.out.println("正在访问：" + dir + "路径");
                        return FileVisitResult.CONTINUE;
                    }
                });
    }
}
