public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount();
        bankAccount1.openAccount("CA");
        bankAccount1.setAccountUser("Antonio Góis");
        bankAccount1.setAccountNumber(0554213);
        bankAccount1.accountInfo();
        bankAccount1.withdrawAccount(5);
        bankAccount1.depositAccount(1200);
        bankAccount1.withdrawAccount(20);
        bankAccount1.monthlyPayment();

    }
}