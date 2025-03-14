package spring1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/sum/{a}/{b}")
    public int sum(@PathVariable int a, @PathVariable int b){
        return a+b;
    }
    @GetMapping("/minus/{a}/{b}")
    public int minus(@PathVariable int a, @PathVariable int b){
        return a-b;
    }

}
