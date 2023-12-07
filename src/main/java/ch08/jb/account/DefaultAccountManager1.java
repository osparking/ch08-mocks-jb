package ch08.jb.account;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultAccountManager1 implements AccountManager {
	private static final Log logger = 
			LogFactory.getLog(DefaultAccountManager1.class);
	
	@Override
	public Account findAccountForUser(String userId) {
		logger.debug("Getting account for user: " + userId);
		ResourceBundle bundle = PropertyResourceBundle.getBundle("technical");
		String sql = bundle.getString("FIND_ACCOUNT_FOR_USER");
		// 사용자 계좌 적재 논리 코드(JDBC 사용) 등 
		return null;
	}

	@Override
	public void updateAccount(Account account) {
		// 데이터베이스 접근을 여기서 행한다.
	}
}

