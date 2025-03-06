package lesson60_jpa;

public class Main {
    public static void main(String[] args) {
        BankCardService service = new BankCardService();

        // Добавление банка
        Bank bank = new Bank();
        bank.setName("Sberbank");
        bank.setRating(5);
        service.addBank(bank);

        // Добавление карты банку
        BankCard card = new BankCard();
        card.setCardNumber("1234567890123456");
        card.setBalance(1000);
        card.setCashbackPercentage(5.0);
        card.setMinRequiredBalance(500);
        service.addCardToBank(1L, card);

        // Поиск карты по id
        BankCard foundCard = service.findCardById(1L);
        System.out.println("Found card: " + foundCard.getCardNumber());

        // Поиск карты с самым большим кэшбеком
        BankCard maxCashbackCard = service.findCardWithMaxCashback();
        System.out.println("Card with max cashback: " + maxCashbackCard.getCardNumber());

        // Пополнение баланса карты
        service.topUpBalance("1234567890123456", 1L, 500);

        service.close();
    }
}
