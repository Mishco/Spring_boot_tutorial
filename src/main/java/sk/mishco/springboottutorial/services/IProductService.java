package sk.mishco.springboottutorial.services;

import sk.mishco.springboottutorial.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();

    Product getProductById(Long id);

    Product put(Product product);

    void remove(Product product);
}
