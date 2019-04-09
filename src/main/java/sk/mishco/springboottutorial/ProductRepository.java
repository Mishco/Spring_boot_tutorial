package sk.mishco.springboottutorial;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.mishco.springboottutorial.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
}
