package com.masai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


class Consumer {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private String email;
    private boolean isActive;
	private String name;
	private int age;

    public Consumer(String firstName, String lastName, String address, String mobileNumber, String email) {
        this.username = generateUsername();
        this.password = generatePassword();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.isActive = true;
    }

    public Consumer(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }


	private String generateUsername() {
        return firstName.toLowerCase() + lastName.toLowerCase() + Math.round(Math.random() * 1000);
    }

    private String generatePassword() {
        return "password" + Math.round(Math.random() * 1000);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public char[] getBill() {
        // TODO Auto-generated method stub
        return null;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

public class Main {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private static final double FIXED_CHARGE = 100.0;
    private static final double UNIT_PRICE = 10.0;
    private static final double TAX_RATE = 0.025;

    private Map<String, Consumer> consumers;
    private Scanner scanner;

    public Main() {
        this.setConsumers(new HashMap<>());
        this.setScanner(new Scanner(System.in));
    }

    public class ConsumerSystem {

        private ArrayList<Consumer> consumers = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);

        public void run() {
            login();
            boolean exit = false;
            while (!exit) {
                System.out.println("Select an option 1️⃣:");
                System.out.println("1. Register a new consumer");
                System.out.println("2. View all consumers");
                System.out.println("3. Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        registerNewConsumer();
                        break;
                    case 2:
                        viewAllConsumers();
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again 😢.");
                }
            }
            System.out.println("Goodbye 👋!");
        }

        private boolean login() {
            System.out.print("Enter username 📛: ");
            String username = scanner.next();
            System.out.print("Enter password 😎: ");
            String password = scanner.next();

            if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                System.out.println("Login successful 😁 !");
                return true;
            } else {
                System.out.println("Incorrect username or password. Please try again 😒.");
                return false;
            }
        }

        private void registerNewConsumer() {
            System.out.println("Enter consumer name:");
            String name = scanner.next();
            System.out.println("Enter consumer age:");
            int age = scanner.nextInt();
            Consumer consumer = new Consumer(name, age);
            consumers.add(consumer);
            System.out.println("New consumer added successfully 😀.");
        }

        private void viewAllConsumers() {
            System.out.println("All consumers:");
            for (Consumer consumer : consumers) {
                System.out.println(consumer);
            }
        }
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        Main.ConsumerSystem consumerSystem = main.new ConsumerSystem();
        consumerSystem.run();
    }

	public static double getFixedCharge() {
		return FIXED_CHARGE;
	}

	public static double getUnitPrice() {
		return UNIT_PRICE;
	}

	public static double getTaxRate() {
		return TAX_RATE;
	}

	public Map<String, Consumer> getConsumers() {
		return consumers;
	}

	public void setConsumers(Map<String, Consumer> consumers) {
		this.consumers = consumers;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
}


    