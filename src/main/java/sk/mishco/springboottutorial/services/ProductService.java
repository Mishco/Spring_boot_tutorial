package sk.mishco.springboottutorial.services;

import org.springframework.stereotype.Service;
import sk.mishco.springboottutorial.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getProducts() {
        return new ArrayList<>();
    }
}
