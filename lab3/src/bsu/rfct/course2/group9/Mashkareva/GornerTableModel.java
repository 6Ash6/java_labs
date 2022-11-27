package bsu.rfct.course2.group9.Mashkareva;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    private Double[] cofficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step, Double[] cofficients) {
        this.from = from;
        this.step = step;
        this.to = to;
        this.cofficients = cofficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
        return 3;
    }

    public int getRowCount() {
        return (int)Math.ceil((to-from)/step) + 1;
    }

    public Object getValueAt(int row, int col) {
        double x = from + step * row;
        return switch (col) {
            case (0) -> x;
            case (1) -> calculateHorner(x);
            case (2) -> MutuallyPrime(x);
            default -> "";
        };
    }


    public String getColumnName(int col) {
        return switch (col) {
            case 0 -> "Значение X";
            case 1 -> "Значение многочлена";
            case 2 -> "Взаимно простые";
            default -> "";
        };
    }

    public Class<?> getColumnClass(int col) {
        return switch (col){
            case(0), (1) -> Double.class;
            case(2) -> Boolean.class;
            default -> String.class;
        };
    }

    private double calculateHorner(double x) {
        Double b = cofficients[cofficients.length - 1];
        for (int i = cofficients.length - 2; i >= 0; i--) {
            b = b * x + cofficients[i];
        }
        return b;
    }

    private Boolean MutuallyPrime(double x) {

        int FPart = (int) x;
        if(FPart == 0) return false;
        int B = (int) calculateHorner(x);
        int d = 1;
        for (int i = 1; i <= FPart && i <= B; i++) {
            if (FPart % i == 0 && B % i == 0) {
                d = i;
            }
        }
        if (d == 1) return true;
        else return false;

    }
}

