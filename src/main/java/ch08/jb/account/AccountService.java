package ch08.jb.account;

public class AccountService {
	private AccountManager accountManager;

	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
	
	public void transfer(String senderId, String benefiId, long amount) {
		Account sender = accountManager.findAccountForUser(senderId);
		Account benefi = accountManager.findAccountForUser(benefiId);
		
		sender.debit(amount);
		benefi.credit(amount);
		
		accountManager.updateAccount(sender);
		accountManager.updateAccount(benefi);
	}
}

