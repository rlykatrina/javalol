package mvc.controllers;

import mvc.services.SweetService.SweetService;
import mvc.services.decorationService.DecorationService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SweetController {
    private final SweetService sweetService;
    private final Scanner scanner;
    public final ExecutorService service;
    public SweetController(SweetService sweetService, Scanner scanner){
        this.sweetService = sweetService;
        this.scanner = scanner;
        service = Executors.newFixedThreadPool(2);
    }
    public int listenInt() {
        return scanner.nextInt();
    }
    public double listenDouble(){return scanner.nextDouble();}

    public String listenStr() {
        return scanner.next();
    }

    public void saveChanges(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                sweetService.saveData();
            }
        });
    }
    public void readData(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                sweetService.readData();
            }
        });
    }
    public void closeThread(){
        service.shutdown();
    }
    public void setSweet(){
        System.out.println("id of sweet: ");
        int id = listenInt();
        System.out.println("name of sweet: ");
        String name = listenStr();
        System.out.println("price of sweet: ");
        int price = listenInt();
        System.out.println("weight of sweet: ");
        double weight = listenDouble();
        System.out.println("calories of sweet: ");
        int calories = listenInt();
        System.out.println("write 0 -> chocolate\n\t1 -> fruit");
        int sweetType = listenInt();
        if (sweetType == 0){
            System.out.println("type of chocolate: ");
            String type = listenStr();
            sweetService.setChocolateSweet(id, name, price, weight, calories, type);}
        else if(sweetType == 1){
            System.out.println("type of fruit: ");
            String fruit = listenStr();
            sweetService.setFruitSweet(id, name, price, weight, calories, fruit);
        }
        else {
            System.out.println("wrong number");
            return;
        }
    }
    public void removeSweet(){
        System.out.print("id of sweet: ");
        int key = listenInt();

        sweetService.removeSweet(key);
    }
    public void showSweets(){
        sweetService.showSweets();
    }
}
