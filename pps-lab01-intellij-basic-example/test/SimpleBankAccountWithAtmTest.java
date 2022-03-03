import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccount;

import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountWithAtmTest extends AbstractBankTest {

    private SimpleBankAccountWithAtm bankAccountAtm;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, 0);
        bankAccountAtm = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testDepositWithAtm() {
        bankAccountAtm.deposit(accountHolder.getId(), 100);
        assertEquals(99, bankAccountAtm.getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        bankAccountAtm.deposit(accountHolder.getId(), 100);
        bankAccountAtm.deposit(2, 50);
        assertEquals(99, bankAccountAtm.getBalance());
    }

    @Test
    void testWithdrawWithAtm() {
        bankAccountAtm.deposit(accountHolder.getId(), 100);
        bankAccountAtm.withdraw(accountHolder.getId(), 70);
        assertEquals(28, bankAccountAtm.getBalance());
    }

    @Test
    void testWrongWithdrawWithAtm() {
        bankAccountAtm.deposit(accountHolder.getId(), 100);
        bankAccountAtm.withdraw(2, 70);
        assertEquals(99, bankAccountAtm.getBalance());
    }
}
