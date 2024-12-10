package store.model.promotion;

import java.time.LocalDate;

public class Promotion {
    String name;
    int buy, get;
    LocalDate startDate;
    LocalDate endDate;

    public Promotion(String name, int buy, int get, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.buy = buy;
        this.get = get;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
