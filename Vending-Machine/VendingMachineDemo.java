// Demo class to test the vending machine
public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        
        // Display available products
        vendingMachine.displayProducts();
        
        // Simulate a purchase
        System.out.println("=== Transaction 1: Buying Coke ===");
        vendingMachine.selectProduct(101); // Coke
        vendingMachine.insertMoney(1.50); // Exact change
        vendingMachine.dispenseProduct();
        
        System.out.println("\n=== Transaction 2: Buying Chips with change ===");
        vendingMachine.selectProduct(104); // Chips ($2.00)
        vendingMachine.insertMoney(3.00); // $3.00
        vendingMachine.dispenseProduct();
        
        System.out.println("\n=== Transaction 3: Cancel transaction ===");
        vendingMachine.selectProduct(102); // Pepsi
        vendingMachine.insertMoney(1.00);
        vendingMachine.returnMoney();
        
        // Display products after transactions
        System.out.println("\n=== Products after transactions ===");
        vendingMachine.displayProducts();
    }
}