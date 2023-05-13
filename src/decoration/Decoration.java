package decoration;

import java.io.Serializable;

public class Decoration implements Serializable {

    protected String colour;
    protected String pattern;
    protected int price;
    protected double weight;
    public Decoration(String colour, String pattern, int price, double weight)
    {
        this.colour = colour;
        this.pattern = pattern;
        this.price = price;
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public String getPattern() {
        return pattern;
    }
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    public String toString(){
        return "Colour: "+ this.colour + "\n" +
        "Pattern: " + this.pattern + "\n" +
        "Price: " + this.price;
    }
}
