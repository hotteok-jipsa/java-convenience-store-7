package store;

public enum ExceptionMessage {
    PURCHASED_PRODUCTS_FORM_INVALID_EXCEPTION("상품 구매 입력 양식이 잘못되었습니다.");

    private final String prefix = "[ERROR] ";
    public final String message;


    ExceptionMessage(String message) {
        this.message = prefix + message;
    }
}
