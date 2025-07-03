
import java.util.Map;

class VendingMachine {

    private VendingMachineState state;
    private Inventory inventory;
    private MoneyManager moneyManager;
    private Product selectedProduct;
    private double insertedMoney;

    public VendingMachine() {
        this.state = new IdleState();
        this.inventory = new Inventory();
        this.moneyManager = new MoneyManager();
        this.insertedMoney = 0.0;
        initializeProducts();

    }

    private void initializeProducts() {
        // Add some sample products
        inventory.addProduct(new Product("Coke", 1.50, 101), 5);
        inventory.addProduct(new Product("Pepsi", 1.50, 102), 3);
        inventory.addProduct(new Product("Water", 1.00, 103), 10);
        inventory.addProduct(new Product("Chips", 2.00, 104), 7);
        inventory.addProduct(new Product("Candy", 1.25, 105), 8);
    }

    public void selectProduct(int productCode) {
        state.selectProduct(this, productCode);
    }

    public void insertMoney(double amount) {
        state.insertMoney(this, amount);

    }

    public void dispenseProduct() {
        state.dispenseProduct(this);
    }

    public void returnMoney() {
        state.returnMoney(this);
    }

    public void displayProducts() {
        System.out.println("\n=== Available Products ===");
        Map<Integer, Product> products = inventory.getAllProducts();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            Product product = entry.getValue();
            int quantity = inventory.getQuantity(product.getCode());
            System.out.printf("Code: %d | %s | $%.2f | Stock: %d%n",
                    product.getCode(), product.getName(),
                    product.getPrice(), quantity);
        }
        System.out.println("========================\n");
    }

    public VendingMachineState getState() {
        return state;
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public MoneyManager getMoneyManager() {
        return moneyManager;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product product) {
        this.selectedProduct = product;
    }

    public double getInsertedMoney() {
        return insertedMoney;
    }

    public void addInsertedMoney(double amount) {
        this.insertedMoney += amount;
    }

    public void resetInsertedMoney() {
        this.insertedMoney = 0.0;
    }

    public void resetTransaction() {
        this.selectedProduct = null;
        this.insertedMoney = 0.0;
    }
}
