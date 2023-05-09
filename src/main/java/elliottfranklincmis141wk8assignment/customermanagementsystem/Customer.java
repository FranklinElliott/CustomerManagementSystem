
package elliottfranklincmis141wk8assignment.customermanagementsystem;

/**Week 8 Assignment 7
 * Author: Franklin Elliott
 * Date: 2023-05-08
 * Purpose: Java program to manage customers and their order data
 * The program allows users to add, retrieve and display customer 
 * information based on customer ID and/or total sales amount.
 *
 * Customer file to create new customers and print them
 */
public class Customer {//class for customer
    //variables for name, id, and total sales
    private String name;
    private int id;
    private double totalSales;
    
    // constructor to get and assign all attribute values name, id, and total sales
    public Customer(String name, int id, double totalSales) {
        this.name = name;
        this.id = id;
        this.totalSales = totalSales;
    }

    public String getName() {//getName method to return the name to other classes
        return name;
    }

    public void setName(String name) {//setName method to allow other classes to make a name
        this.name = name;
    }

    public int getId() {//getId method to return the id to other classes
        return id;
    }

    public void setId(int id) {//setId method to allow other classes to make an id
        this.id = id;
    }

    public double getTotalSales() {//getTotalSales method to return total sales to other classes
        return totalSales;
    }

    public void setTotalSales(double totalSales) {//setTotalSales method to allow other classes to input a new total sales number
        this.totalSales = totalSales;
    }
    
    @Override
    public String toString() {//toString method that returns name, id, and total sales
        return name.toUpperCase() + "\t" + id + "\t" + totalSales;
    }
}
    

