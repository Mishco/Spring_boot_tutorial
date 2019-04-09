package sk.mishco.springboottutorial.services;

import org.springframework.stereotype.Service;
import sk.mishco.springboottutorial.ProductRepository;
import sk.mishco.springboottutorial.model.Product;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(new Product());
    }

    public Product put(Product product) {
        return productRepository.save(product);
    }

    public void remove(Product product) {
        productRepository.delete(product);
    }
}
