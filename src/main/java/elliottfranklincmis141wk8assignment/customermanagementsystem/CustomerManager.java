
package elliottfranklincmis141wk8assignment.customermanagementsystem;

/**Week 8 Assignment 7
 * Author: Franklin Elliott
 * Date: 2023-05-08
 * Purpose: Java program to manage customers and their order data
 * The program allows users to add, retrieve and display customer 
 * information based on customer ID and/or total sales amount.
 * 
 * CustomerManager file has the menu and all the methods for each selection
 * as well as the arrays to hold information.
 */

import java.util.Scanner; //import scanner

public class CustomerManager {//Customer Manager Class
    private static final int MAX_CUSTOMERS = 100; // Set maximum number of customers to be stored
    private static Customer[] customers = new Customer[MAX_CUSTOMERS]; // Array to store customers
    private static int numCustomers = 0; // Number of customers currently stored

    private static int displayMenu(Scanner scanner) { //display menu method that returns selection
        System.out.println("\tMenu");
        System.out.println("1. Add multiple new customers");
        System.out.println("2. Add single new customer");
        System.out.println("3. Display all customers");
        System.out.println("4. Retrieve specific customer's data");
        System.out.println("5. Retrieve customers with total sales in a range");
        System.out.println("6. Exit");
        System.out.print("\nEnter your selection: ");
        return scanner.nextInt();
    }

   
    private static void addMultipleCustomers(Scanner scanner) { //add multiple customers method
        System.out.print("Enter the number of customers to add: ");
        int numNewCustomers = scanner.nextInt();//input number of customers to be added
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numNewCustomers; i++) {//for each customer get name, id, and sales total
            System.out.printf("Enter data for customer %d:\n", i + 1);
            System.out.print("Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Customer ID (5-digit number): ");
            int customerId = scanner.nextInt();
            
            System.out.print("Total sales: ");
            double totalSales = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            Customer newCustomer = new Customer(name, customerId, totalSales);
            customers[numCustomers] = newCustomer;//Make a new customer with the values and place them in the customer array
            numCustomers++;//update the number of current customers stored
        }

        System.out.println("Customers added successfully!");
    }
    
    public static void addSingleCustomer(Scanner scanner) {//add single customer method and get name, id, and total sales
        System.out.print("Enter customer name: ");
        scanner.nextLine(); // consume the newline
        String name = scanner.nextLine();
        
        
        System.out.print("Enter customer id (5 digits): ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        
        System.out.print("Enter total sales: ");
        double totalSales = scanner.nextDouble();

        Customer customer = new Customer(name, id, totalSales);
        customers[numCustomers] = customer;//Make a new customer with the values and place them in the customer array
        numCustomers++;//update the number of current customers stored

    System.out.println("Customer added successfully!");
    }
    
    public void displayAllCustomers() {//display all customers method
        if (numCustomers == 0) {//if statement to make sure the customers array is not empty
            System.out.println("No customers found.");
        }else {
            System.out.println("\nCustomer Details:");
            for (int i = 0; i < numCustomers; i++) {//for each customer in customers array print toString
                System.out.println(customers[i].toString());
            }
        }
    }
    
    public static void retrieveCustomerData(Scanner scanner) {//retrieve specific customer data with id method
        System.out.print("Enter customer id: ");
        int id = scanner.nextInt();

        boolean found = false; //found Boolean to check if id number id found = false
        for (int i = 0; i < numCustomers; i++) {//for each customer in the array getId and see if it equals user input Id
            if (customers[i].getId() == id) {//if there is a match then print name, id, and total sales
                System.out.println("\nCustomer name: " + customers[i].getName());
                System.out.println("Customer id: " + customers[i].getId());
                System.out.println("Total sales: $" + customers[i].getTotalSales());
                found = true;
                break;
            }
        }
        if (!found) {//if not found then say Customer not found using boolean
            System.out.println("Customer not found!");
        }
    }
    
    public static void retrieveCustomersInRange(Scanner scanner) {//retrieve customers in a total sale range method
        System.out.print("Enter the minimum total sales: ");
        double minSales = scanner.nextDouble();
        System.out.print("Enter the maximum total sales: ");
        double maxSales = scanner.nextDouble();

        boolean found = false;
        for (int i = 0; i < numCustomers; i++) {//for each customer in the array getTotalSales and see if it is >= min sales && <= max sales
            if (customers[i].getTotalSales() >= minSales && customers[i].getTotalSales() <= maxSales) {//if customer is in range, print name, id, and total sales
                System.out.println("\nCustomer name: " + customers[i].getName());
                System.out.println("Customer id: " + customers[i].getId());
                System.out.println("Total sales: $" + customers[i].getTotalSales());
                found = true;
            }
        }
        if (!found) {//if not found then say Customer not found using Boolean
            System.out.println("No customers found in the specified range!");
        }
    }
    
     public void run() {//run method that executes the display menu and the uses a switch case to push the program to the correct method
        Scanner scanner = new Scanner(System.in);//make a scanner that can be pushed to all the methods
        int choice;

        do {
            choice = displayMenu(scanner);

            switch (choice) {
                    
                case 1:
                    addMultipleCustomers(scanner);
                    break;
                case 2:
                    addSingleCustomer(scanner);
                    break;
                case 3:
                    displayAllCustomers();
                    break;
                case 4:
                    retrieveCustomerData(scanner);
                    break;
                case 5:
                    retrieveCustomersInRange(scanner);
                    break;
                case 6:
                    System.out.println("\nProgram complete | Franklin Elliott | CMIS 141 | May 8th, 2023");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (choice != 6);

        scanner.close();
    }
     
}
