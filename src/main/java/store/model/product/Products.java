package store.model.product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import store.dto.ProductDto;

public class Products {
    List<Product> products = new ArrayList<>();

    public void saveProduct(final Product product) {
        products.add(product);
    }

    public List<ProductDto> getProductDtos() {
        return products.stream()
                .map(product -> product.getProductDto())
                .collect(Collectors.toList());
    }
}
