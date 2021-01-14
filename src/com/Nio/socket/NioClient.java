package com.Nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * 网络客户端程序
 */
public class NioClient {
    public static void main(String[] args) throws IOException {


    }

    SocketChannel socketChannel;
    public  NioClient() throws IOException {
        //1.创建通道
        socketChannel = SocketChannel.open();
        //2.设置阻塞方式 非阻塞方式
        socketChannel.configureBlocking(false);
        //3.连接服务器端
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 9999);
        if (!socketChannel.connect(inetSocketAddress) ) {
            while (!socketChannel.finishConnect()) {
                System.out.println("Client:连接服务器端同时，还可以做其他事情");
            }
        }
    }

    //向服务器发数据
    public void sendMsg(String msg) {
        try {
            if (msg.equals("bye")) {
                socketChannel.close();
                return;
            }
            ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
            socketChannel.write(buffer);

        } catch (IOException e) {

        }
    }

    //接受服务器端数据
    public void receiveMsg() {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int size = socketChannel.read(buffer);
            if (size > 0) {
                String msg = new String(buffer.array());
                System.out.println(msg.trim());
            }
        } catch (IOException e) {

        }

    }
}