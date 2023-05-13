package mvc.services.boxService;

import box.Box;
import decoration.Decoration;
import sweet.ChocolateSweet;
import sweet.FruitSweet;
import sweet.Sweet;

public interface BoxService {
    void saveData();
    void readData();
    boolean checkBoxKey(Integer key);
    Box getBox(Integer key);
    void setBox(int id, String material, int price, double weight, int width, int length, int height);
    void removeBox(Integer key);
    void addSweetInBox(Sweet sweet, Integer keyBox);
    void removeSweetFromBox(Integer keyBox, Sweet keySweet);
    void addDecorationInBox(Decoration decoration, Integer keyBox);
    void removeDecorationFromBox(Integer keyBox, Decoration decorationKey);
    void getBoxes();
}
