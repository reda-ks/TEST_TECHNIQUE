package bankingservice;

public class Main {
    public static void main(String[] args) {
        //instancier l'objet (le comportement) Account
        AccountService account = new Account();

        //   Transaction = IMMUTABLE
        //   on interdit le changement de
        //   l'etat de l'objet aprés son initialisation.
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        //printer la transaction
        //sous la forme demandé.
        account.printStatement();
    }
}
