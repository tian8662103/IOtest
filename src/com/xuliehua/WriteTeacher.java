package com.xuliehua;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteTeacher {
    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\teacher.txt"))) {
            Person person = new Person("孙悟空", 500);
            Teacher t1 = new Teacher("唐僧", person);
            Teacher t2 = new Teacher("菩提老祖", person);
            oos.writeObject(t1);
            oos.writeObject(t2);
            oos.writeObject(person);
            oos.writeObject(t2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
