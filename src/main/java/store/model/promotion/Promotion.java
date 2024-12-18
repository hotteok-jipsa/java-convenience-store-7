package store.model.promotion;

import java.time.LocalDate;
import store.dto.PromotionDto;

public class Promotion {
    private final String name;
    private final int buy;
    private final int get;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Promotion(String name, int buy, int get, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.buy = buy;
        this.get = get;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public PromotionDto getPromotionDto() {
        return new PromotionDto(
                name, buy, get, startDate, endDate
        );
    }

    public boolean isPeriod(LocalDate target) {
        return (target.isAfter(startDate) || target.isEqual(startDate)) &&
                ((target.isBefore(endDate) || target.isEqual(endDate)));
    }
}
