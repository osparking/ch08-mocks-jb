package ch08.jb.account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountServiceTest {

	@Test
	@DisplayName("계좌이체 정상작동")
	void testTransfer() {
		Account sender = new Account("1", 2_0000);
		Account benefi = new Account("2", 1_0000);
		
		MockAccountManager manager = new MockAccountManager();
		manager.addAccount("1", sender);
		manager.addAccount("2", benefi);
		
		AccountService service = new AccountService();
		service.setAccountManager(manager);
		
		service.transfer("1", "2", 5000);
		
		assertEquals(1_5000, sender.getBalance());
		assertEquals(1_5000, benefi.getBalance());
	}
}

