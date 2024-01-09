package Account;

public class Account {
	
	private String owner;
	private int debit;
	private int credit;
	
	public Account(String name) {
		this.owner = name;
		this.credit = 0;
		this.debit = 0;
	}

	public int getDebit() {
		return this.debit;
	}
	
	public int getCredit() {
		return this.credit;
	}
}
