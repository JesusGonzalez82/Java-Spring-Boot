package cursispringboot.controllers;

import cursispringboot.domain.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerRestController {

    private List<Customer> users = new ArrayList<>(Arrays.asList(
            new Customer(1, "Jesús González", "Aitana11,", "09-03-1982", "enable"),
            new Customer(2, "Mario Parra", "changeme1,", "01-01-1972", "enable"),
            new Customer(3, "Hixem Barbero", "changeme2", "01-01-1982", "enable"),
            new Customer(4, "Cristian Garcia", "changeme3", "01-05-1987", "enable")
    ));
@GetMapping("clientes")
    public List<Customer> getCustomer(){
        return users;
    }
}
