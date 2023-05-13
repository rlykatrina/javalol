package box;

import decoration.Decoration;
import sweet.FruitSweet;
import sweet.Sweet;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Класс упаковки со свойствами material, price, weight, length, width, height, decorations, sweets
 *
 * @author Koykov
 * @version 1.0
 */
public class Box implements BoxInterface, Serializable {
    /**
     * Поле материала
     */
    protected String material;
    /**
     * Поле цена
     */
    protected int price;
    /**
     * Поле вес
     */
    protected double weight;
    /**
     * Поле длина
     */
    protected int length;
    /**
     * Поле ширина
     */
    protected int width;
    /**
     * Поле высота
     */
    protected int height;
    protected ArrayList<Decoration> decorations;
    protected ArrayList<Sweet> sweets;
    public Box(String material, int price, double weight, int width, int length, int height) {
        this.material = material;
        this.price = price;
        this.weight = weight;
        this.width = width;
        this.length = length;
        this.height = height;
        this.decorations = new ArrayList<>();
        this.sweets = new ArrayList<>();
    }
    public ArrayList<Sweet> getSweets() {
        return sweets;
    }
    public ArrayList<Decoration> getDecorations() {
        return decorations;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String toString(){
        return "Box material: " + this.getMaterial() + "\n" +
                "Box price: " + this.calculatePrice()+ "\n" +
                "Box calories: " + this.calculateCalories();
    }
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }
    @Override
    public void appendSweet(Sweet sweet) {
        this.sweets.add(sweet);
    }

    @Override
    public void removeSweet(Sweet sweet) {
        this.sweets.remove(sweet);
    }
    @Override
    public void appendDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }
    @Override
    public void removeDecoration(Decoration decoration) {
        this.decorations.remove(decoration);
    }
    @Override
    public double calculatePrice() {
        double totalPrice = this.price;
        for (var x: this.decorations){
            totalPrice +=x.getPrice();
        }
        for (var x: this.sweets){
            totalPrice +=x.getPrice();
        }
        return totalPrice;
    }
    @Override
    public double calculateWeight() {
        double totalWeight = this.weight;
        for (var x: this.decorations){
            totalWeight +=x.getWeight();
        }
        for (var x: this.sweets){
            totalWeight +=x.getWeight();
        }
        return totalWeight;
    }
    @Override
    public double calculateVolume(){
        return this.getLength() * this.getWidth() * this.getHeight();
    }
    @Override
    public double calculateCalories() {
        double totalCalories = 0;
        for (var x: this.sweets){
            totalCalories +=x.getCalories();
        }
        return totalCalories;
    }
}