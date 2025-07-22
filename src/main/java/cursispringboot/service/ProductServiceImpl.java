package cursispringboot.service;

import cursispringboot.domain.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Lazy
@Service
@ConditionalOnProperty(name = "service.products", havingValue = "list")
//@ConditionalOnProperties(name = "service.products", havingValue = "List")
public class ProductServiceImpl implements ProductService{


    public ProductServiceImpl() {
        System.out.println("Instancia de la clase ProductServiceImpl");
    }

    // Listado de Productos
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Portatil", 799.99, 5),
            new Product(2, "Monitor", 257.99, 3),
            new Product(3, "Teclado", 17.99, 10),
            new Product(4, "Hub USB", 99.99, 0)
    ));

    @Override
    public List<Product> getProducts(){
        return products;
    }

}
