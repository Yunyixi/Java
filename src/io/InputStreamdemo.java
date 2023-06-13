package io;

import java.io.FileInputStream;

/**
 * 字节流inputStreamdemo读取文件的类
 */

public class InputStreamdemo {
    public static void main(String[] args) throws Exception {
        demo();
        System.out.println();
        demo01();
    }

    private static void demo() throws Exception {
        //创建字节输入流
        FileInputStream inputStream = new FileInputStream("D:\\Documents\\Java\\temp\\test.txt");
        int b = 0; //int char类型，通用的
        while (true) { //循环读取
            b = inputStream.read();
            if (b == -1) {
                break;
            }
            System.out.print((char) b);
        }
        inputStream.close();
    }

    private static void demo01() throws Exception {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("D:\\Documents\\Java\\temp\\test.txt");
            if (1 == 1) {
                /*throw new Exception("抛出异常");
                int c = 0;*/
                while (true) {
                    int c = inputStream.read();
                    if (c == -1) {
                        break;
                    }
                    System.out.print((char) c);
                }
            }
        } finally {
            System.out.println();
            System.out.println("无论如何都会跑到这里，资源关闭");
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
