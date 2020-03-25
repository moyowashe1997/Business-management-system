/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oryx;

import java.util.ArrayList;
import java.util.Scanner;

/*** I hereby acknowledge that the work handed in is my own original work. If I
* have quoted from any other source this information has been correctly referenced.
* I also declare that I have read the Namibia University of Science and Technology 
* Policies on Academic Honesty and Integrity as indicated in my course outline and 
* the NUST general information and regulations - Yearbook 2018
 * @author Andreas Amukwa 218047967
 */

public class Admin{
    
    public Scanner scanner = null;
     
    public Admin(){ //constructor. same name as class for initialization
        scanner = new Scanner(System.in);
    }
    
    //function for restock option in admin menu
    public void restock(ArrayList<String> items_name, ArrayList<Integer> items_quantity){
        System.out.println("");
        System.out.println("**************************************");
        System.out.println("+++++++++++ RESTOCK ITEM +++++++++++++");
        System.out.println("**************************************");
        System.out.println("Enter item to restock:");
        int pos = items_name.indexOf(scanner.next());
        int current = items_quantity.get(pos);
        
        System.out.println("Current quantity is: " + current);
        
        System.out.println("Enter restock quantity: ");
        int restock = scanner.nextInt();
        int new_amount = current + restock;
        items_quantity.set(pos, new_amount);
        
        System.out.println("--------------------------------------");
        System.out.println("RESTOCKED!! New quantity is: " + items_quantity.get(pos));
        System.out.println("**************************************");
        System.out.println("Press enter to continue");
        System.out.println("");
    }
    
    //function to add new item in admin menu
    public void add_new_items(ArrayList<String> items_name, ArrayList<Integer> items_quantity, ArrayList<Double> items_price){
        System.out.println("");
        //System.out.println("ADD NEW ITEM");
        System.out.println("**************************************");
        System.out.println("+++++++++++ ADD NEW CAR +++++++++++++");
        System.out.println("**************************************");
        
        System.out.println("Please enter item name: ");
        String name = this.scanner.next();
        items_name.add(name);
        
        System.out.println("Please enter item price: ");
        double price = this.scanner.nextDouble();
        items_price.add(price);
        
        System.out.println("Please enter item quantity: ");
        int quantity = this.scanner.nextInt();
        items_quantity.add(quantity);
        
        System.out.println("--------------------------------------");
        System.out.println("Name\tQuantity\tPrice");
        System.out.println(name + "\t" + quantity +"\t\t"+" N$ " + price);
        System.out.println("**************************************");
        System.out.println("");
    }
    
    //function to change price of items in admin menu
    public void change_prices(ArrayList<String> items_name, ArrayList<Double> items_price){
        System.out.println("");
        System.out.println("**************************************");
        System.out.println("+++++++++ CHANGE ITEM PRICE ++++++++++");
        System.out.println("**************************************");
        System.out.println("Enter item to change price:");
        int pos = items_name.indexOf(scanner.next());
        double current = items_price.get(pos);
        
        System.out.println("Current price is: " + current);
        System.out.print("Enter new price: ");
        double new_price = scanner.nextDouble();
        items_price.set(pos, new_price);
        
        System.out.println("--------------------------------------");        
        System.out.println("PRICE CHANGED!! new price: " + new_price);
        System.out.println("**************************************");
        System.out.println("");
    }
    
    //function to add a new teller
    public void add_teller(ArrayList<String> teller_name, ArrayList<String> teller_password){
        System.out.println("**************************************");
        System.out.println("++++++++++++ Add Teller ++++++++++++++");
        System.out.println("**************************************");
        System.out.print("Enter teller name: ");
        String name = this.scanner.next();
        teller_name.add(name);
        
        System.out.print("Enter password: ");
        String pass = this.scanner.next();
        teller_password.add(pass); 
        
        System.out.println("--------------------------------------");
        System.out.println("Teller added: " + name);
        System.out.println("**************************************");
        System.out.println("");
    }
    
    //function to display items in stock
    public void print_summary(ArrayList<String> items_name, ArrayList<Integer> items_quantity, ArrayList<Double> items_price){
        System.out.println("**************************************");
        System.out.println("++++++++++ CARS IN STOCK ++++++++++++");
        System.out.println("**************************************");
        System.out.println("Name\tQuantity\tPrice");
        for(int b = 0; b < items_name.size(); b++){
            System.out.println(items_name.get(b) +"\t"+ items_quantity.get(b) + "\t\t"+"N$ " + items_price.get(b));
        }
        System.out.println("**************************************");
        System.out.println("");
    }
    
    //function to restock items
    public void restock_summary(ArrayList<String> items_name, ArrayList<Integer> items_quantity, ArrayList<Double> items_price){ 
        int tempcount = 0;
        System.out.println("*********************************");
        System.out.println("####   CARS NEED RESTOCK   #####");
        System.out.println("*********************************");
        System.out.println("Name\tQuantity\tPrice");
        for(int a: items_quantity){
            if(a < 25){
              System.out.println(items_name.get(tempcount) + "\t" +a +"\t\t"+ "N$" + items_price.get(tempcount));
            }
            tempcount++;
        }
        System.out.println("*********************************");
        System.out.println("");
    }
}
