package com.xuliehua;

import java.io.FileInputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\object.txt"))) {
            ois.setObjectInputFilter((info)->{
                System.out.println("=====执行数据过滤=====");
                ObjectInputFilter serialFilter = ObjectInputFilter.Config.getSerialFilter();
                if (serialFilter != null) {
                    ObjectInputFilter.Status status = serialFilter.checkInput(info);
                    //如果默认检查的结果不是Status.UNDECIDED
                    if (status != ObjectInputFilter.Status.UNDECIDED) {
                        return status;
                    }
                    //如果要恢复的对象不是1个
                    if (info.references() != 1) {
                        //不允许恢复对象
                        return ObjectInputFilter.Status.REJECTED;
                    }
                    //如果恢复的不是Person类
                    if (info.serialClass() != null && info.serialClass() != Person.class) {
                        //不允许恢复对象
                        return ObjectInputFilter.Status.REJECTED;
                    }
                }
                return ObjectInputFilter.Status.UNDECIDED;
            });
            Person p = (Person) ois.readObject();
            System.out.println("名字为："+p.getName()+"\n年龄为："+p.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
