package mvc.services.SweetService;

import sweet.Sweet;

public interface SweetService {
    void saveData();
    void readData();
    boolean checkSweetKey(Integer key);
    Sweet getSweet(Integer key);
    void setFruitSweet(int id, String name, int price, double weight, int calories, String fruit);
    void setChocolateSweet(int id, String name, int price, double weight, int calories, String type);
    void removeSweet(Integer key);
    void showSweets();
}