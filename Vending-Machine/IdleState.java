
class IdleState implements VendingMachineState {

    @Override
    public void selectProduct(VendingMachine machine, int productCode) {
        Product product = machine.getInventory().getProduct(productCode);

        if (product != null && machine.getInventory().isAvailable(productCode)) {
            machine.setSelectedProduct(product);
            machine.setState(new ProductSelectedState());
            System.out.println("Product selected: " + product.getName()
                    + " - Price: $" + product.getPrice());
        } else {
            System.out.println("Product not available or invalid code.");
        }
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Please select a product first.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        System.out.println("No product selected.");
    }

    @Override
    public void returnMoney(VendingMachine machine) {
        System.out.println("No money to return.");
    }
}
