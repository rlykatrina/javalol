package mvc.services.SweetService;

import box.Box;
import mvc.Deserializator;
import mvc.Serializator;
import sweet.ChocolateSweet;
import sweet.FruitSweet;
import sweet.Sweet;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class SweetServiceImpl implements SweetService {

    private Hashtable<Integer, Sweet> sweetTable;
    private final String fileName = "src\\usedFiles\\Sweet.bin";

    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }

    @Override
    public void saveData() {
        Serializator.serialization(sweetTable, fileName);
    }

    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.sweetTable = Deserializator.getHashtable(fileName);
        } catch (IOException | ClassNotFoundException e) {
            this.sweetTable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkSweetKey(Integer key) {
        if (sweetTable.containsKey(key)) {
            return true;
        } else {
            System.out.println("Wrong box key input!");
            return false;
        }
    }

    @Override
    public Sweet getSweet(Integer key) {
        return sweetTable.get(key);
    }

    @Override
    public void setFruitSweet(int id, String name, int price, double weight, int calories, String fruit) {
        sweetTable.put(id, new FruitSweet(name, price, weight, calories, fruit));
    }

    @Override
    public void setChocolateSweet(int id, String name, int price, double weight, int calories, String type) {
        sweetTable.put(id, new ChocolateSweet(name, price, weight, calories, type));
    }

    @Override
    public void removeSweet(Integer key) {
        if ((sweetTable.size() != 0) & (sweetTable.containsKey(key))) {
            sweetTable.remove(key);
        }
    }

    @Override
    public void showSweets() {
        System.out.println(sweetTable);
    }
}