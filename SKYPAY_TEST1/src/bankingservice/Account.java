package bankingservice;

import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService{
    private int balance = 0;
    private final List<Transaction> transactions = new ArrayList<>();

    private final String[] dates = {
            "10/01/2012",
            "13/01/2012",
            "14/01/2012"
    };
    private int dateIndex = 0;
    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif");
        }
    }

    //Redéfinir les méthodes de l'interface.
    @Override
    public void deposit(int amount) {
        validateAmount(amount);

        balance += amount;
        transactions.add(new Transaction(
                dates[dateIndex++],
                amount,
                balance
        ));

    }
    @Override
    public void withdraw(int amount) {
        validateAmount(amount);

        if (amount > balance) {
            throw new IllegalArgumentException("Solde insuffisant");
        }

        balance -= amount;
        transactions.add(new Transaction(
                dates[dateIndex++],
                -amount,
                balance
        ));
    }

    @Override
    public void printStatement() {
        System.out.println("DATE       || AMOUNT || BALANCE");

        // Affichage du
        // plus récent
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);
            System.out.println(
                    t.getDate() + " || " +
                            t.getAmount() + " || " +
                            t.getBalance()
            );
        }
    }
}
