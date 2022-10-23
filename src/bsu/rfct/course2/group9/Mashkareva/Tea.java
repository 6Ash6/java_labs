package bsu.rfct.course2.group9.Mashkareva;

public class Tea extends Food {
    private String type = "";
    static final String Green = "Зелённый";
    static final String Black = "Чёрный";
    static final String Name = "Чай";
    private static int numGreen = 0;
    private static int numBlack = 0;

    private static int AllCal = 0;

    private int CalProduct;

    public Tea(String type){
        super("Чай");
        this.type = type;
        switch (type){
            case (Green):
                this.cal = 14;
                numGreen++;
                break;
            case (Black):
                this.cal = 8;
                numBlack++;
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
        System.out.println(Name + " " + type + " Выпито");

    }

    @Override
    public String getType(){
        return type;
    }

}
