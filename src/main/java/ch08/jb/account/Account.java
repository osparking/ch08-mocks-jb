package ch08.jb.account;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Account {
	private String accountId;
	private long balance;
	
	public void debit(long amount) {
		this.balance -= amount;
	}
	
	public void credit(long amount) {
		this.balance += amount;
	}

	public long getBalance() {
		return balance;
	}
}
