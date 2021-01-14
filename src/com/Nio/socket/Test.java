package com.Nio.socket;

import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        NioClient nioClient = new NioClient();
        new Thread(){
            public void run() {
                while (true) {
                    try {
                        nioClient.receiveMsg();
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            nioClient.sendMsg(scanner.nextLine());
        }
    }
}
