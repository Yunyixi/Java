package io;

import java.io.File;
import java.io.FilenameFilter;

public class FileLei02 {
    public static void main(String[] args) {
        File file = new File("D:\\Documents\\Java\\src\\io");
        //创建过滤器对象
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File currFile = new File(dir, name);
                if (currFile.isFile() && name.endsWith(".java")) {
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
}
