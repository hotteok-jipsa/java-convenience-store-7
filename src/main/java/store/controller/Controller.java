package store.controller;

import store.model.product.Products;
import store.model.promotion.Promotions;
import store.view.InputView;
import store.view.OutputView;

public class Controller {
    private final Products products;
    private final Promotions promotions;

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(Products products, Promotions promotions, InputView inputView, OutputView outputView) {
        this.products = products;
        this.promotions = promotions;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        printStartMessageAndGetInput();
    }

    private void printStartMessageAndGetInput() {
        outputView.printWelcomeMessage();
        outputView.printProductsMessage(products.getProductDtos());
    }
}
