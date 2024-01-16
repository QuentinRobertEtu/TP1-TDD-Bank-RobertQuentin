package Account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exception.CantCreditNegativeValueException;
import Exception.CantCreditOver100000Exception;

public class SavingsAccountTest{
	
private Account compte;
	
	@BeforeEach
	public void init() {
		this.compte = new SavingsAccount(2, 2);
	}
	
	@Test
	public void TestDebitAndCreditAt0WhenSavingsAccountCreated() {
		assertEquals(this.compte.getCredit(), 0, 0);
		assertEquals(this.compte.getDebit(), 0, 0);
	}
	
	@Test
	public void TestIfAccountIsCredited() throws CantCreditNegativeValueException, CantCreditOver100000Exception {
		assertEquals(this.compte.getCredit(), 0, 0);
		this.compte.creditAccount(500.0);
		assertEquals(this.compte.getCredit(), 500.0, 0);
	}
	
	@Test
	public void TestIfPayIsGoodWhenCredited() throws CantCreditNegativeValueException, CantCreditOver100000Exception {
		this.compte.creditAccount(500.0);
		this.compte.creditAccount(500.0);
		assertEquals(this.compte.solde(), 1000.0, 0);
	}
}