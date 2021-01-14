package com.Nio;

import java.nio.CharBuffer;

/**
 * Buffer的使用
 */
public class BufferTest {
    public static void main(String[] args) {
        //创建buffer
        CharBuffer charBuffer = CharBuffer.allocate(8);
        System.out.println("capacity:"+charBuffer.capacity());
        System.out.println("limit:"+charBuffer.limit());
        System.out.println("position:"+charBuffer.position());
        //放入数据
        charBuffer.put('a');
        charBuffer.put('b');
        charBuffer.put('c');
        System.out.println("放入三个元素后，position = "+charBuffer.position());
        //调用flip方法
        charBuffer.flip();//此方法吧 position位置变会初始位置
        System.out.println("执行flip()方法后 limit = "+charBuffer.limit());
        System.out.println("position = "+charBuffer.position());
        //取出第一个元素
        System.out.println("第一个元素(position = 0)："+charBuffer.get());
        System.out.println("取出第一个元素后，position="+charBuffer.position());
        //调用clear() 此方法是将position置为0 将limit置为 capacity
        charBuffer.clear();
        System.out.println("执行clear()后，limit="+charBuffer.limit());
        System.out.println("执行clear()后，position="+charBuffer.position());
        System.out.println("执行clear()后，缓冲区内容并没有被清除："+"第三个元素为："+charBuffer.get(2));
        System.out.println("执行绝对读取后，position="+charBuffer.position());
    }
}
