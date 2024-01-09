package Account;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
	
	private Account compte;
	
	@BeforeEach
	public void init() {
		this.compte = new Account("a");
	}
	
	
	@Test
	public void TestDebitAndCreditAt0WhenAccountCreated() {
		assertEquals(this.compte.getCredit(),0);
		assertEquals(this.compte.getDebit(),0);
	}
}