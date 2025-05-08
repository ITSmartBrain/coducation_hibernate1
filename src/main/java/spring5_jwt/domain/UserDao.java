package spring5_jwt.domain;

/*
Просто пример DAO интерфейса
 */
public interface UserDao {
    void save(User user);
    User findById(Long id);
    void update(User user);
    void delete(Long id);
}
