package ch08.jb.account;

public interface AccountManager {
	Account findAccountForUser(String userId);
	void updateAccount(Account account);
}

