package com.masai;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Consumer implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private String email;
    private String username;
    private String password;
    private List<Consumer> bills;
    private boolean isActive;

    public Consumer(String firstName, String lastName, String address, String mobileNumber, String email,
                    String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.bills = new ArrayList<>();
    }
    
    public Consumer() {
        this.bills = new ArrayList<>();
        this.setActive(true);
    }
    
    public void signup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your first name: ");
        
        this.firstName = scanner.nextLine();
        System.out.println("Please enter your last name: ");
        
        this.lastName = scanner.nextLine();
        System.out.println("Please enter your address: ");
        
        this.address = scanner.nextLine();
        System.out.println("Please enter your mobile number: ");
        
        this.mobileNumber = scanner.nextLine();
        System.out.println("Please enter your email: ");
        
        this.email = scanner.nextLine();
        boolean valid = false;
        
        while (!valid) {
            System.out.println("Please enter a username: ");
            String username = scanner.nextLine();
            if (isValidUsername(username)) {
                this.username = username;
                valid = true;
            } else {
                System.out.println("Username already exists. Please try again.");
            }
        }
        System.out.println("Please enter a password: ");
        this.password = scanner.nextLine();
        System.out.println("Signup successful!");
    }

    public static Consumer login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        Administrator administrator = ElectricityBillPaymentSystem.deserializeData();
        if (administrator == null) {
            System.out.println("No system data found. Please contact the administrator.");
            return null;
        }
        Consumer consumer = administrator.getConsumerByUsername(username);
        if (consumer == null || !consumer.getPassword().equals(password) || !consumer.isActive()) {
            System.out.println("Invalid username or password. Please try again.");
            return null;
        }
        return consumer;
    }

    private boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isValidUsername(String username) {
        Administrator administrator = ElectricityBillPaymentSystem.deserializeData();
        if (administrator == null) {
            return true;
        }
        Consumer consumer = administrator.getConsumerByUsername(username);
        return consumer == null;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addBill(Consumer bill) {
        bills.add(bill);
    }

    public void payBill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the bill ID to pay: ");
        String billId = scanner.nextLine();
        for (Consumer bill : bills) {
            if (bill.getId().equals(billId)) {
                if (bill.getStatus() == BillStatus.PENDING) {
                    double amount = bill.getAmount();
                    double tax = amount * 0.025;
                    double totalAmount = amount + tax;
                    System.out.println("Your total bill amount including tax is: " + totalAmount);
                    System.out.println("Enter the amount to pay: ");
                    double amountPaid = scanner.nextDouble();
                    if (amountPaid >= totalAmount) {
                        double change = amountPaid - totalAmount;
                        System.out.println("Thank you for paying your bill. Your change is: " + change);
                        bill.setStatus(BillStatus.PAID);
                        bill.setAmountPaid(totalAmount);
                        bill.setDatePaid(LocalDate.now());
                        return;
                    } else {
                        System.out.println("The amount paid is not enough. Please pay the full amount.");
                        return;
                    }
                } else {
                    System.out.println("This bill has already been paid or dismissed.");
                    return;
                }
            }
        }
        System.out.println("Invalid bill ID. Please try again.");
    }

    private Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	private double getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void setStatus(BillStatus paid) {
		// TODO Auto-generated method stub
		
	}

	private void setAmountPaid(double totalAmount) {
		// TODO Auto-generated method stub
		
	}

	private void setDatePaid(LocalDate now) {
		// TODO Auto-generated method stub
		
	}

	public void viewTransactionHistory() {
        for (Consumer bill : bills) {
            System.out.println(bill.toString());
        }
    }

    @Override
    public String toString() {
        return "Name: " + getFullName() + "\n" +
                "Address: " + address + "\n" +
                "Mobile Number: " + mobileNumber + "\n" +
                "Email: " + email + "\n" +
                "Username: " + username + "\n";
    }

	public List<Consumer> getBills1() {
		// TODO Auto-generated method stub
		return null;
	}

	public BillStatus getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Consumer> getBills() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}

