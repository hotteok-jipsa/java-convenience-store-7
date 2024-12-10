package store.model.promotion;

import java.util.ArrayList;
import java.util.List;

public class Promotions {

    private final List<Promotion> promotions = new ArrayList<>();

    public void savePromotion(final Promotion promotion) {
        promotions.add(promotion);
    }
}
