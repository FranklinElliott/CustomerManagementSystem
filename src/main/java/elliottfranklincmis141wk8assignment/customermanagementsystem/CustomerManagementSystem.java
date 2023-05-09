
package elliottfranklincmis141wk8assignment.customermanagementsystem;

/**Week 8 Assignment 7
 * Author: Franklin Elliott
 * Date: 2023-05-08
 * Purpose: Java program to manage customers and their order data
 * The program allows users to add, retrieve and display customer 
 * information based on customer ID and/or total sales amount.
 * 
 * CustomerManagementSystem is the Main file to run the program from
 */

public class CustomerManagementSystem {//CustomerManagementSystem class
    
    public static void main(String[] args) {//Main method for the program
        CustomerManager manager = new CustomerManager();//Create a CustomerManager called manager
        manager.run();//Run manager
    }
}
