package com.Nio.charset;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;

public class CharsetTest {
    public static void main(String[] args) {
        //获取Java支持的所有字符集
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> entries = charsets.entrySet();
        for (Map.Entry<String, Charset> entry : entries) {
            System.out.println(entry.getKey()+"=="+entry.getValue());
        }
        System.out.println("======================================================");
        Properties properties = System.getProperties();
        Set<Map.Entry<Object, Object>> set = properties.entrySet();
        for (Map.Entry<Object, Object> objectObjectEntry : set) {
            System.out.println(objectObjectEntry.getKey()+"="+objectObjectEntry.getValue());
        }
    }
}
