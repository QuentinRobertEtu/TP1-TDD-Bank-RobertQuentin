package Account;

public class Account {
	
	private String owner;
	private float debit;
	private float credit;
	
	public Account(String name) {
		this.owner = name;
		this.credit = 0;
		this.debit = 0;
	}

	public float getDebit() {
		return this.debit;
	}
	
	public float getCredit() {
		return this.credit;
	}
}
