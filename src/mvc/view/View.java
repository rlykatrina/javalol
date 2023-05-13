package mvc.view;

public interface View {
    int listen();
    void init();
    void saveChanges();
    void readData();
    void closeThread();
    void showMenu();
    void showSweets();
    void showBoxes();
    void showDecorations();
}
