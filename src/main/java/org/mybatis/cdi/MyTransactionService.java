package org.mybatis.cdi;

import javax.transaction.Synchronization;
import javax.transaction.UserTransaction;

import org.jboss.weld.transaction.spi.TransactionServices;

public class MyTransactionService implements TransactionServices {

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerSynchronization(Synchronization synchronizedObserver) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isTransactionActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserTransaction getUserTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

}
