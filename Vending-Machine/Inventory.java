// Inventory class to manage product stock

import java.util.HashMap;
import java.util.Map;

class Inventory {

    private Map<Integer, Product> products;
    private Map<Integer, Integer> quantities;

    public Inventory() {
        products = new HashMap<>();
        quantities = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        products.put(product.getCode(), product);
        quantities.put(product.getCode(), quantity);
    }

    public Product getProduct(int code) {
        return products.get(code);
    }

    public boolean isAvailable(int code) {
        return quantities.getOrDefault(code, 0) > 0;
    }

    public void reduceQuantity(int code) {
        if (isAvailable(code)) {
            quantities.put(code, quantities.get(code) - 1);
        }
    }

    public int getQuantity(int code) {
        return quantities.getOrDefault(code, 0);
    }

    public Map<Integer, Product> getAllProducts() {
        return new HashMap<>(products);
    }

}
