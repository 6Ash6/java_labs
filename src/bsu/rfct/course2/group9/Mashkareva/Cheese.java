package bsu.rfct.course2.group9.Mashkareva;

    public class Cheese extends Food {
        public Cheese() {
            super("Сыр");
        }

        public void consume() {
            System.out.println(this.name + " съеден");
        }


        @Override
        public String toString() {
            return "Cheese{" +
                    "cal=" + cal +
                    '}';
        }

        @Override
        public int calculCal() {
            return cal;
        }

        @Override
        public String getType(){
            return null;
        }
    }


