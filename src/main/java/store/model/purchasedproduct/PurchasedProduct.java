package store.model.purchasedproduct;

import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import store.model.product.Product;

public class PurchasedProduct {

    private final Product product;
    private final int quantity;

    public PurchasedProduct(final Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void pay() {
        LocalDate thisTime = LocalDate.from(DateTimes.now());
        if (product.isPromotionPeriod(thisTime)) {
            payWithPromotion();
            return;
        }
        payWithoutPromotion();
    }

    private void payWithoutPromotion() {

    }

    private void payWithPromotion() {

    }
}
