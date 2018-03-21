import com.thoughtworks.step.bank.Account;
import com.thoughtworks.step.bank.MinimumBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws MinimumBalanceException {
         account = new Account("12345",5000);
    }

    @Test
    public void checkBalance() {
        assertThat(account.getBalance(), is(5000));
    }

    @Test
    public void checkAccountNo() {
        assertThat(account.getAccountno(),is("12345"));
    }

    @Test (expected = MinimumBalanceException.class)
    public void checkOpeningBalance() throws MinimumBalanceException {
        Account account = new Account("1224", 300);

    }

    @Test
    public void credit() {
        assertEquals(account.credit(1000),6000,0);
    }

    @Test
    public void debit() {
        assertEquals(account.debit(1000),4000,0);
    }
}
