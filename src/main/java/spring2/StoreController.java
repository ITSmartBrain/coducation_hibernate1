package spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class StoreController {

    @Autowired
    private ProductStore productStore;

    @Autowired
    private Random rnd;

    @PostMapping("/store/add")
    public void add(@RequestBody Product product){
        productStore.add(product);
    }

    @GetMapping("/store")
    public List<Product> getAll(){
        return productStore.getProducts();
    }

}
