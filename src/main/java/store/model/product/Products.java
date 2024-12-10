package store.model.product;

import static store.ExceptionMessage.PRODUCT_NOT_EXIST_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import store.dto.ProductDto;

public class Products {
    List<Product> products = new ArrayList<>();

    public void saveProduct(final Product product) {
        products.add(product);
    }

    public Product findByNameIfAbsentThrow(String name) {
        for (Product product : products) {
            if (product.getProductDto().name().equals(name)) {
                return product;
            }
        }
        throw new IllegalArgumentException(PRODUCT_NOT_EXIST_EXCEPTION.message);
    }

    public int getTotalQuantityByName(String name) {
        return products.stream()
                .filter(product -> product.getProductDto().name().equals(name))
                .mapToInt(product -> product.getProductDto().quantity())
                .sum();
    }

    public List<ProductDto> getProductDtos() {
        return products.stream()
                .map(product -> product.getProductDto())
                .collect(Collectors.toList());
    }
}
