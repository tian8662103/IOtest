package com.randomAccess;

import java.io.*
;

public class InsertContent {
    public static void insert(String fileName, long pos, String inserContent) throws IOException {
        File tmp = File.createTempFile("tmp", null);
        //注册一个删除钩子
        tmp.deleteOnExit();
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
             FileOutputStream tmpOut = new FileOutputStream(tmp);
             FileInputStream tmpIn = new FileInputStream(tmp)) {
            raf.seek(pos);
            //下面代码将插入点后的内容读入临时文件中保存
            byte[] bytes = new byte[1024];
            int hasRead = 0;
            while ((hasRead = raf.read(bytes)) > 0) {
                tmpOut.write(bytes,0,hasRead);
            }
            //将指针重新定位到pos位置
            raf.seek(pos);
            //追加指定的内容
            raf.write(inserContent.getBytes());
            while ((hasRead = tmpIn.read(bytes)) > 0) {
                raf.write(bytes, 0, hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        insert("D:\\SSMDemo\\IOText\\src\\com\\randomAccess\\InsertContent.java",45,"插入的内容\r\n");
    }
}
