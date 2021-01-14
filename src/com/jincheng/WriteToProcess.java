package com.jincheng;

import java.io.*;
import java.util.Scanner;

public class WriteToProcess {
    public static void main(String[] args) throws IOException {
        Process process = Runtime.getRuntime().exec("java ReadStandard");
        try (PrintStream printStream = new PrintStream(process.getOutputStream())){
            printStream.println("普通字符串");
            printStream.println(new WriteToProcess());
        } catch (Exception e) {
        }
    }
}

class ReadStandard {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             PrintStream printStream = new PrintStream(new FileOutputStream("D:\\out.txt"))) {
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                printStream.println("键盘输入内容是："+scanner.next());
            }
        } catch (Exception e) {

        }
    }
}
