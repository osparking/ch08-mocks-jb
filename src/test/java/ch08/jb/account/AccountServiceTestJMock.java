package ch08.jb.account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.junit5.JUnit5Mockery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class AccountServiceTestJMock {
	@RegisterExtension
	Mockery context = new JUnit5Mockery();
	
	private AccountManager mockAccountManager;
	
	@BeforeEach
	public void setUp() {
		mockAccountManager = context.mock(AccountManager.class);
	}
	
	@Test
	public void testMoneyTransfer() {
		Account sender = new Account("1", 2_0000);
		Account benefi = new Account("2", 1_0000);
		
		context.checking(new Expectations() {
			{
				oneOf(mockAccountManager).findAccountForUser("1");
				will(returnValue(sender));
				oneOf(mockAccountManager).findAccountForUser("2");
				will(returnValue(benefi));
				
				oneOf(mockAccountManager).updateAccount(sender);
				oneOf(mockAccountManager).updateAccount(benefi);
			}
		});
		
		AccountService service = new AccountService();
		service.setAccountManager(mockAccountManager);
		
		service.transfer("1", "2", 5000);
		
		assertEquals(1_5000, sender.getBalance());
		assertEquals(1_5000, benefi.getBalance());		
	}
}
