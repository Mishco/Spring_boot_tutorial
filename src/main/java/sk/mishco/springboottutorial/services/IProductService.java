package sk.mishco.springboottutorial.services;

import sk.mishco.springboottutorial.model.Product;
import sk.mishco.springboottutorial.model.ProductDTO;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();

    ProductDTO getProductById(Long id);

    Product put(ProductDTO product);

    void remove(ProductDTO product);
}
