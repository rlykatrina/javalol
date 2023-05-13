package mvc;

import java.io.*;
import java.util.Hashtable;

public class Deserializator {
    private static Hashtable<Integer, Object> newHashTable;

    public static void deserialization(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);

        newHashTable = (Hashtable) ois.readObject();

        ois.close();
        fis.close();
    }

    public static Hashtable getHashtable(String filename) throws IOException, ClassNotFoundException {
        deserialization(filename);
        return newHashTable;
    }
}
