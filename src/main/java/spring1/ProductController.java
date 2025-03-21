package spring1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
//HTTP
@RestController
public class ProductController {
    private List<User> users = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();



    @PostMapping("product/auth")
    public boolean auth(@RequestBody User user){
        System.out.println(user.login+" - "+user.password);
        return users.stream().anyMatch(t -> t.login.equals(user.login) && t.password.equals(user.password));
    }

    @PostMapping("product/add")
    public void add(@RequestBody Product product){
        productList.add(product);
    }

    @GetMapping("product")
    public List<Product> getAllProducts(){
        return productList;
    }

    @GetMapping("product/filter/price/{price}")
    public List<Product> getAllLessPrice(@PathVariable int price){
        return productList.stream().filter(t -> t.getPrice() < price).toList();
    }

    @DeleteMapping ("product/name/{name}")
    public boolean deleteProduct(@PathVariable String name){
        return productList.remove(new Product(name, 0));
    }

    @PutMapping("product/name/{name}")
    public void update(@PathVariable String name, @RequestBody Product product){
        int index = productList.indexOf(new Product(name, 0));
        Product p = productList.get(index);
        p.setPrice(product.getPrice());
        p.setName(product.getName());
    }

    @PatchMapping("product/name/{name}")
    public void patch(@PathVariable String name, @RequestBody Product product){
        int index = productList.indexOf(new Product(name, 0));
        Product p = productList.get(index);
        if(product.getPrice()!=0) {
            p.setPrice(product.getPrice());
        }
        if(product.getName()!=null) {
            p.setName(product.getName());
        }
    }




}

@Getter
@Setter
@NoArgsConstructor
class User{
    String login;
    String password;
}