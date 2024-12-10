package store.view;

import java.util.List;
import store.dto.ProductDto;

public class OutputView {

    private static final String WELCOME_MESSAGE = "안녕하세요. W편의점입니다.\n현재 보유하고 있는 상품입니다.\n";

    private static final String PRODUCT_MESSAGE_FORM = "- %s %,d원 %d %s\n";
    private static final String EMPTY_PRODUCT_MESSAGE_FORM = "- %s %,d원 재고 없음 %s\n";

    public void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printProductsMessage(List<ProductDto> productDtos) {
        for (ProductDto productDto : productDtos) {
            printProductMessage(productDto);
        }
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e);
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
