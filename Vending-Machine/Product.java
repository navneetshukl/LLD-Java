// Product class representing items in the vending machine

class Product {

    private String name;
    private double price;
    private int code;

    public Product(String name, double price, int code) {
        this.name = name;
        this.price = price;
        this.code = code;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCode() {
        return code;
    }
}
