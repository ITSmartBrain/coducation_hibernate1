package spring2;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class StoreController {
    private final ProductRepository productRepository;


    @PostMapping("/product/add")
    public void add(@RequestBody Product product){
        productRepository.save(product);
    }

    @GetMapping("/product")
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @GetMapping("/product/avg")
    public double getAvg(){
        return productRepository.findAvgPrice();
    }

    @PutMapping("/product")
    public void update(@RequestBody Product newProduct){
        Product product = productRepository.findByName(newProduct.getName())
                .orElseThrow(() -> new RuntimeException("Product with name " + newProduct.getName() + " not found"));
        product.setCount(newProduct.getCount());
        product.setPrice(newProduct.getPrice());
        product.setRating(newProduct.getRating());
        productRepository.save(product);
    }

    @Transactional
    @PutMapping("/product2")
    public void update2(@RequestBody Product newProduct){
        productRepository.updateCount(newProduct.getId(), newProduct.getCount());
    }







//    @GetMapping("/store5")
//    public List<Product> getTop5(){
//        return productRepository.findTop5ByOrderByRatingDesc();
//    }



}
