package Account;

public class SavingsAccount extends Account{

	private float benefit;

	public SavingsAccount(int MAX_LIST, float benefit) {
		super(MAX_LIST);
		this.benefit = benefit;
	}
	
}
