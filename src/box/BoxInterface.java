package box;

import decoration.Decoration;
import sweet.Sweet;

public interface BoxInterface {
    void appendSweet(Sweet sweet);
    void removeSweet(Sweet sweet);
    void appendDecoration(Decoration decoration);
    void removeDecoration(Decoration decoration);
    double calculatePrice();
    double calculateWeight();
    double calculateVolume();
    double calculateCalories();
}
