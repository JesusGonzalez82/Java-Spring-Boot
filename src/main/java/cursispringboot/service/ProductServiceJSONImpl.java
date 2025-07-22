package cursispringboot.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cursispringboot.domain.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

//@Primary
@Service
@ConditionalOnProperty(name = "service.products", havingValue = "json")
//@ConditionalOnProperties(name = "service.products", havingValue = "json")
public class ProductServiceJSONImpl implements ProductService{

//    public ProductServiceJSONImpl() {
//        System.out.println("Instancia de la clase ProductServiceJSONImpl");
//    }

    /**
     * @return
     */
    @Override
    public List<Product> getProducts() {
        List<Product> products;

        try{
            products = new ObjectMapper().
                    readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>() {});

            return products;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
