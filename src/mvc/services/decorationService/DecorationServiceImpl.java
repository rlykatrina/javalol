package mvc.services.decorationService;

import box.Box;
import decoration.Decoration;
import mvc.Deserializator;
import mvc.Serializator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class DecorationServiceImpl implements DecorationService {
    private Hashtable<Integer, Decoration> decorationTable;
    private final String fileName = "src\\usedFiles\\Decoration.bin";
    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }
    @Override
    public void saveData() {
        Serializator.serialization(decorationTable, fileName);
    }
    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.decorationTable = Deserializator.getHashtable(fileName);
        } catch (IOException|ClassNotFoundException e) {
            this.decorationTable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkDecorationKey(Integer key) {
        if (decorationTable.containsKey(key)){
            return true;
        }else {
            System.out.println("Wrong box key input!");
            return false;
        }
    }

    @Override
    public Decoration getDecoration(Integer key) {
        return decorationTable.get(key);
    }

    @Override
    public void setDecoration(int id, String colour, String pattern, int price, double weight) {
        decorationTable.put(id, new Decoration(colour, pattern, price, weight));
    }

    @Override
    public void removeDecoration(Integer key) {
        if ((decorationTable.size() != 0) & (decorationTable.containsKey(key))) {
            decorationTable.remove(key);
        }
    }

    @Override
    public void getDecorations() {
        System.out.println(decorationTable);
    }
}
