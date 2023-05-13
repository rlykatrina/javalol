package sweet;

public class ChocolateSweet extends Sweet {
    private String chocolate;
    public ChocolateSweet(String name, int price, double weight, int calories, String chocolate){
        super(name, price, weight, calories);
        this.chocolate = chocolate;
    }
    public String toString(){
        return "Name of sweet: " + this.name + "\n" + "Calories: " + this.calories + "\n" + "Price: " + this.getPrice() + "\n" + "Type of chocolate: " + chocolate;
    }

    @Override
    public String getType() {
        return "Type of sweet: " + chocolate;
    }
}
