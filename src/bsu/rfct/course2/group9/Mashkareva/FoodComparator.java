package bsu.rfct.course2.group9.Mashkareva;
import java.util.Comparator;

public class FoodComparator implements Comparator<Food> {

    public int compare (Food ar0, Food ar1){
        if (ar0 == null || ar0.getType() == null) return 1;
        if (ar1 == null || ar1.getType() == null) return -1;
        return (ar0.getType()).compareTo(ar1.getType());
    }
}
