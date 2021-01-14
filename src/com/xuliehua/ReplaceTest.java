package com.xuliehua;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReplaceTest {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\object.txt"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\object.txt"))){
            Person person = new Person("孙悟空", 500);
            oos.writeObject(person);
            ArrayList list = (ArrayList) ois.readObject();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
