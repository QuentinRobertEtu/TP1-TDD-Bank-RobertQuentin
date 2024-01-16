package Account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest{
	
private Account compte;
	
	@BeforeEach
	public void init() {
		this.compte = new SavingsAccount(2);
	}
	
	@Test
	public void TestDebitAndCreditAt0WhenSavingsAccountCreated() {
		assertEquals(this.compte.getCredit(), 0, 0);
		assertEquals(this.compte.getDebit(), 0, 0);
	}
	
}
