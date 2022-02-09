package View;
import java.io.*;

public class Printer {
    private static OutputStream outputStream;
    public static void print(String msg){
        System.out.print(msg);
        }

    public static void printInFile(String msg, int count) throws IOException {
        String path = "info.txt";
        if(count ==0){
            outputStream = new FileOutputStream(path);

        }
        outputStream = new FileOutputStream(path, true);

        outputStream.write(msg.getBytes());
        outputStream.close();

    }

}
