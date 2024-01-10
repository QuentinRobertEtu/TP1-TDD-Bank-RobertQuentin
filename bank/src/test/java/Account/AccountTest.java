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
		assertEquals(this.compte.getCredit(), 0, 0);
		assertEquals(this.compte.getDebit(), 0, 0);
	}
	
	@Test
	public void TestIfAccountIsCredited() {
		assertEquals(this.compte.getCredit(), 0, 0);
		this.compte.creditAccount(500.0);
		assertEquals(this.compte.getCredit(), 500.0, 0);
	}
	
	@Test
	public void TestIfAccountIsDebited() {
		assertEquals(this.compte.getDebit(), 0, 0);
		this.compte.debitAccount(500.0);
		assertEquals(this.compte.getDebit(), 500.0, 0);
	}
}