package Account;

import Exception.CantDebitNegativeValueException;
import Exception.CantDebitOver100000Exception;
import Exception.SoldeInferiorThanDebitException;

public class SavingsAccount extends Account{

	private float benefit;

	public SavingsAccount(int MAX_LIST, float benefit) {
		super(MAX_LIST);
		this.benefit = benefit;
	}
	
	@Override
	public void debitAccount(double d) throws CantDebitNegativeValueException, CantDebitOver100000Exception, SoldeInferiorThanDebitException{
		if (d<=0) {
			throw new CantDebitNegativeValueException();
		} else if (d > 100000) {
			throw new CantDebitOver100000Exception();
		} else {
			if (this.solde() < d) {
				throw new SoldeInferiorThanDebitException();
			} else {	
				this.addDebitToList(d);
			}
		}
	}
}
