package mvc.controllers;

import mvc.services.SweetService.SweetService;
import mvc.services.boxService.BoxService;
import mvc.services.decorationService.DecorationService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BoxController {
    private final BoxService boxService;
    private final SweetService sweetService;
    private final DecorationService decorationService;
    private final Scanner scanner;
    public final ExecutorService service;
    public BoxController(BoxService boxService,SweetService sweetService,DecorationService decorationService, Scanner scanner){
        this.boxService = boxService;
        this.sweetService = sweetService;
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
                boxService.saveData();
            }
        });
    }
    public void readData(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                boxService.readData();
            }
        });
    }
    public void closeThread(){
        service.shutdown();
    }

    public void setBox() {
        System.out.print("id of box: ");
        int id = listenInt();
        System.out.print("Material of box: ");
        String material = listenStr();
        System.out.print("Price of box: ");
        int price = listenInt();
        System.out.print("Weight of box: ");
        double weight = listenDouble();
        System.out.print("Width of box: ");
        int width = listenInt();
        System.out.print("Height of box: ");
        int height = listenInt();
        System.out.print("Length of box: ");
        int length = listenInt();

        boxService.setBox(id, material, price, weight, width, height, length);
    }
    public void removeBox(){
        System.out.print("id of box: ");
        int key = listenInt();

        boxService.removeBox(key);
    }
    public void addSweetInBox(){
        boxService.getBoxes();
        System.out.print("Number of box: ");
        Integer keyBox = listenInt();
        if (!boxService.checkBoxKey(keyBox)){
            return;
        }

        sweetService.showSweets();
        System.out.print("Number of sweet: ");
        Integer keySweet = listenInt();
        if (!sweetService.checkSweetKey(keySweet)){
            return;
        }

        boxService.addSweetInBox(sweetService.getSweet(keySweet), keyBox);
    }
    public void removeSweetFromBox(){
        boxService.getBoxes();
        System.out.print("Number of box: ");
        Integer keyBox = listenInt();
        if (!boxService.checkBoxKey(keyBox)){
            return;
        }

        sweetService.showSweets();
        System.out.print("Number of sweet: ");
        Integer keySweet = listenInt();
        if (!sweetService.checkSweetKey(keySweet)){
            return;
        }

        boxService.removeSweetFromBox(keyBox, sweetService.getSweet(keySweet));
    }
    public void addDecorationInBox(){
        boxService.getBoxes();
        System.out.println("Number of box: ");
        Integer keyBox = listenInt();
        if (!boxService.checkBoxKey(keyBox)){
            return;
        }

        decorationService.getDecorations();
        System.out.println("Number of decoration: ");
        Integer keyDecoration = listenInt();
        if (!decorationService.checkDecorationKey(keyDecoration)){
            return;
        }

        boxService.addDecorationInBox(decorationService.getDecoration(keyDecoration),keyBox);
    }
    public void removeDecorationFromBox(){
        boxService.getBoxes();
        System.out.print("Number of box: ");
        Integer keyBox = listenInt();
        if (!boxService.checkBoxKey(keyBox)){
            return;
        }

        decorationService.getDecorations();
        System.out.println("Number of decoration: ");
        Integer keyDecoration = listenInt();
        if (!decorationService.checkDecorationKey(keyDecoration)){
            return;
        }

        boxService.removeDecorationFromBox(keyBox, decorationService.getDecoration(keyDecoration));
    }

    public void getBoxes() {
        boxService.getBoxes();
    }
}
