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
		this.compte = new Account(2);
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
	
	@Test
	public void TestIfPayIsGoodWhenCreditedAndDebited() throws CantCreditNegativeValueException, CantDebitNegativeValueException {
		this.compte.creditAccount(1000);
		this.compte.debitAccount(300);
		this.compte.debitAccount(100);
		this.compte.creditAccount(500);
		assertEquals(this.compte.solde(), 1500-400, 0);
	}
	
	@Test
	public void TestIfCreditInListWhenCreditAccount() throws CantCreditNegativeValueException {
		this.compte.creditAccount(10);
		assertEquals(this.compte.getListCredit().get(0), 10, 0);
	}
	
	@Test
	public void TestIfCreditInListAtNextIndexWhenCreditAccount() throws CantCreditNegativeValueException {
		this.compte.creditAccount(10);
		this.compte.creditAccount(15);
		assertEquals(this.compte.getListCredit().get(1), 15, 0);
	}
	
	@Test
	public void TestIfSumOfSoldeAtIndex0WhenListIsFull() throws CantCreditNegativeValueException {
		this.compte.creditAccount(10);
		this.compte.creditAccount(10);
		this.compte.creditAccount(10);
		assertEquals(20, this.compte.getListCredit().get(0), 0);
	}
	
}