package sweet;

public class FruitSweet extends Sweet {
    private String fruit;
    public FruitSweet(String name, int price, double weight, int calories, String fruit) {
        super(name, price, weight, calories);
        this.fruit = fruit;
    }

    public String toString() {
        return "Name of sweet: " + this.name + "\n" + "Calories: " + this.calories + "\n" + "Price: " + this.getPrice() + "\n" + "Name of fruit: " + fruit;
    }

    @Override
    public String getType() {
        return "Type of sweet: " + fruit;
    }
}
