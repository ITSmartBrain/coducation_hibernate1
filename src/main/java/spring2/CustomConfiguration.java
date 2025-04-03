package spring2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class CustomConfiguration {

    @Bean
    public Random createRandom(){
        return new Random();
    }
}
