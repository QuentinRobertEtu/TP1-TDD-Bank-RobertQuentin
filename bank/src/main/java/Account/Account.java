package Account;

import Exception.CantCreditNegativeValueException;
import Exception.CantDebitNegativeValueException;

public class Account {
	
	private double debit;
	private double credit;
	
	public Account(String name) {
		this.credit = 0;
		this.debit = 0;
	}

	public double getDebit() {
		return this.debit;
	}
	
	public double getCredit() {
		return this.credit;
	}
	
	public void creditAccount(double d) throws CantCreditNegativeValueException {
		if (d<0) {
			throw new CantCreditNegativeValueException();
		} else {
		this.credit+= d;
		}
	}
	
	public void debitAccount(double d) throws CantDebitNegativeValueException{
		if (d <0) {
			throw new CantDebitNegativeValueException();
		} else {
		this.debit+= d;
		}
	}

	public double solde() {
		return this.credit - this.debit; 
	}
}
