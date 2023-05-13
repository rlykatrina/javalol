package sweet;

import java.io.Serializable;
import java.util.Objects;
public abstract class Sweet implements Serializable {
    protected String name;
    protected int price;
    protected double weight;
    protected int calories;
    public Sweet(String name, int price, double weight, int calories)
    {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.calories = calories;
    }
    public abstract String getType();
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public int getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweet sweet = (Sweet) o;
        return price == sweet.price && Double.compare(sweet.weight, weight) == 0 && calories == sweet.calories && name.equals(sweet.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight, calories);
    }
}
