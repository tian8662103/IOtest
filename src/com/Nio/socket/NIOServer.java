package com.Nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * 服务器端程序
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        new NIOServer().Server();

    }

    static Selector selector ;
    private  void Server()  {
        try {
            //1.得到一个ServerSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //2.得到选择器
            selector = Selector.open();
            //3.绑定端口号
            serverSocketChannel.bind(new InetSocketAddress(9999));
            //4.设置非阻塞方式
            serverSocketChannel.configureBlocking(false);
            //5.ServerSocketChannel注册给Selector 监听客户端是否连接服务器端
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            start(serverSocketChannel, selector);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void start(ServerSocketChannel serverSocketChannel, Selector selector)  {
        try {
            //6.
            while (true) {
                //监听客户端
                if (selector.select(2000) == 0) {
                    System.out.println("非阻塞");
                    continue;
                }
                //得到SelectionKey,判断通道里的事件
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey selectionKey = keyIterator.next();
                    if (selectionKey.isAcceptable()) {
                        //客户端连接事件
                        System.out.println("OP_ACCEPT");
                        SocketChannel accept = serverSocketChannel.accept();
                        accept.configureBlocking(false);
                        //新通道注册到选择器里
                        accept.register(selector, SelectionKey.OP_READ);
                    }
                    if (selectionKey.isReadable()) {
                        //读取客户端操作
                        readMsg(selectionKey);
/*                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                        channel.read(buffer);
                        System.out.println(new String(buffer.array()));*/

                    }

                    //手动从集合移除当前的Key，防止处理
                    keyIterator.remove();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //读取客户端发来的消息
    private static void readMsg(SelectionKey selectionKey) {
        try {
            //得到通道
            SocketChannel channel = (SocketChannel) selectionKey.channel();
            //读取数据
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int read = channel.read(buffer);
            if (read > 0) {
                System.out.println(new String(buffer.array()));
               //给所有的客户端发送消息
                broadCast(channel,new String(buffer.array()));
            }
        } catch (IOException e) {

        }


    }

    private static void broadCast(SocketChannel channel, String s) {
        try {
            System.out.println("服务器发送了广播。。。");
            for (SelectionKey selectionKey : selector.keys()) {
                Channel channel1 = selectionKey.channel();
                if (channel1 != channel && channel1 instanceof SocketChannel ) {
                    SocketChannel socketChannel = (SocketChannel) channel1;
                    ByteBuffer byteBuffer = ByteBuffer.wrap(s.getBytes());
                    socketChannel.write(byteBuffer);
                }
            }
        } catch (IOException e) {
        }

    }
}
