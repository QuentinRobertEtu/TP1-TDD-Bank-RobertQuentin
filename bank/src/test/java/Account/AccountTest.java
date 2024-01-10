package Account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exception.CantCreditNegativeValueException;
import Exception.CantDebitNegativeValueException;

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
	public void TestIfAccountIsCredited() throws CantCreditNegativeValueException {
		assertEquals(this.compte.getCredit(), 0, 0);
		this.compte.creditAccount(500.0);
		assertEquals(this.compte.getCredit(), 500.0, 0);
	}
	
	@Test
	public void TestIfAccountIsDebited() throws CantDebitNegativeValueException {
		assertEquals(this.compte.getDebit(), 0, 0);
		this.compte.debitAccount(500.0);
		assertEquals(this.compte.getDebit(), 500.0, 0);
	}
	
	@Test
	public void TestIfNegatifThrowsExceptionWhenCredited() throws CantCreditNegativeValueException {
		assertThrows(CantCreditNegativeValueException.class, () -> {this.compte.creditAccount(-500.0);});
	}
	
	@Test
	public void TestIfNegatifThrowsExceptionWhenDebited() throws CantDebitNegativeValueException {
		assertThrows(CantDebitNegativeValueException.class, () -> {this.compte.debitAccount(-500.0);});
	}
	
}