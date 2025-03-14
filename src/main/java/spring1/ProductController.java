package spring1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private List<Product> productList = new ArrayList<>();

    @GetMapping("product/add/name/{name}/price/{price}")
    public void add(@PathVariable String name, @PathVariable int price){
        productList.add(new Product(name, price));
    }

    @GetMapping("product")
    public List<Product> getAllProducts(){
        return productList;
    }

    @GetMapping("product/filter/price/{price}")
    public List<Product> getAllLessPrice(@PathVariable int price){
        return productList.stream().filter(t -> t.getPrice() < price).toList();
    }

}
