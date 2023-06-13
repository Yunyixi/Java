package io;

import java.io.File;
import java.io.IOException;

public class FileLei01 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Documents\\Java\\temp\\Demo01.txt");
        System.out.println(file);
        System.out.println("文件是否存在：" + file.exists());
        if (!file.exists()) { //如果该文件不存在，则创建这个文件
            file.createNewFile();
        }
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println("file是否文件：" + file.isFile());
        System.out.println("file是否目录：" + file.isDirectory());

        File file1 = new File("D:\\Documents\\Java\\temp");
        System.out.println(file1.getParentFile());
        System.out.println("file是否文件：" + file1.isFile());
        System.out.println("file是否目录：" + file1.isDirectory());
        String[] list = file1.list();
        for (String str : list) {
            System.out.println(str);
        }
        FileLei02();
    }

    public static void FileLei02() throws IOException {
        //判断目录、文件是否存在，不存在就创建目录和文件
        File file = new File("D:\\Documents\\Java\\temp\\demo0.txt");
        System.out.println(file.getParentFile());
        if (!(file.getParentFile().exists())) { //判断目录是否存在
            file.getParentFile().mkdir(); //创建目录
        }
        if (!file.exists()) { //文件不存在，创建文件
            System.out.println("创建文件：" + file.createNewFile());
        }
    }
}
