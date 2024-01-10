package Account;

import Exception.CantCreditNegativeValueException;
import Exception.CantDebitNegativeValueException;
import java.util.*;

public class Account {
	
	private double debit;
	private double credit;
	private ArrayList<Double> listCredit;
	private ArrayList<Double> listDebit;
	private int max_list;
	
	public Account(int MAX_LIST) {
		this.credit = 0;
		this.debit = 0;
		this.listCredit = new ArrayList<Double>(MAX_LIST);
		this.listDebit = new ArrayList<Double>(MAX_LIST);
		this.max_list = MAX_LIST;
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
		this.addCreditToList(d);
		}
	}
	
	private void addCreditToList(double d) {
		if (this.listCredit.size() == this.max_list) {
			double solde=0;
			for (double c : this.listCredit) {
				solde+=c;
			}
			this.listCredit.clear();
			this.listCredit.add(solde);
		}
		this.listCredit.add(d);
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

	public List<Double> getListCredit() {
		return this.listCredit;
	}
}
