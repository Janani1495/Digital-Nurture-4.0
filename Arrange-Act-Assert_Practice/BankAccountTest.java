import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount(1000.0);  // Arrange
        System.out.println("Setup complete.");
    }

    @After
    public void tearDown() {
        account = null;
        System.out.println("Teardown complete.");
    }

    @Test
    public void testDeposit() {
        // Act
        account.deposit(500.0);

        // Assert
        assertEquals(1500.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        // Act
        account.withdraw(300.0);

        // Assert
        assertEquals(700.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawTooMuch() {
        // Act
        account.withdraw(2000.0);

        // Assert
        assertEquals(1000.0, account.getBalance(), 0.001);
    }
}
