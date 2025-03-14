//package lesson60_jpa;
//
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//public class BankCardService {
//
//    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
//    private EntityManager em = emf.createEntityManager();
//
//    // Добавление банка
//    public void addBank(Bank bank) {
//
//        em.getTransaction().begin();
//        em.persist(bank);
//        em.getTransaction().commit();
//    }
//
//    // Добавление карты банку
//    public void addCardToBank(Long bankId, BankCard card) {
//        em.getTransaction().begin();
//        Bank bank = em.find(Bank.class, bankId);
//        card.setBank(bank);
//        em.persist(card);
//        em.getTransaction().commit();
//    }
//
//    // Поиск карты по id
//    public BankCard findCardById(Long cardId) {
//        return em.find(BankCard.class, cardId);
//    }
//
//    // Поиск карты с самым большим кэшбеком
//    public BankCard findCardWithMaxCashback() {
//        //HQL
//        //JPQL
//        //native sql
//        return em.createQuery("SELECT c FROM BankCard c ORDER BY c.cashbackPercentage DESC", BankCard.class)
//                .setMaxResults(1)
//                .getSingleResult();
//    }
//
//    // Пополнение баланса карты по ее номеру и банку
//    public void topUpBalance(String cardNumber, Long bankId, double amount) {
//        em.getTransaction().begin();
//        BankCard card = em.createQuery("SELECT c FROM BankCard c WHERE c.cardNumber = :cardNumber AND c.bank.id = :bankId", BankCard.class)
//                .setParameter("cardNumber", cardNumber)
//                .setParameter("bankId", bankId)
//                .getSingleResult();
//        card.setBalance(card.getBalance() + amount);
//        em.persist(card);
//        em.getTransaction().commit();
//    }
//
//    public void close() {
//        em.close();
//        emf.close();
//    }
//}
