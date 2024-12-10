package store.controller;

import store.model.product.Products;
import store.model.promotion.Promotions;
import store.view.InputView;

public class Controller {
    private final Products products;
    private final Promotions promotions;

    private final InputView inputView;

    public Controller(Products products, Promotions promotions, InputView inputView) {
        this.products = products;
        this.promotions = promotions;
        this.inputView = inputView;
    }

    public void start() {
        printStartMessageAndGetInput();
    }

    private void printStartMessageAndGetInput() {
        inputView.printWelcomeMessage();
    }
}
