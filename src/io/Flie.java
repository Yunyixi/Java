package io;


import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

/**
 * 用i/o实现一个文件管理器
 * p170页练习
 * File类的使用判断文件和目录是否存在，文件的创建与删除
 */
public class Flie {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("--- 欢迎使用批量文件管理器 ---");
            System.out.println("输入1：指定关键字检索文件");
            System.out.println("输入2：指定后缀名检索文件");
            System.out.println("输入3：删除文件/目录");
            System.out.println("输入4：退出");
            System.out.println("--------------------------");
            int n = scanner.nextInt();
            if (n == 1) {
                getFilesBykey();
            } else if (n == 2) {
                getFileSuffix();
            }
            if (n == 3) {
                System.out.println("请输入你要删除的文件和目录");
                String path = scanner.next();
                File file = new File(path);
                getDelete(file);
            } else if (n == 4) {
                return;
            }
        }

    }

    //检索的目录和关键字
    public static void getFilesBykey() {
        System.out.println("请输入你要检索的目录");
        String path = scanner.next();
        System.out.println("请输入你要检索的关键字");
        String key = scanner.next();
        File file = new File(path);
        //创建过滤器对象
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File currFile = new File(dir, name);
                if (currFile.isFile() && name.contains(key)) {
                    return true;
                }
                return false;
            }
        };
        //存在并且是一个目录
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list(filenameFilter);
            for (String name : list) {
                System.out.println(name);
            }
        }
    }


    public static void getFileSuffix() {
        System.out.println("请输入你要检索的目录");
        String path = scanner.next();
        System.out.println("请输入你要检索的文件的后缀名");
        String key = scanner.next();
        File file = new File(path);
        //创建过滤器对象
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File currFile = new File(dir, name);
                if (currFile.isFile() && name.endsWith(key)) {
                    return true;
                }
                return false;
            }
        };
        //存在并且是一个目录
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list(filenameFilter);
            for (String name : list) {
                System.out.println(name);
            }
        }
    }

    //删除文件
    public static void getDelete(File dir) {
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    getDelete(file);
                } else {
                    file.delete();
                }
            }
            dir.delete();
        }
    }

}
