package spring1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {


    @GetMapping("/greeting")
    public String greeting(){
        return "hello world";
    }

    @GetMapping("/bye")
    public String bye(){
        return "good bye";
    }
}
