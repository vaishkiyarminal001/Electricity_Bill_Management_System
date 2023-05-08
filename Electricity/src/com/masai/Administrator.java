package com.masai;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Administrator implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private String username;
    private String password;
    private List<Consumer> consumers;

    public Administrator() {
        this.username = ADMIN_USERNAME;
        this.password = ADMIN_PASSWORD;
        this.consumers = new ArrayList<>();
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the admin username: ");
        String username = scanner.nextLine();
        System.out.println("Enter the admin password: ");
        String password = scanner.nextLine();
        if (this.username.equals(username) && this.password.equals(password)) {
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }

    public void registerConsumer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter the address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the mobile number: ");
        String mobileNumber = scanner.nextLine();
        System.out.println("Enter the email: ");
        String email = scanner.nextLine();
        System.out.println("Enter the username: ");
        String username = scanner.nextLine();
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username)) {
                System.out.println("This username already exists. Please try again.");
                return;
            }
        }
        System.out.println("Enter the password: ");
        String password = scanner.nextLine();
        Consumer consumer = new Consumer(firstName, lastName, address, mobileNumber, email, username, password);
        consumers.add(consumer);
        System.out.println("Consumer registered successfully.");
    }

    public void viewAllConsumers() {
        for (Consumer consumer : consumers) {
            System.out.println(consumer.toString());
        }
    }

    public void viewConsumerBill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the consumer username: ");
        String username = scanner.nextLine();
        for (Consumer consumer : consumers) {
            if (consumer.getUsername().equals(username)) {
                List<Consumer> bills = (List<Consumer>) consumer.getBills();
                if (bills.isEmpty()) {
                    System.out.println("This consumer does not have any bills yet.");
                    return;
                } else {
                    for (Consumer bill : bills) {
                        System.out.println(bill.toString());
                    }
                    return;
                }
            }
        }
        System.out.println("Invalid consumer username. Please try again.");
    }

    public void viewAllBills() {
        for (Consumer consumer : consumers) {
            List<Consumer> bills = (List<Consumer>) consumer.getBills();
            if (!bills.isEmpty()) {
                for (Consumer bill : bills) {
                    System.out.println(bill.toString());
                }
            }
        }
    }
 
    @SuppressWarnings("unchecked")
    public void viewPaidAndPendingBills() {
        List<Bill> paidBills = new ArrayList<>();
        List<Bill> pendingBills = new ArrayList<>();
        for (Consumer consumer : consumers) {
            List<Consumer> bills = consumer.getBills();
            if (!bills.isEmpty()) {
                for (Consumer bill : bills) {
                    if (bill.getStatus() == BillStatus.PAID) {
                        paidBills.addAll((Collection<? extends Bill>) bill);
                    } else if (bill.getStatus() == BillStatus.PENDING) {
                        pendingBills.addAll((Collection<? extends Bill>) bill);
                    }
                }
            }
        }
        System.out.println("Paid Bills:");
        for (Bill bill : paidBills) {
            System.out.println(bill.toString());
        }
        System.out.println("Pending Bills:");
        for (Bill bill : pendingBills) {
            System.out.println(bill.toString());
        }
    }

	public void deleteConsumer() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the consumer username: ");
	    String username = scanner.nextLine();
	    for (Consumer consumer : consumers) {
	    	if (consumer.getUsername().equals(username)) {
	    		consumer.getBills().clear();
	    		consumers.remove(consumer);
	    		System.out.println("Consumer deleted successfully.");
	    		return;
	    		}
	    		}
	    		System.out.println("Invalid consumer username. Please try again.");
	    		}
	@Override
	public String toString() {
	    return "Username: " + username + "\n";
	}

	public Consumer getConsumerByUsername(String username2) {
		// TODO Auto-generated method stub
		return null;
	}


public static void main(String[] args) {
    Administrator administrator = new Administrator();
    boolean isLoggedIn = administrator.login();
    Scanner scanner = new Scanner(System.in);
    while (isLoggedIn) {
        System.out.println("Enter the option number:");
        System.out.println("1. Register a new consumer");
        System.out.println("2. View all consumers");
        System.out.println("3. View a consumer's bill");
        System.out.println("4. View all bills");
        System.out.println("5. View paid and pending bills");
        System.out.println("6. Delete a consumer");
        System.out.println("7. Exit");
        int option = scanner.nextInt();
        scanner.nextLine(); // to consume the remaining newline character

        switch (option) {
            case 1:
                administrator.registerConsumer();
                break;
            case 2:
                administrator.viewAllConsumers();
                break;
            case 3:
                administrator.viewConsumerBill();
                break;
            case 4:
                administrator.viewAllBills();
                break;
            case 5:
                administrator.viewPaidAndPendingBills();
                break;
            case 6:
                administrator.deleteConsumer();
                break;
            case 7:
                System.out.println("Goodbye!");
                isLoggedIn = false;
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}
}

