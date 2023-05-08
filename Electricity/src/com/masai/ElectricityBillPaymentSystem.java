package com.masai;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ElectricityBillPaymentSystem {
    private static final String DATA_FILE = "data.ser";

    public static void main(String[] args) {
        Administrator administrator = deserializeData();
        Scanner scanner = new Scanner(System.in);

        if (administrator == null) {
            administrator = new Administrator();
        }

        System.out.println("Welcome to the Electricity Bill Payment System!");

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("Please enter your role (Administrator/Consumer): ");
            String role = scanner.nextLine();
            if (role.equalsIgnoreCase("Administrator")) {
                loggedIn = administrator.login();
                if (!loggedIn) {
                    continue;
                }
                boolean adminMenu = true;
                while (adminMenu) {
                    System.out.println("Please select an option: ");
                    System.out.println("1. Register new consumer");
                    System.out.println("2. View all consumers");
                    System.out.println("3. View consumer bill");
                    System.out.println("4. View all bills");
                    System.out.println("5. View paid and pending bills");
                    System.out.println("6. Delete consumer");
                    System.out.println("7. Logout");
                    int option = scanner.nextInt();
                    scanner.nextLine();
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
                            adminMenu = false;
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }
                }
            } else if (role.equalsIgnoreCase("Consumer")) {
                Consumer consumer = null;
                boolean consumerMenu = true;
                while (consumerMenu) {
                    System.out.println("Please select an option: ");
                    System.out.println("1. Signup");
                    System.out.println("2. Login");
                    System.out.println("3. Pay bill");
                    System.out.println("4. View transaction history");
                    System.out.println("5. Logout");
                    int option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 1:
                            consumer = new Consumer();
                            consumer.signup();
                            break;
                        case 2:
                            consumer = Consumer.login();
                            if (consumer != null) {
                                System.out.println("Login successful. Welcome, " + consumer.getFullName() + "!");
                            }
                            break;
                        case 3:
                            if (consumer == null) {
                                System.out.println("You need to login first.");
                                break;
                            }
                            consumer.payBill();
                            break;
                        case 4:
                            if (consumer == null) {
                                System.out.println("You need to login first.");
                                break;
                            }
                            consumer.viewTransactionHistory();
                            break;
                        case 5:
                            consumerMenu = false;
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }
                }
            } else {
                System.out.println("Invalid role. Please try again.");
            }
        }

        serializeData(administrator);
        System.out.println("Thank you for using the Electricity Bill Payment System!");
    }

    static Administrator deserializeData() {
        try {
            FileInputStream fileIn = new FileInputStream(DATA_FILE);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Administrator administrator = (Administrator) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Data loaded successfully.");
            return administrator;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No data found. Starting with an empty system.");
            return null;
        }
    }

    private static void serializeData(Administrator administrator) {
        try {
            FileOutputStream fileOut = new FileOutputStream(DATA_FILE);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(administrator);
            out.close();
            fileOut.close();
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the data.");
            e.printStackTrace();
        }
    }
}
