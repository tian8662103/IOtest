package com.Nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {
    public static void main(String[] args) {
        File file = new File("D:\\SSMDemo\\IOText\\src\\com\\Nio\\FileChannelTest.java");
        try (FileChannel fis = new FileInputStream(file).getChannel();
             FileChannel fos = new FileOutputStream("D:\\a.txt").getChannel()) {
            //将FileChannel
            MappedByteBuffer map = fis.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            //使用GBK的字符集来创建解码器
            Charset gbk = Charset.forName("GBK");
            //直接将buff里数据全部输出
            fos.write(map);
            //再次调用buff的clear方法，复原limit、position的位置
            map.clear();
            //创建解码器
            CharsetDecoder charsetDecoder = gbk.newDecoder();
            //使用解码器将ByteBuffer转换成CharBuffer
            CharBuffer charBuffer = charsetDecoder.decode(map);
            //CharBuffer的toString方法可以获取对应的字符串
            System.out.println(charBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
