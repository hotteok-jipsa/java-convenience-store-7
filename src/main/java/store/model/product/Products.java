package store.model.product;

import java.util.ArrayList;
import java.util.List;

public class Products {
    List<Product> products = new ArrayList<>();

    public void saveProduct(final Product product) {
        products.add(product);
    }
}
