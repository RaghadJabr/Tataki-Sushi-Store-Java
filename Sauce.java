package FinalProjectOOP;

//inheritance
class Sauce extends Ing {

    public Sauce(String name, int calories, double price, int order) {
        super(name, calories, price, order); // Call to superclass constructor
    }


    public Sauce() {
		// TODO Auto-generated constructor stub
    	super();
	}


	//Override
    public void message(int num) {
        super.message(num); // Call the superclass method
        if (num == 5) {
            System.out.println("Boring");
        } else {
            System.out.println("YUM");
        }
    }
}
