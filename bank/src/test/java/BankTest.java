class BankTest {
	
	private Account compte;
	
	@BeforeEach
	public void init() {
		this.compte = new Account();
	}
	
	
	@Test
	public void TestDebitAndCreditAt0WhenAccountCreated() {
		Account compte2 = new Account();
		assertEquals(compte.getDebit, 0);
		assertEquals(compte.getCredit, 0);
		assertEquals(compte2.getDebit, 0);
		assertEquals(compte2.getCredit, 0);
	}
}