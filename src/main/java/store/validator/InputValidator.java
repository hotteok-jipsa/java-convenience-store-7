package store.validator;

import static store.ExceptionMessage.PURCHASED_PRODUCTS_FORM_INVALID_EXCEPTION;

import java.util.HashMap;
import java.util.Map;

public class InputValidator {

    public Map<String, Integer> validatePurchasedProductsForm(String input) {
        Map<String, Integer> purchasedProductsMap = new HashMap<>();
        String[] purchasedProducts = input.split(",");
        for (String purchasedProduct : purchasedProducts) {
            validatePurchasedProductForm(purchasedProduct);
            purchasedProductsMap.put(
                    getPurchasedProductName(purchasedProduct),
                    getPurchasedProductQuantity(purchasedProduct)
            );
        }
        return purchasedProductsMap;
    }

    private void validatePurchasedProductForm(String rawPurchasedProduct) {
        if (!rawPurchasedProduct.startsWith("[") || !rawPurchasedProduct.endsWith("]")) {
            throw new IllegalArgumentException(PURCHASED_PRODUCTS_FORM_INVALID_EXCEPTION.message);
        }
        rawPurchasedProduct = rawPurchasedProduct.substring(1, rawPurchasedProduct.length());
        validatePurchasedQuantityIsNumber(rawPurchasedProduct.split("-")[1]);
    }

    private void validatePurchasedQuantityIsNumber(String rawQuantity) {
        if (!rawQuantity.matches("[1-9]\\d*")) {
            throw new IllegalArgumentException(PURCHASED_PRODUCTS_FORM_INVALID_EXCEPTION.message);
        }
    }

    private String getPurchasedProductName(String validatedPurchasedProduct) {
        validatedPurchasedProduct = validatedPurchasedProduct.substring(1, validatedPurchasedProduct.length());
        return validatedPurchasedProduct.split("-")[0];
    }

    private int getPurchasedProductQuantity(String validatedPurchasedProduct) {
        validatedPurchasedProduct = validatedPurchasedProduct.substring(1, validatedPurchasedProduct.length());
        String rawQuantity = validatedPurchasedProduct.split("-")[1];
        return Integer.parseInt(rawQuantity);
    }
}
