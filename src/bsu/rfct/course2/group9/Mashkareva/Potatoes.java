package bsu.rfct.course2.group9.Mashkareva;

import javax.xml.namespace.QName;

public class Potatoes extends Food    {

    private String type = "";
    private static int numFried = 0;
    private static int numBoild = 0;
    private static int numFree = 0;

    private static int AllCal = 0;

    private int CalProduct;

    static final String Fried = "Жаренная";
    static final String Boild = "Варённая";
    static final String Free = "Фри";
    static final String Name = "Картошка";


    public Potatoes(String type){
        super("Картошка");
        this.type = type;
        switch (type){
            case (Fried):
                this.cal = 147;
                numFried++;
                break;
            case (Boild):
                this.cal = 86;
                numBoild++;
            case (Free):
                this.cal = 274;
                numFree++;
        }
    }



    public static int getAllCal(){
        return AllCal;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCal() {
        return cal;
    }


    @Override
    public int calculCal() {
        return cal;
    }

    @Override
    public void consume() {
        System.out.println(Name + " " + type + " Съедено");

    }
 @Override
    public String getType(){
        return type;
 }

}

