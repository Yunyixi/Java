package iozifuliu;

import java.io.*;

public class ZiFuLiuDemo {
    public static void main(String[] args) throws IOException {
        //字符流的读写
        FileWriter fileWriter = new FileWriter("D:\\Documents\\Java\\temp\\zifuliudemo.txt");
        String string = "柳职云计算";
        fileWriter.write(string);
        fileWriter.write("\r\n");
        fileWriter.close();
    }
}
