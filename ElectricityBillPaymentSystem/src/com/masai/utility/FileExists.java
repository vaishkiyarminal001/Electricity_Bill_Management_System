package com.masai.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.masai.entities.Customer;
import com.masai.entities.bill;
import com.masai.entities.Transaction;


public class FileExists {
	
	public static Map<Integer, bill> billFile(){
		Map<Integer, bill> bFile = null;
		File f = new File("bill.ser");
		boolean flag = false;
		
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag = true;
			}
			if(flag) {
				bFile = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(bFile);
				return bFile;
				
			}else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				bFile = (Map<Integer, bill>) ois.readObject();
				
				return bFile;
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return bFile;
	}
	
	public static Map<String, Customer> customerFile(){
		Map<String, Customer> cFile = null;
		
		File f = new File("Cistomer.ser");
		boolean flag = false;
		
		try {
			if(!f.exists()) {
			f.createNewFile();
			flag=true;
			}
			
			if(flag) {
				cFile = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(cFile);
				return cFile;
			}
			else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				cFile = (Map<String, Customer>) ois.readObject();
				
				return cFile;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return cFile;
	}
	
	public static List<Transaction> transactionFile(){
		List<Transaction> tFile = new ArrayList<>();
		
		File f = new File("Transaction.ser");
		boolean flag = false;
		
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag = true;
			}
			if(flag) {
				tFile = new ArrayList<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(tFile);
				
				return tFile;
			} else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				tFile = (List<Transaction>) ois.readObject();
				return tFile;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return tFile;
	}
}
