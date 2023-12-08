package ch08.jb.account;

import org.junit.jupiter.api.Test;

import ch08.jb.config.MockConfiguration;

class DefaultAccountManager2Test {

	@Test
	void testFindAccountForUser() {
		MockLog logger = new MockLog();
		MockConfiguration configuration = new MockConfiguration();
		configuration.setSQL("SELECT * [...]");
		DefaultAccountManager2 am = new DefaultAccountManager2(logger,
				configuration);

		Account account = am.findAccountForUser("1234");

		// 여기서 결과에 관하여 단언(들) 생성
	}
}

