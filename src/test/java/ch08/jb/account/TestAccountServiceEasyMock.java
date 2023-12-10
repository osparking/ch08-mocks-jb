package ch08.jb.account;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestAccountServiceEasyMock {
	private AccountManager mockAccountMan;
	
	@BeforeEach
	public void setUp() {
		mockAccountMan = createMock("mockAccountMan", AccountManager.class);
	}

	@Test
	@DisplayName("EasyMock 사용한 계좌이체 시험")
	public void testTransferOK() {
		Account sender = new Account("1", 2_0000);
		Account benefi = new Account("2", 1_0000);
		
		mockAccountMan.updateAccount(sender);
		mockAccountMan.updateAccount(benefi);
		
		expect(mockAccountMan.findAccountForUser("1")).andReturn(sender);
		expect(mockAccountMan.findAccountForUser("2")).andReturn(benefi);
		replay(mockAccountMan);
		
		AccountService service = new AccountService();
		service.setAccountManager(mockAccountMan);
		service.transfer("1", "2", 5000);
		
		assertEquals(1_5000, sender.getBalance());
		assertEquals(1_5000, benefi.getBalance());
	}
	
	@AfterEach
	public void tearDown() {
		verify(mockAccountMan);
	}
}
