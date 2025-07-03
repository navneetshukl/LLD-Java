// Vending Machine States

interface VendingMachineState {

    void selectProduct(VendingMachine machine, int productCode);

    void insertMoney(VendingMachine machine, double amount);

    void dispenseProduct(VendingMachine machine);

    void returnMoney(VendingMachine machine);
}
