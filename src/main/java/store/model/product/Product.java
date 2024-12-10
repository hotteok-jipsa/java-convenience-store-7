package store.model.product;

import java.time.LocalDate;
import store.dto.ProductDto;
import store.model.promotion.Promotion;

public class Product {

    private final String name;
    private final int price;
    private final int quantity;
    private final Promotion promotion;

    public Product(String name, int price, int quantity, final Promotion promotion) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promotion = promotion;
    }

    public ProductDto getProductDto() {
        return new ProductDto(
                name, price, quantity, promotion.getPromotionDto()
        );
    }

    public boolean isPromotionPeriod(LocalDate thisTime) {
        return promotion.isPeriod(thisTime);
    }
}
