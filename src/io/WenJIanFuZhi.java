package io;

import java.io.*;

/**
 * 字节流文件复制
 */

public class WenJIanFuZhi {
    public static void main(String[] args) throws Exception {
        demo00(); //比较慢的复制
        System.out.println();
        demo01();

    }

    private static void demo00() throws Exception {
        long begin = System.currentTimeMillis();
        //文件复制
        InputStream inputStream = new FileInputStream("D:\\Documents\\Java\\temp\\test.txt");
        OutputStream outputStream = new FileOutputStream("D:\\Documents\\Java\\temp\\demo00.txt");
        int len;
        while ((len = inputStream.read()) != -1) {
            outputStream.write(len);
        }
        inputStream.close();
        outputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("已完成 总耗时：" + (end - begin) + "毫秒");
    }

    private static void demo01() throws Exception {
        long begin = System.currentTimeMillis();
        //文件复制
        InputStream inputStream = new FileInputStream("D:\\Documents\\Java\\temp\\test.txt");
        OutputStream outputStream = new FileOutputStream("D:\\Documents\\Java\\temp\\Demo01.txt");
        byte[] bytes = new byte[1024]; //缓冲区，每次读取1024字节
        int len;
        while ((len = inputStream.read()) != -1) {
            outputStream.write(bytes, 0, len);
        }
        inputStream.close();
        outputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("已完成 总耗时：" + (end - begin) + "毫秒");
    }
}
