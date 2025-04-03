package spring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//внедрение зависимостей
//spring data
//named query
//native query
//Пагинация Pageable, почитать про slice
//запрос Топ5
//использование в репозиторий паттерне
//АОП и exception handler
//ямл
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
