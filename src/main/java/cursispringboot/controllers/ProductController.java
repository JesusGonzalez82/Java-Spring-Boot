package cursispringboot.controllers;

import cursispringboot.domain.Product;
import cursispringboot.service.ProductService;
import cursispringboot.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    // Instancia de clase
    // ProductService productService = new ProductServiceImpl();
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProducts(){
        List<Product> products = productService.getProducts();

        return ResponseEntity.ok(products);
    }

}
