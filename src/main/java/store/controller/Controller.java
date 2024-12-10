package store.controller;

import java.util.Map;
import java.util.Map.Entry;
import store.model.product.Product;
import store.model.product.Products;
import store.model.promotion.Promotions;
import store.model.purchasedproduct.PurchasedProduct;
import store.model.purchasedproduct.PurchasedProducts;
import store.validator.InputValidator;
import store.view.InputView;
import store.view.OutputView;

public class Controller {
    private final Products products;
    private final Promotions promotions;

    private final InputView inputView;
    private final OutputView outputView;

    private final InputValidator inputValidator;

    public Controller(Products products, Promotions promotions, InputView inputView, OutputView outputView,
                      InputValidator inputValidator) {
        this.products = products;
        this.promotions = promotions;
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }

    public void start() {
        printStartMessageAndGetInput();
        PurchasedProducts purchasedProducts = getPurchasedProducts();
    }

    private void printStartMessageAndGetInput() {
        outputView.printWelcomeMessage();
        outputView.printProductsMessage(products.getProductDtos());
        inputView.printPurchaseGuideMessage();
    }

    private PurchasedProducts getPurchasedProducts() {
        String input = inputView.getInput();
        Map<Product, Integer> rawPurchasedProducts = inputValidator.validatePurchasedProducts(input, products);
        PurchasedProducts purchasedProducts = new PurchasedProducts();
        for (Entry<Product, Integer> rawPurchasedProduct : rawPurchasedProducts.entrySet()) {
            PurchasedProduct purchasedProduct = new PurchasedProduct(rawPurchasedProduct.getKey(),
                    rawPurchasedProduct.getValue());
            purchasedProducts.addPurchasedProduct(purchasedProduct);
        }
        return purchasedProducts;
    }
}
