package sk.mishco.springboottutorial.services;

import org.springframework.stereotype.Service;
import sk.mishco.springboottutorial.ProductRepository;
import sk.mishco.springboottutorial.model.Product;
import sk.mishco.springboottutorial.model.ProductDTO;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(new Product());
        return new ProductDTO(product.getId(), product.getName());
    }

    public Product put(ProductDTO product) {
        Product newProduct = new Product(product.getId(), product.getName());
        return productRepository.save(newProduct);
    }

    public void remove(ProductDTO product) {
        Product newProduct = new Product(product.getId(), product.getName());
        productRepository.delete(newProduct);
    }
}
