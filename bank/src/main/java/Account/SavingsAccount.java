package Account;

import Exception.CantCreditNegativeValueException;
import Exception.CantCreditOver100000Exception;
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
	
	@Override
	public float getBenefitRate() {
		return this.benefit;
	}
	
	@Override
	public void calculBenefit() throws CantCreditNegativeValueException, CantCreditOver100000Exception {
		double c = this.getCredit()*this.getBenefitRate();
		this.creditAccount(c);
	}
}
