package sk.mishco.springboottutorial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.mishco.springboottutorial.model.Product;

import java.util.ArrayList;

@RestController
public class ProductServiceController {

    @RequestMapping(value = "/products")
    public ResponseEntity<ArrayList<Product>> getProducts() {
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

}
