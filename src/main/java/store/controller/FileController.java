package store.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import store.model.product.Product;
import store.model.product.Products;
import store.model.promotion.Promotion;
import store.model.promotion.Promotions;

public class FileController {

    private static final String PROMOTIONS_FILE_PATH = "src/main/resources/promotions.md";
    private static final String PRODUCTS_FILE_PATH = "src/main/resources/products.md";

    private final Promotions promotions;
    private final Products products;

    public FileController(Promotions promotions, Products products) {
        this.promotions = promotions;
        this.products = products;
    }

    public void start() {
        try {
            setPromotions();
            setProducts();
        } catch (IOException e) {
            System.out.println("[ERROR] 파일 입출력 에러");
        }
    }

    private void setPromotions() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(PROMOTIONS_FILE_PATH));
        String rawPromotion;
        reader.readLine();
        while ((rawPromotion = reader.readLine()) != null) {
            promotions.savePromotion(getPromotion(rawPromotion));
        }
        reader.close();
    }

    private Promotion getPromotion(String rawPromotion) {
        String[] promotionInfo = rawPromotion.split(",");
        return new Promotion(
                promotionInfo[0],
                Integer.parseInt(promotionInfo[1]),
                Integer.parseInt(promotionInfo[2]),
                LocalDate.parse(promotionInfo[3]),
                LocalDate.parse(promotionInfo[4])
        );
    }

    private void setProducts() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(PRODUCTS_FILE_PATH));
        String rawProduct;
        reader.readLine();
        while ((rawProduct = reader.readLine()) != null) {
            products.saveProduct(getProduct(rawProduct));
        }
        reader.close();
    }

    private Product getProduct(String rawProduct) {
        String[] productInfo = rawProduct.split(",");
        return new Product(
                productInfo[0],
                Integer.parseInt(productInfo[1]),
                Integer.parseInt(productInfo[2]),
                promotions.findByName(productInfo[3])
        );
    }
}
