package bsu.rfct.course2.group9.Mashkareva;

import java.awt.geom.Area;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        ArrayList<Food> potatoes = new ArrayList<Food>();
        for (String arg : args) {
            String[] pair = arg.split("/");
            switch (pair[0]) {
                case ("Картошка") -> potatoes.add(new Potatoes(pair[1]));
                case ("Чай") -> potatoes.add(new Tea(pair[1]));
                case ("Сыр") -> potatoes.add(new Cheese());
            }
        }

        for (Food p: potatoes){
        }

        boolean isSorting = Arrays.asList(args).contains("-sort");
        if (isSorting) {
            Comparator<Food> comparator = new FoodComparator();
            potatoes.sort(comparator);
        }

        int sumCal = 0;
        boolean isCalculatingCalories = Arrays.asList(args).contains("-calories");
        for (Food potato : potatoes) {
            if (isCalculatingCalories) {
                int call = potato.calculCal();
                sumCal += call;
            }
            potato.consume();
        }
        if (isCalculatingCalories) {
            System.out.println("Общее кол-во коллорий: " + sumCal);
        }

    }
}