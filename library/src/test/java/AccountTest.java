import com.thoughtworks.step.bank.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws MinimumBalanceException, InvalidAccountNumber {
         account = new Account("1234-1234",5000);
    }

    @Test
    public void getBalance() {
        assertEquals(account.getBalance(), 5000,0);
    }

    @Test
    public void getAccountNumber() {
        assertThat(account.getAccountno(),is("1234-1234"));
    }

    @Test (expected = MinimumBalanceException.class)
    public void check_opening_balance_of_the_account() throws MinimumBalanceException, InvalidAccountNumber {
        Account account = new Account("1224-1233", 300);

    }

    @Test
    public void credit_amount_into_the_accont() throws InvalidAmount {
        assertEquals(account.credit(1000),6000,0);
    }

    @Test
    public void debit_amount_from_account() throws InvalidAmount {
        assertEquals(account.debit(1000),4000,0);
    }

    @Test (expected = InvalidAmount.class)
    public void check_debit_with_amount_more_than_balance() throws InvalidAmount {
        account.debit(7000);
    }

    @Test (expected = InvalidAccountNumber.class)
    public void check_the_account_number_is_valid_or_not() throws MinimumBalanceException, InvalidAccountNumber {
        Account account = new Account("123456",5000);
    }
    @Test (expected = InvalidAccountNumber.class)
    public void check_the_account_number_for_alphanumeric_value() throws MinimumBalanceException, InvalidAccountNumber {
        Account account = new Account("abcd-1234",5000);
    }

    @Test (expected = InvalidAmount.class)
    public void check_amount_credit_is_valid_or_not() throws InvalidAmount {
        account.credit(-90);
    }
}
