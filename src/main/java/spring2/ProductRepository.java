package spring2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    //spring data query methods https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    Optional<Product> findByName(String name);

    List<Product> findTop5ByOrderByRatingDesc();

    //JPQL
    @Query("SELECT AVG(p.price) FROM Product p")
    double findAvgPrice();


    //JPQL
    @Modifying
    @Query("UPDATE Product p SET p.count = :count WHERE p.id = :id")
    void updateCount(@Param("id") Integer id, @Param("count") Integer quantity);
}
