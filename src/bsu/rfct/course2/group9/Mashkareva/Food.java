package bsu.rfct.course2.group9.Mashkareva;

public abstract class Food implements Nitritious, Consumeble, Comparable, Typable{
protected int cal = 0;

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    String name = null;

    public Food(String name) {
        this.name = name;
    }
}
