package lesson59.hiber;



import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserService {

    // Добавление пользователя
    public void addUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }
    public void addDepartment(Department department) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
        }
    }

    public void addPassport(Passport passport) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(passport);
            transaction.commit();
        }
    }

    public void addSocial(SocialNetwork socialNetwork) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(socialNetwork);
            transaction.commit();
        }
    }



    // Редактирование пользователя
    public void updateUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
    }

    // Удаление пользователя
    public void deleteUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        }
    }

    // Получение пользователя по ID
    public User getUserById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, id);
        }
    }

    public Department getDepById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Department.class, id);
        }
    }

    public Passport getPassportById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Passport.class, id);
        }
    }

    public SocialNetwork getSocialById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(SocialNetwork.class, id);
        }
    }


    // Поиск всех пользователей в определенном департаменте
    public List<User> getUsersByDepartment(Long departmentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //SQL -> HQL (hibernate query language)
            return session.createQuery("FROM User WHERE department.id = :departmentId", User.class)
                    .setParameter("departmentId", departmentId)
                    .list();
        }
    }

    // Поиск всех пользователей в социальной сети
    public List<User> getUsersBySocialNetwork(Long socialNetworkId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "SELECT u FROM User u JOIN u.socialNetworks sn WHERE sn.id = :socialNetworkId", User.class)
                    .setParameter("socialNetworkId", socialNetworkId)
                    .list();
        }
    }

    // Добавление пользователя в департамент
    public void addUserToDepartment(Long userId, Long departmentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, userId);
            Department department = session.get(Department.class, departmentId);
            user.setDepartment(department);
            session.update(user);
            transaction.commit();
        }
    }

    // Перевод пользователя из одного департамента в другой (транзакционный)
    public void transferUserDepartment(Long userId, Long fromDepartmentId, Long toDepartmentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, userId);
            Department fromDepartment = session.get(Department.class, fromDepartmentId);
            Department toDepartment = session.get(Department.class, toDepartmentId);

            if (user.getDepartment().equals(fromDepartment)) {
                user.setDepartment(toDepartment);
                session.update(user);
                transaction.commit();
            } else {
                transaction.rollback();
                throw new IllegalStateException("Пользователь не принадлежит указанному департаменту");
            }
        }
    }

    public void addSocialForUser(Long userId, Long socialNetwork) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, userId);
            SocialNetwork social = session.get(SocialNetwork.class, socialNetwork);
            user.getSocialNetworks().add(social);
            session.update(user);
            transaction.commit();
        }
    }
}
