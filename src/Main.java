import mvc.controllers.BoxController;
import mvc.controllers.DecorationController;
import mvc.controllers.SweetController;
import mvc.services.SweetService.SweetServiceImpl;
import mvc.services.boxService.BoxServiceImpl;
import mvc.services.decorationService.DecorationService;
import mvc.services.decorationService.DecorationServiceImpl;
import mvc.view.ConsoleView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SweetServiceImpl sweetService = new SweetServiceImpl();
        DecorationServiceImpl decorationService = new DecorationServiceImpl();
        BoxServiceImpl boxService = new BoxServiceImpl();

        Scanner scanner = new Scanner(System.in);

        SweetController sweetController = new SweetController(sweetService, scanner);
        DecorationController decorationController = new DecorationController(decorationService, scanner);
        BoxController boxController = new BoxController(boxService, sweetService, decorationService, scanner);

        ConsoleView consoleView = new ConsoleView(sweetController, decorationController, boxController);

        consoleView.readData();
        consoleView.init();
    }
}