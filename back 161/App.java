package cs544.exercise16_1.bank;

import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;

import cs544.exercise16_1.bank.dao.HibernateUtil;
import cs544.exercise16_1.bank.domain.Account;
import cs544.exercise16_1.bank.domain.AccountEntry;
import cs544.exercise16_1.bank.domain.Customer;
import cs544.exercise16_1.bank.service.AccountService;
import cs544.exercise16_1.bank.service.IAccountService;



public class App {
	public static void main(String[] args) {
		IAccountService accountService = new AccountService();
		// create 2 accounts;
		
		
		try {
			
		accountService.createAccount(1263862, "Frank Brown");
		
		}
		catch (HibernateException e) {
			HibernateUtil.getSessionFactory().getCurrentSession()
 			.getTransaction().rollback();
			e.printStackTrace();
		} 
		
		try {
		accountService.createAccount(4253892, "John Doe");
		}
		
		catch (HibernateException e) {
			HibernateUtil.getSessionFactory().getCurrentSession()
 			.getTransaction().rollback();
			e.printStackTrace();
		}
		//use account 1;
		try {
		accountService.deposit(1263862, 240);
		}
		catch (HibernateException e) {
			HibernateUtil.getSessionFactory().getCurrentSession()
 			.getTransaction().rollback();
			e.printStackTrace();
		}
		try {
		accountService.deposit(1263862, 529);
		}
		
		catch (HibernateException e) {
			HibernateUtil.getSessionFactory().getCurrentSession()
 			.getTransaction().rollback();
			e.printStackTrace();
		}
		try {
		accountService.withdrawEuros(1263862, 230);
		}
		catch (HibernateException e) {
			HibernateUtil.getSessionFactory().getCurrentSession()
 			.getTransaction().rollback();
			e.printStackTrace();
		}
		//use account 2;
		
		try {
		accountService.deposit(4253892, 12450);
		}
		
		catch (HibernateException e) {
			HibernateUtil.getSessionFactory().getCurrentSession()
 			.getTransaction().rollback();
			e.printStackTrace();
		}
		
		try {
		accountService.depositEuros(4253892, 200);
		}
		
		catch (HibernateException e) {
			HibernateUtil.getSessionFactory().getCurrentSession()
 			.getTransaction().rollback();
			e.printStackTrace();
		}
		
		try {
		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		}
		
		catch (HibernateException e) {
			HibernateUtil.getSessionFactory().getCurrentSession()
 			.getTransaction().rollback();
			e.printStackTrace();
		}
		// show balances
		
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
	}

}


