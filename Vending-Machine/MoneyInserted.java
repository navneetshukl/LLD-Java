
import java.util.Map;

class MoneyInsertedState implements VendingMachineState {

    @Override
    public void selectProduct(VendingMachine machine, int productCode) {
        System.out.println("Money already inserted. Dispense product or return money first.");
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        machine.addInsertedMoney(amount);
        machine.getMoneyManager().addMoney(amount);
        System.out.println("Additional money inserted. Total: $" + machine.getInsertedMoney());
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        Product product = machine.getSelectedProduct();
        double changeAmount = machine.getInsertedMoney() - product.getPrice();

        if (changeAmount > 0) {
            double change = machine.getMoneyManager().getChange(changeAmount);
            if (change > 0) {
                System.out.println("Dispensing product: " + product.getName());
                System.out.println("Change returned: $" + String.format("%.2f", change));
            } else {
                System.out.println("Sorry, no change available. Transaction Cancelled");
                return;
            }
        } else {
            System.out.println("Dispensing product: " + product.getName());
        }

        machine.getInventory().reduceQuantity(product.getCode());
        machine.setState(new DispensingState());
        machine.setState(new IdleState());
        machine.resetTransaction();
    }

    @Override
    public void returnMoney(VendingMachine machine) {
        System.out.println("Returning $" + machine.getInsertedMoney());
        machine.resetTransaction();
        machine.setState(new IdleState());
    }

}
