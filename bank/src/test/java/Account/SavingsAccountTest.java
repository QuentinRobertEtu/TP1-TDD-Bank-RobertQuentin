package Account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exception.CantCreditNegativeValueException;
import Exception.CantCreditOver100000Exception;
import Exception.CantDebitNegativeValueException;
import Exception.CantDebitOver100000Exception;
import Exception.SoldeInferiorThanDebitException;

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
	
	/*
	@Test
	public void TestIfNothingChangeWhenDebitAValueSuperiorToPay() throws CantCreditNegativeValueException, CantCreditOver100000Exception, CantDebitNegativeValueException, CantDebitOver100000Exception {
		this.compte.debitAccount(500.0);
		assertEquals(this.compte.solde(), 0, 0);
	}
	*/
	
	@Test
	public void TestIfExceptionThrowsWhenDebitAValueSuperiorToPay() {
		assertThrows(SoldeInferiorThanDebitException.class, () -> {this.compte.debitAccount(500.0);});
	}
	
	@Test
	public void TestIfBenefitCalculIsGood() throws CantCreditNegativeValueException, CantCreditOver100000Exception {
		this.compte.creditAccount(100);
		this.compte.calculBenefit();
		assertEquals(this.compte.getCredit(), 100*this.compte.getBenefitRate()+100);
	}
	
	@Test
	public void TestIfEcheanceRunGood() throws CantCreditNegativeValueException, CantCreditOver100000Exception {
		this.compte.creditAccount(100);
		this.compte.echance();
		assertEquals(this.compte.getCredit(), 100*this.compte.getBenefitRate()+100);
	}
}
