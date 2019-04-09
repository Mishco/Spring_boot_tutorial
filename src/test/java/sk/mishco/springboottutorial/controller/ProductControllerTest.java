package sk.mishco.springboottutorial.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sk.mishco.springboottutorial.ProductRepository;
import sk.mishco.springboottutorial.model.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductControllerTest {

    @Autowired(required = true)
    private ProductRepository productRepository;


    @Test
    void findAllTest() {
        List<Product> product = productRepository.findAll();

        assertNotNull(product);
    }

    @Test
    void addTest() {
        Product newProduct = new Product(100L, "Rozok");
        Product product = productRepository.save(newProduct);

        assertEquals(newProduct, product);
    }

    @Test
    void removeTest() {
        Product newProduct = new Product(101L, "Rozok");
        productRepository.save(newProduct);
        Product foundProduct = productRepository.findById(newProduct.getId()).orElse(new Product());
        productRepository.delete(foundProduct);

        assertEquals(foundProduct.getId(), newProduct.getId());
    }

}