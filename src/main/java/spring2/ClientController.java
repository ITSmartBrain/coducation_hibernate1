package spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class ClientController {

    @Autowired
    private ProductStore productStore;

    @Autowired
    private Random rnd;

    @PostMapping("/client/buy/{name}")
    public void buy(@PathVariable String name){
        productStore.buy(name);
    }

    @GetMapping("/client/store")
    public List<Product> getAll(){
        return productStore.getProducts();
    }

}
