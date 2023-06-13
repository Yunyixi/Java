package io;


import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 字节流outputStreamDemo在文件中写入数据的类
 */
public class OutputStreamDemo {
    public static void main(String[] args) throws Exception {
        demo00();

    }

    //写入文本到那个文件
    private static void demo00() throws Exception {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("D:\\Documents\\Java\\temp\\test.txt");
            String string = "柳职云计算";
            byte[] bytes = string.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                outputStream.write(bytes[i]);
            }
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

}
