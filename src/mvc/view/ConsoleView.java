package mvc.view;

import box.Box;
import mvc.controllers.BoxController;
import mvc.controllers.DecorationController;
import mvc.controllers.SweetController;
import mvc.services.SweetService.SweetService;
import mvc.services.boxService.BoxService;
import mvc.services.decorationService.DecorationService;

import java.util.Scanner;

public class ConsoleView implements View {
    private final SweetController sweetController;
    private final DecorationController decorationController;
    private final BoxController boxController;
    private boolean flag;

    public ConsoleView(SweetController sweetController, DecorationController decorationController, BoxController boxController) {
        this.sweetController = sweetController;
        this.decorationController = decorationController;
        this. boxController = boxController;
        this.flag = true;
    }

    @Override
    public int listen() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public void init() {
        while (this.flag) {
            showMenu();
        }
    }

    @Override
    public void saveChanges() {
        sweetController.saveChanges();
        boxController.saveChanges();
        decorationController.saveChanges();
    }

    @Override
    public void readData() {
        sweetController.readData();
        boxController.readData();
        decorationController.readData();
    }

    @Override
    public void closeThread() {
        sweetController.closeThread();
        boxController.closeThread();
        decorationController.closeThread();
    }

    @Override
    public void showMenu() {
        System.out.println("Menu:");
        System.out.println("-> 1: Sweets");
        System.out.println("-> 2: Boxes");
        System.out.println("-> 3: Decorations");
        System.out.println("-> 4: Save");
        System.out.println("-> 5: Read");
        System.out.println("-> 0: Close app");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                this.flag = false;
                this.closeThread();
                return;
            }
            case 1 -> showSweets();
            case 2 -> showBoxes();
            case 3 -> showDecorations();
            case 4 -> this.saveChanges();
            case 5 -> this.readData();
            default -> showMenu();
        }
    }

    @Override
    public void showSweets() {
        System.out.println("Sweets Menu:");
        System.out.println("-> 1: Add Sweet");
        System.out.println("-> 2: Remove Sweet");
        System.out.println("-> 3: Show Sweets");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> sweetController.setSweet();
            case 2 -> sweetController.removeSweet();
            case 3 -> sweetController.showSweets();
            default -> showMenu();
        }
    }

    @Override
    public void showBoxes() {
        System.out.println("Boxes Menu:");
        System.out.println("-> 1: Add Box");
        System.out.println("-> 2: Remove Box");
        System.out.println("-> 3: Add sweet for Box");
        System.out.println("-> 4: Remove sweet in Box");
        System.out.println("-> 5: Add decoration for Box");
        System.out.println("-> 6: Remove decoration in Box");
        System.out.println("-> 7: Show Boxes");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> boxController.setBox();
            case 2 -> boxController.removeBox();
            case 3 -> boxController.addSweetInBox();
            case 4 -> boxController.removeSweetFromBox();
            case 5 -> boxController.addDecorationInBox();
            case 6 -> boxController.removeDecorationFromBox();
            case 7 -> boxController.getBoxes();
            default -> showMenu();
        }
    }

    @Override
    public void showDecorations() {
        System.out.println("Decorations Menu:");
        System.out.println("-> 1: Add Decoration");
        System.out.println("-> 2: Remove Decoration");
        System.out.println("-> 3: Show Decorations");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> decorationController.setDecoration();
            case 2 -> decorationController.removeDecoration();
            case 3 -> decorationController.getDecorations();
            default -> showMenu();
        }
    }
}
