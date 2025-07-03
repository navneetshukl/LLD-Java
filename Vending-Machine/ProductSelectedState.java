
class ProductSelectedState implements VendingMachineState {

    @Override

    public void selectProduct(VendingMachine machine, int productCode) {
        // Allow changing product selection

        machine.setState(new IdleState());
        machine.setState(new IdleState());
        machine.getState().selectProduct(machine, productCode);
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        machine.addInsertedMoney(amount);

        machine.getMoneyManager().addMoney(amount);

        System.out.println("Inserted: $" + amount + " - Total: $" + machine.getInsertedMoney());
        if (machine.getInsertedMoney() >= machine.getSelectedProduct().getPrice()) {
            machine.setState(new MoneyInsertedState());
            System.out.println("Sufficient money inserted. Press dispense to get your product.");
        }
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        System.out.println("Please insert money first.");
    }

    @Override
    public void returnMoney(VendingMachine machine) {
        if (machine.getInsertedMoney() > 0) {
            System.out.println("Returning $" + machine.getInsertedMoney());
            machine.resetInsertedMoney();
        }
        machine.setState(new IdleState());
    }
}
