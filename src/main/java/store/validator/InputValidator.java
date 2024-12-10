package store.validator;

import static store.ExceptionMessage.PRODUCT_OUT_OF_STOCK_EXCEPTION;
import static store.ExceptionMessage.PURCHASED_PRODUCTS_FORM_INVALID_EXCEPTION;

import java.util.HashMap;
import java.util.Map;
import store.model.product.Product;
import store.model.product.Products;

public class InputValidator {

    public Map<Product, Integer> validatePurchasedProducts(String input, Products products) {
        Map<Product, Integer> purchasedProductsMap = new HashMap<>();
        String[] purchasedProducts = input.split(",");
        for (String purchasedProduct : purchasedProducts) {
            validatePurchasedProduct(purchasedProduct);
            validateDuplicatePurchasedProduct(purchasedProductsMap, getPurchasedProductName(purchasedProduct));
            Product product = validateProductExist(products, purchasedProduct);
            int quantity = validateQuantity(products, purchasedProduct);

            purchasedProductsMap.put(product, quantity);
        }
        return purchasedProductsMap;
    }

    private void validatePurchasedProduct(String rawPurchasedProduct) {
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


    private void validateDuplicatePurchasedProduct(Map<Product, Integer> map, String productName) {
        for (Product product : map.keySet()) {
            if (product.getProductDto().name().equals(productName)) {
                throw new IllegalArgumentException(PURCHASED_PRODUCTS_FORM_INVALID_EXCEPTION.message);
            }
        }
    }

    private Product validateProductExist(Products products, String rawPurchasedProduct) {
        return products.findByNameIfAbsentThrow(getPurchasedProductName(rawPurchasedProduct));
    }

    private int validateQuantity(Products products, String rawPurchasedProduct) {
        String name = getPurchasedProductName(rawPurchasedProduct);
        int purchasedQuantity = getPurchasedProductQuantity(rawPurchasedProduct);
        if (products.getTotalQuantityByName(name) < purchasedQuantity) {
            throw new IllegalArgumentException(PRODUCT_OUT_OF_STOCK_EXCEPTION.message);
        }
        return purchasedQuantity;
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
