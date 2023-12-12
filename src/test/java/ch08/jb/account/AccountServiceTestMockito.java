package ch08.jb.account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTestMockito {
	@Mock
	private AccountManager mockManager;

	@Test
	@DisplayName("계좌이체 정상작동 - Mockito")
	void testTransfer() {
		Account sender = new Account("1", 2_0000);
		Account benefi = new Account("2", 1_0000);

		Mockito.lenient().when(mockManager.findAccountForUser("1"))
				.thenReturn(sender);

		Mockito.lenient().when(mockManager.findAccountForUser("2"))
				.thenReturn(benefi);

		AccountService service = new AccountService();
		service.setAccountManager(mockManager);
		service.transfer("1", "2", 5000);

		assertEquals(1_5000, sender.getBalance());
		assertEquals(1_5000, benefi.getBalance());
	}
}
