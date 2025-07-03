class DispensingState implements VendingMachineState {
    @Override
    public void selectProduct(VendingMachine machine, int productCode) {
        System.out.println("Dispensing in progress...");
    }
    
    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Dispensing in progress...");
    }
    
    @Override
    public void dispenseProduct(VendingMachine machine) {
        System.out.println("Already dispensing...");
    }
    
    @Override
    public void returnMoney(VendingMachine machine) {
        System.out.println("Dispensing in progress...");
    }
}