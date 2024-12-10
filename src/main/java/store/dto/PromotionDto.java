package store.dto;

import java.time.LocalDate;

public record PromotionDto(
        String name,
        int buy,
        int get,
        LocalDate startDate,
        LocalDate endDate
) {
}
