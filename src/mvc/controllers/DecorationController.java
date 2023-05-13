package mvc.controllers;

import decoration.Decoration;
import mvc.services.SweetService.SweetService;
import mvc.services.boxService.BoxService;
import mvc.services.decorationService.DecorationService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DecorationController {
    private final DecorationService decorationService;
    private final Scanner scanner;
    public final ExecutorService service;
    public DecorationController(DecorationService decorationService, Scanner scanner){
        this.decorationService = decorationService;
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
                decorationService.saveData();
            }
        });
    }
    public void readData(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                decorationService.readData();
            }
        });
    }
    public void closeThread(){
        service.shutdown();
    }
    public void setDecoration(){
        System.out.println("id of decoration: ");
        int id = listenInt();
        System.out.println("colour of decoration: ");
        String colour = listenStr();
        System.out.println("pattern of decoration: ");
        String pattern = listenStr();
        System.out.println("price of decoration: ");
        int price = listenInt();
        System.out.println("weight of decoration: ");
        double weight = listenDouble();

        decorationService.setDecoration(id, colour, pattern, price, weight);
    }
    public void removeDecoration(){
        System.out.print("id of decoration: ");
        int key = listenInt();

        decorationService.removeDecoration(key);
    }
    public void getDecorations(){
        decorationService.getDecorations();
    }
}
