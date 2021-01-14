package com.xuliehua;

import java.io.*;

public class TransientTest {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\object.txt"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\object.txt"))) {
            Person person = new Person("孙悟空", 500);
            oos.writeObject(person);
            Person p = (Person) ois.readObject();
            System.out.println(p.getName()+"==="+p.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
