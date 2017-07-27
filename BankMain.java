/**
 * Created by 민우 on 2017-07-06.
 */
public class BankMain {
    public static void main(String[] args) {
        // 사람 1
//        Person p1 = new Person();
//        p1.setName("김신의");
//        p1.setAge(28);
//        p1.setCashAmount(30000);
        Person p1 = new Person("김신의", 28);
        p1.setCashAmount(30000);

        // 은행 계좌 1
//        BankAccount a1 = new BankAccount();
//        a1.setBalance(100000);
//        p1.setAccount(a1);
//        a1.setOwner(p1);
        BankAccount a1 = new BankAccount(p1);
        p1.setAccount(a1);
        a1.setBalance(100000);


        // 사람 2
//        Person p2 = new Person();
//        p2.setName("문종모");
//        p2.setAge(25);
//        p2.setCashAmount(100000);
        Person p2 = new Person("문종모", 25, 100000);

        // 은행 계좌 2
//        BankAccount a2 = new BankAccount();
//        a2.setBalance(500000);
//        p2.setAccount(a2);
//        a2.setOwner(p2);
        BankAccount a2 = new BankAccount(500000, p2);
        p2.setAccount(a2);

//        // Try Bank Work
//        a2.deposit(30000);
//        a2.withdraw(170000);
//        a2.deposit(620000);
//        a2.withdraw(890000);

        // Try Bank To Bank
        a2.transfer(a1, 200000);
        a1.transfer(p2, 150000);
        p2.transfer(a1, 270000);
        p1.transfer(p2, 130000);

    }
}
