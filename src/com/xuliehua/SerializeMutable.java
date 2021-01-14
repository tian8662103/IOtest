package com.xuliehua;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeMutable {
    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\mutable.txt"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\mutable.txt"))) {
            Person person = new Person("孙悟空", 500);
            oos.writeObject(person);
            person.setName("猪八戒");
            oos.writeObject(person);
            Person p1 = (Person) ois.readObject();
            Person p2 = (Person) ois.readObject();
            System.out.println(p1 == p2);
            System.out.println(p2.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
