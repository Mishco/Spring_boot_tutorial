package sk.mishco.springboottutorial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.mishco.springboottutorial.model.Product;
import sk.mishco.springboottutorial.model.ProductDTO;
import sk.mishco.springboottutorial.services.IProductService;

import java.util.List;

@Controller
public class ProductController {


    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @PostMapping(value = "/products")
    public ResponseEntity<Object> createProduct(@RequestBody ProductDTO product) {
        productService.put(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        productService.remove(productService.getProductById(id));
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTO product) {
        productService.remove(productService.getProductById(id));
        product.setId(id);
        productService.put(product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }


}
