package FinalProjectOOP;

//encapsulation
class Extra extends Ing {
    private String name;
    private int calories;
    private double price;
    private int order;

    public Extra(String name, int calories, double price, int order) {
        super(name, calories, price, order); // Call to super class constructor
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.order = order;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public double getPrice() {
        return price;
    }

    public int getOrder() {
        return order;
    }

    // Setter methods (if needed)
    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
