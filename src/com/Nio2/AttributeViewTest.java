package com.Nio2;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.Date;
import java.util.List;

/**
 * 访问文件属性
 */
public class AttributeViewTest {
    public static void main(String[] args) throws IOException {
        //获取将要操作的文件
        Path path = Paths.get("D:\\SSMDemo\\IOText\\src\\com\\Nio2\\AttributeViewTest.java");
        //获取访问基本属性的BasicFileAttributeView
        BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        //获取访问基本属性的BasicFileAttributeView
        BasicFileAttributes basicFileAttributes = basicFileAttributeView.readAttributes();
        //访问文件的基本属性
        System.out.println("创建时间："+new Date(basicFileAttributes.creationTime().toMillis()));
        System.out.println("最后访问时间："+new Date(basicFileAttributes.lastAccessTime().toMillis()));
        System.out.println("最后修改时间："+new Date(basicFileAttributes.lastModifiedTime().toMillis()));
        //获取访问文件属主信息的FileOwnerAttributeView
        FileOwnerAttributeView ownerView = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
        //获取文件所属的用户
        System.out.println(ownerView.getOwner());
        //获取系统中guest对应的用户
        UserPrincipal user = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("guest");
        //修改用户
        ownerView.setOwner(user);
        //获取访问自定义属性FileOwnerAttributeView
        UserDefinedFileAttributeView userView = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
        List<String> attrName = userView.list();
        //便利自定义属性
        for (String name : attrName) {
            ByteBuffer buffer = ByteBuffer.allocate(userView.size(name));
            userView.read(name, buffer);
            buffer.flip();
            String value = Charset.defaultCharset().decode(buffer).toString();
            System.out.println(name + "--->" + value);
        }
        //添加一个自定义属性
        userView.write("发行者",Charset.defaultCharset().encode("疯狂Java联盟"));
        //获取访问DOS属性的DosFileAttributeView
        DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        //将文件设置隐藏、只读
        dosView.setHidden(true);
        dosView.setReadOnly(true);
    }
}
