package com.xuliehua;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadTeacher {
    public static void main(String[] args) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\teacher.txt"))) {
            Teacher t1 = (Teacher) ois.readObject();
            Teacher t2 = (Teacher) ois.readObject();
            Person p = (Person) ois.readObject();
            Teacher t3 = (Teacher) ois.readObject();
            System.out.println("t1的student引用和P是否相同："+(t1.getPerson() == p));
            System.out.println("t2的student引用和P是否相同："+(t2.getPerson() == p));
            System.out.println("t2和t3是否是同一个对象："+(t2 == t3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
