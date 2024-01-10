package Account;

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
	
	public void creditAccount(double d) {
		this.credit+= d;
	}
}
