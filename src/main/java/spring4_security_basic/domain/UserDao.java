package spring4_security_basic.domain;

/*
Просто пример DAO интерфейса
 */
public interface UserDao {
    void save(User user);
    User findById(Long id);
    void update(User user);
    void delete(Long id);
}
