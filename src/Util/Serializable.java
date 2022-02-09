package Util;

import Model.Entity.Sweet;
import View.Printer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializable {
    public static void serializable(List<Sweet> sweets){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.txt"))) {
            outputStream. writeObject(sweets);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void deserializable(List<Sweet> sweets) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data.txt"))) {
            sweets = (List<Sweet>) inputStream.readObject();
            for(List<Sweet> item : sweets){
            Printer.print(item+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
