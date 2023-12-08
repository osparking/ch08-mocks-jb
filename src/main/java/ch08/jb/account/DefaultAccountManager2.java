package ch08.jb.account;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ch08.jb.config.Configuration;
import ch08.jb.config.DefaultConfiguration;

public class DefaultAccountManager2 implements AccountManager {

	private Log logger;
	private Configuration configuration;

	public DefaultAccountManager2() {
		this(LogFactory.getLog(DefaultAccountManager2.class),
				new DefaultConfiguration("technical"));
	}

	public DefaultAccountManager2(Log logger, Configuration configuration) {
		this.logger = logger;
		this.configuration = configuration;
	}

	@Override
	public Account findAccountForUser(String userId) {
		logger.debug("Getting account for user: " + userId);
		String sql = configuration.getSQL("FIND_ACCOUNT_FOR_USER");
		// 사용자 계좌 적재 논리 코드(JDBC 사용) 등 
		return null;
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub

	}
}

