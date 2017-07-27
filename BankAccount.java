/**
 * Created by 민우 on 2017-07-06.
 */
public class BankAccount {
    private int balance;
    private Person owner;

    public BankAccount(int pBalance){
        if (pBalance<0){
            balance=0;
        }
        else balance=pBalance;
    }
    public BankAccount(Person pOwner) {
        owner=pOwner;
        balance=0;
    }
    public BankAccount(int pBalance, Person pOwner) {
        owner=pOwner;
        if (pBalance<0){
            balance=0;
        }
        else balance=pBalance;
    }

    public void setBalance(int newBalance){
        if (newBalance>=0){
            balance=newBalance;
        }
    }
    public int getBalance(){
        return balance;
    }

    public void setOwner(Person newOwner){
        owner=newOwner;
    }
    public Person getOwner(){
        return owner;
    }

    // 파라미터 : 입금할 액수(정수)
    // 리턴 : 성공여부(불린)
    boolean deposit(int amount) {
        if (amount>owner.getCashAmount()||amount<0){
            System.out.println("입금 실패입니다. 잔고: " + balance + "원, 현금: " + owner.getCashAmount() + "원");
            System.out.println("false");
            return false;
        }
        else {
            balance=balance+amount;
            owner.setCashAmount(owner.getCashAmount()-amount);
            System.out.println(amount+"원 입금하였습니다. 잔고: " + balance + "원, 현금: " + owner.getCashAmount() + "원");
            System.out.println("true");
            return true;
        }
    }

    // 파라미터 : 출금할 액수(정수)
    // 리턴 : 성공여부(불린)
    boolean withdraw(int amount) {
        if (amount>balance||amount<0){
            System.out.println("출금 실패입니다. 잔고: " + balance + "원, 현금: " + owner.getCashAmount() + "원");
            System.out.println("false");
            return false;
        }
        else {
            balance=balance-amount;
            owner.setCashAmount(owner.getCashAmount()+amount);
            System.out.println(amount+"원 출금하였습니다. 잔고: " + balance + "원, 현금: " + owner.getCashAmount() + "원");
            System.out.println("true");
            return true;
        }
    }

    // 첫 번째 파라미터 : 받는 사람(Person)
    // 두 번째 파라미터 : 이체할 금액(정수)
    // 리턴 : 성공여부(불린)

    public boolean transfer(Person to, int amount) {
        return transfer(to.getAccount(), amount);
    }
    public boolean transfer(BankAccount to, int amount){
        if (amount>balance||amount<0){
            System.out.println(false +" - from: ["+owner.getName()+"], to: ["+to.getOwner().getName()+"], amount: ["+amount+"], deposit: ["+balance+"]");
            return false;
        }
        else
            balance-=amount;
            to.balance+=amount;
            System.out.println(true + " - from: ["+owner.getName()+"], to: ["+to.getOwner().getName()+"], amount: ["+amount+"], deposit: ["+balance+"]");
            return true;
    }
}
