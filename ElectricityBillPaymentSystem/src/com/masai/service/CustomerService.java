package com.masai.service;


import java.util.List;
import java.util.Map;
import java.util.Set;

import com.masai.entities.Customer;
import com.masai.entities.Product;
import com.masai.entities.Transaction;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.exceptions.ProductException;
import com.masai.exceptions.TransactionException;

public class CustomerService {
	
	public boolean login(String email, String password, Map<String, Customer> customers) throws InvalidDetailsException;
	
	public void signUp(Customer cus, Map<String, Customer> customers) throws DuplicateDataException;
	
	public boolean billDetail(int id, int quantity, String email, Map<Integer, bill> bills,
			Map<String, Customer> customers, List<Transaction> transactions)
	        throws InvalidDetailsException, ProductException;
	
	public boolean addMoneyWallet(double amount, String email, Map<String, Customer> customers);
	
	public double viewWalletBalance(String email, Map<String, Customer> customers);
	
	public Customer viewCustomeretails(String email, Map<String, Customer> customers);
	
	public List<Customer> viewAllCustomers(Map<String, Customer> customers) throws ProductException;

}
