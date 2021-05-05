package cs544.exercise17_1.bank.dao;

import java.util.*;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import cs544.exercise17_1.bank.domain.Account;


@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class AccountDAO implements IAccountDAO {
Collection<Account> accountlist = new ArrayList<Account>();


SessionFactory sessionFactory;



@Autowired	
@Transactional(propagation=Propagation.SUPPORTS)
public void setSessionFactory(SessionFactory sf) {
this.sessionFactory= sf;
}

	public void saveAccount(Account account) {
		// System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
		accountlist.add(account); // add the new
		
		sessionFactory.getCurrentSession().persist(account);

		
		
	}

	public void updateAccount(Account account) {
		// System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
		/*Account accountexist = loadAccount(account.getAccountnumber());
		if (accountexist != null) {
			accountlist.remove(accountexist); // remove the old
			accountlist.add(account); // add the new
		}*/
		
		sessionFactory.getCurrentSession().saveOrUpdate(account);

	}

	public Account loadAccount(long accountnumber) {
		// System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
		/*for (Account account : accountlist) {
			if (account.getAccountnumber() == accountnumber) {
				return account;
			}
		}*/
		
		return (Account)sessionFactory.getCurrentSession().get(Account.class, accountnumber);
		//
	}

	public Collection<Account> getAccounts() {
		return sessionFactory.getCurrentSession().createQuery("from Account").list();
	}


}
