package com.Nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Paths工具类使用
 */
public class PathTest {
    public static void main(String[] args) {
        //以当前路径来创建Path对象
        Path path = Paths.get(".");
        System.out.println("path里包含的路径数量：" + path.getNameCount());
        System.out.println("path的根路径："+path.getRoot());
        //获取path对应的绝对路径
        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);
        //获取绝对路径的根路径
        System.out.println("绝对路径的根路径："+absolutePath.getRoot());
        //获取绝对路径所包含的路径数量
        System.out.println("absolutePath里包含的路径数量："+absolutePath.getNameCount());
        //以多个String来构建Path对象
        Path paths = Paths.get("D:", "publish", "codes");
        System.out.println(paths);
    }
}
