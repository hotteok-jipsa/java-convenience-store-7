package store;

public enum ExceptionMessage {
    PURCHASED_PRODUCTS_FORM_INVALID_EXCEPTION("상품 구매 입력 양식이 잘못되었습니다."),

    PRODUCT_NOT_EXIST_EXCEPTION("존재하지 않는 상품입니다.");

    private final String prefix = "[ERROR] ";
    public final String message;


    ExceptionMessage(String message) {
        this.message = prefix + message;
    }
}
