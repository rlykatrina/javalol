package mvc.services.boxService;

import box.Box;
import decoration.Decoration;
import mvc.Deserializator;
import mvc.Serializator;
import sweet.ChocolateSweet;
import sweet.FruitSweet;
import sweet.Sweet;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class BoxServiceImpl implements BoxService {
    private Hashtable<Integer, Box> boxTable;
    private final String fileName = "src\\usedFiles\\Box.bin";
    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }

    @Override
    public void saveData() {
        Serializator.serialization(boxTable, fileName);
    }

    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.boxTable = Deserializator.getHashtable(fileName);
        } catch (IOException|ClassNotFoundException e) {
            this.boxTable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkBoxKey(Integer key) {
        if (boxTable.containsKey(key)){
            return true;
        }else {
            System.out.println("Wrong box key input!");
            return false;
        }
    }

    @Override
    public Box getBox(Integer key) {
        return boxTable.get(key);
    }

    @Override
    public void setBox(int id, String material, int price, double weight, int width, int length, int height) {
        boxTable.put(id, new Box(material, price, weight, width, length, height));
    }

    @Override
    public void removeBox(Integer key) {
        if ((boxTable.size() != 0) & (boxTable.containsKey(key))) {
            boxTable.remove(key);
        }
    }

    @Override
    public void addSweetInBox(Sweet sweet, Integer keyBox) {
        boxTable.get(keyBox).appendSweet(sweet);
    }


    @Override
    public void removeSweetFromBox(Integer keyBox, Sweet keySweet) {
        boxTable.get(keyBox).removeSweet(keySweet);
    }

    @Override
    public void addDecorationInBox(Decoration decoration, Integer keyBox) {
        boxTable.get(keyBox).appendDecoration(decoration);
    }

    @Override
    public void removeDecorationFromBox(Integer keyBox,  Decoration keyDecoration) {
        boxTable.get(keyBox).removeDecoration(keyDecoration);
    }

    @Override
    public void getBoxes() {
        System.out.println(boxTable);
    }
}
