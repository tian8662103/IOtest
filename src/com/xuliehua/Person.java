package com.xuliehua;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Person implements Externalizable {
    private String name;
    private int age;
//    private transient int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

/*
    private void writeObject(java.io.ObjectOutputStream outputStream) throws IOException {
        outputStream.writeObject(new StringBuffer(name).reverse());
        outputStream.writeInt(age);
    }

    private void readObject(java.io.ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        this.name = ((StringBuffer)inputStream.readObject()).reverse().toString();
        this.age = inputStream.readInt();
    }

    //在序列化是将Person对象替换成ArrayList
    private Object writeReplace() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(name);
        list.add(age);
        return list;
    }
*/

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = ((StringBuffer)in.readObject()).reverse().toString();
        this.age = in.readInt();
    }

    public Person() {
    }
}
