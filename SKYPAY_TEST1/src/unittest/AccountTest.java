package unittest;

import bankingservice.Account;
import bankingservice.AccountService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AccountTest {

    private AccountService account;

    @Before
    public void setUp() {
        account = new Account();
    }
    @Test
    public void should_print_statement_after_deposits_and_withdrawal() {
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        // Capture de la sortie console
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        account.printStatement();

        String output = outContent.toString();

        Assert.assertTrue(output.contains("14/01/2012"));
        Assert.assertTrue(output.contains("-500"));
        Assert.assertTrue(output.contains("2500"));

        Assert.assertTrue(output.contains("13/01/2012"));
        Assert.assertTrue(output.contains("2000"));
        Assert.assertTrue(output.contains("3000"));

        Assert.assertTrue(output.contains("10/01/2012"));
        Assert.assertTrue(output.contains("1000"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_deposit_is_negative() {
        account.deposit(-100);
    }
}
