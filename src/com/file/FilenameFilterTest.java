package com.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * FilenameFilter 文件过滤
 *
 */
public class FilenameFilterTest {
    public static void main(String[] args) {
        File file = new File(".");
        //使用lambda表达式 FilenameFilter实现文件过滤器
        //如果文件名以.java结尾，或者文件对应一个路径，则返回true
        //String方法 boolean endsWith 测试此字符串是否以指定的后缀结束。
        String[] nameList = file.list((dir, name) -> name.endsWith(".java") ||
                new File(name).isDirectory());
        for (String s : nameList) {
            System.out.println(s);
        }
    }
}
