package cursispringboot.controllers;

import cursispringboot.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class CustomerRestController {

    private List<Customer> users = new ArrayList<>(Arrays.asList(
            new Customer(1, "Jesús González", "Aitana11,", "09-03-1982", "enable", "chuso82"),
            new Customer(2, "Mario Parra", "changeme1,", "01-01-1972", "enable", "marioP"),
            new Customer(3, "Hixem Barbero", "changeme2", "01-01-1982", "enable", "hbarbero"),
            new Customer(4, "Cristian Garcia", "changeme3", "01-05-1987", "enable", "Cristian")
    ));

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Customer> getCustomer() {
        return users;
    }

    // @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @GetMapping("/{username}")
    public Customer getCliente(@PathVariable String username) {
        for (Customer c : users) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
    }

    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public Customer addUserPost(@RequestBody Customer newUsers) {
        users.add(newUsers);
        return newUsers;
    }

    // @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public Customer putCliente(@RequestBody Customer user) {
        for (Customer c : users) {
            if (c.getID() == user.getID()) {
                c.setNombre(user.getNombre());
                c.setUsername(user.getUsername());
                c.setPassword(user.getPassword());

                return c;
            }
        }
        return null;
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public Customer deleteCliente(@PathVariable int id){
        for (Customer c : users){
            if (c.getID() == id) {
                users.remove(c);
                return c;
            }
        }
        return null;
    }

    // @RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public Customer patchCliente(@RequestBody Customer user){
        for(Customer c : users){
            if(c.getID() == user.getID()){
                if(user.getNombre() != null){
                    c.setNombre(user.getNombre());
                }
                if(user.getUsername() != null){
                    c.setUsername(user.getUsername());
                }
                if(user.getPassword() != null){
                    c.setPassword(user.getPassword());
                }
                return c;
            }
        }
        return null;
    }

}