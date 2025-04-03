package spring2;

import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductStore {
    private List<Product> products = new ArrayList<>();


    public void add(Product product){
        products.add(product);
    }

    public List<Product> getProducts(){
        return products;
    }

    public void remove(String name){

    }

    public void buy(String name){
        //
    }


}
