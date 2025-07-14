package cursispringboot.controllers;

import cursispringboot.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    // Consultar todos los clientes
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer() {

        return ResponseEntity.ok(users);
        //return users;
    }

    // @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    // Consultar un cliente por su username
    @GetMapping("/{username}")
    public ResponseEntity<?> getCliente(@PathVariable String username) {
        for (Customer c : users) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return ResponseEntity.ok(c);
                //return c;
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado con username: " + username);
        //return null;
    }

    // @RequestMapping(method = RequestMethod.POST)
    // Creamos un nuevo usuario
    @PostMapping
    public ResponseEntity<?>  addUserPost(@RequestBody Customer newUsers) {
        users.add(newUsers);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario " + newUsers.getUsername() + " creado correctamente");
        //return newUsers;
    }

    // @RequestMapping(method = RequestMethod.PUT)
    // Modificacion usuario
    @PutMapping
    public ResponseEntity<?> putCliente(@RequestBody Customer user) {
        for (Customer c : users) {
            if (c.getID() == user.getID()) {
                c.setNombre(user.getNombre());
                c.setUsername(user.getUsername());
                c.setPassword(user.getPassword());

                return ResponseEntity.ok("Usuario modificado correctamente: " + user.getID());
                //return c;
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado: " + user.getID());
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    // Eliminar un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable int id){
        for (Customer c : users){
            if (c.getID() == id) {
                users.remove(c);

                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario eliminado correctamente " + c.getID());
                //return c;
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado con el ID: " + id);
    }

    // @RequestMapping(method = RequestMethod.PATCH)
    // Modificacion parcial de un cliente
    @PatchMapping
    public ResponseEntity<?> patchCliente(@RequestBody Customer user){
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
                return ResponseEntity.ok("Usuario modificado correctamente: " + user.getID());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado con el ID: " + user.getID());
    }

}