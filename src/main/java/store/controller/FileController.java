package store.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import store.model.promotion.Promotion;
import store.model.promotion.Promotions;

public class FileController {

    private static final String PROMOTIONS_FILE_PATH = "src/main/resources/promotions.md";

    private final Promotions promotions;

    public FileController(Promotions promotions) {
        this.promotions = promotions;
    }

    public void start() {
        try {
            setPromotions();
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
}
