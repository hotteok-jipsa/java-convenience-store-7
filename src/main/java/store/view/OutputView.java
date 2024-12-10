package store.view;

import java.util.List;
import store.dto.ProductDto;

public class OutputView {
    private static final String PRODUCT_MESSAGE_FORM = "- %s %,d원 %d %s\n";
    private static final String EMPTY_PRODUCT_MESSAGE_FORM = "- %s %,d원 재고 없음 %s\n";

    public void printProductsMessage(List<ProductDto> productDtos) {
        for (ProductDto productDto : productDtos) {
            printProductMessage(productDto);
        }
    }

    private void printProductMessage(ProductDto productDto) {
        if (productDto.quantity() == 0) {
            System.out.printf(EMPTY_PRODUCT_MESSAGE_FORM,
                    productDto.name(), productDto.price(), productDto.promotionDto().name());
            return;
        }
        System.out.printf(PRODUCT_MESSAGE_FORM,
                productDto.name(), productDto.price(), productDto.quantity(), productDto.promotionDto().name());
    }
}
