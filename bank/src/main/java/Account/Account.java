package Account;

import Exception.CantCreditNegativeValueException;
import Exception.CantCreditOver100000Exception;
import Exception.CantDebitNegativeValueException;
import Exception.CantDebitOver100000Exception;

import java.util.*;

public class Account {
	
	private ArrayList<Double> listCredit;
	private ArrayList<Double> listDebit;
	private int max_list;
	
	public Account(int MAX_LIST) {
		this.listCredit = new ArrayList<Double>(MAX_LIST);
		this.listDebit = new ArrayList<Double>(MAX_LIST);
		this.max_list = MAX_LIST;
	}

	public double getDebit() {
		int deb=0;
		for (double d : this.getListDebit()) {
			deb+=d;
			}
		return deb;
	}
	
	public double getCredit() {
		int cred=0;
		for (double d : this.getListCredit()) {
			cred+=d;
			}
		return cred;
	}
	
	public void creditAccount(double d) throws CantCreditNegativeValueException, CantCreditOver100000Exception {
		if (d<=0) {
			throw new CantCreditNegativeValueException();
		} else if (d > 100000) {
			throw new CantCreditOver100000Exception();
		} else {
		this.addCreditToList(d);
		}
	}
	
	public void debitAccount(double d) throws CantDebitNegativeValueException, CantDebitOver100000Exception{
		if (d<=0) {
			throw new CantDebitNegativeValueException();
		} else if (d > 100000) {
			throw new CantDebitOver100000Exception();
		} else {
			this.addDebitToList(d);
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

	private void addDebitToList(double d) {
		if (this.listDebit.size() == this.max_list) {
			double solde=0;
			for (double c : this.listDebit) {
				solde+=c;
			}
			this.listDebit.clear();
			this.listDebit.add(solde);
		}
		this.listDebit.add(d);
		
	}

	public double solde() {
		return this.getCredit()-this.getDebit();
	}

	private List<Double> getListDebit() {
		return this.listDebit;
	}

	public List<Double> getListCredit() {
		return this.listCredit;
	}
}
