package bankingservice;

public interface AccountService {
    void deposit(int amount);
    void withdraw(int ammount);
    void printStatement();
}
