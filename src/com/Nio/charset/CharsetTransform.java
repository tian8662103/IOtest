package com.Nio.charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransform {
    public static void main(String[] args) throws CharacterCodingException {
        //创建简体中文对应的Charset
        Charset gbk = Charset.forName("GBK");
        //获取gdk对象对应的编码器和解码器
        CharsetEncoder charsetEncoder = gbk.newEncoder(); //编码器
        CharsetDecoder charsetDecoder = gbk.newDecoder(); //解码器
        //创建一个CharBuffer对象
        CharBuffer charBuffer = CharBuffer.allocate(8);
        charBuffer.put('孙');
        charBuffer.put('悟');
        charBuffer.put('空');
        charBuffer.flip();
        //将CharBuffer中的字符序列转换成字节序列
        ByteBuffer byteBuffer = charsetEncoder.encode(charBuffer);
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            System.out.println(byteBuffer.get(i) + "");
        }
        //将byteBuffer解码成字符序列
        System.out.println(charsetDecoder.decode(byteBuffer));
    }
}
