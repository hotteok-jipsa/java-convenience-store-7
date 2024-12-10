package store.model.purchasedproduct;

import java.util.ArrayList;
import java.util.List;

public class PurchasedProducts {
    private final List<PurchasedProduct> purchasedProducts = new ArrayList<>();

    public void addPurchasedProduct(final PurchasedProduct purchasedProduct) {
        purchasedProducts.add(purchasedProduct);
    }
}
