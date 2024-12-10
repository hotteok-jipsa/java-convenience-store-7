package store.model.purchasedproduct;

import store.model.product.Product;

public class PurchasedProduct {

    private final Product product;
    private final int quantity;

    public PurchasedProduct(final Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void pay() {

    }
}
