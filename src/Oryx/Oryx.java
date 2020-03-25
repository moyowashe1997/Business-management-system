/*** I hereby acknowledge that the work handed in is my own original work. If I
* have quoted from any other source this information has been correctly referenced.
* I also declare that I have read the Namibia University of Science and Technology 
* Policies on Academic Honesty and Integrity as indicated in my course outline and 
* the NUST general information and regulations - Yearbook 2018
 * @author Andreas Amukwa 218047967
 */
package Oryx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Oryx {
    
    public static void main(String[] args) throws IOException {
        Admin admin = null ; //admin object.stores admin instance
        Teller teller = null;
        SystemAdmin manager = null;
       // SystemAdmin admin = null ; //admin object.stores systemad instance
        
        //store item details
        ArrayList<String> items_name; 
        ArrayList<Integer> items_quantity;
        ArrayList<Double> items_price;
        Scanner sc = new Scanner(System.in);
        
        // Login details
        //store admin details
        ArrayList<String> admin_login = new ArrayList<>();
        ArrayList<String> admin_password = new ArrayList<>();
        admin_login.add("exca");
        admin_password.add("1234");        
        admin_login.add("marsh");
        admin_password.add("1234");
        
        //system admin
        ArrayList<String> sysadmin_login = new ArrayList<>();
        ArrayList<String> sysadmin_password = new ArrayList<>();
        sysadmin_login.add("risi");
        sysadmin_password.add("1234");
               
        //stores teller details
        ArrayList<String> teller_name = new ArrayList<>();
        ArrayList<String> teller_password = new ArrayList<>();
        
        teller_name.add("frans");
        teller_password.add("321");
        
        teller_name.add("chicha");
        teller_password.add("0000");
        
        //initialized array
        items_name = new ArrayList<>();
        items_quantity = new ArrayList<>();
        items_price = new ArrayList<>();
        //bmw item with quantity and price
        items_name.add("BMW");
        items_quantity.add(21);
        items_price.add(12.50);      
        //toyota item with quantity and price
        items_name.add("Toyota");
        items_quantity.add(65);
        items_price.add(65.00);       
        //merc item with quantity and price
        items_name.add("Mercedec");
        items_quantity.add(6);
        items_price.add(24.20);
        
        boolean run; //store loop. used to keep while loop running
        
        String name = null; // stores name of logged in user 
        
        while(true){
        int option = mainmenu(); // show main menu and store user choice in option variable.
        run = true;
        switch(option){ 
            case 1:
                while(run){
                    System.out.println("**************************************");
                    System.out.println("###### Enter Admin Credentials  ######");
                    System.out.println("**************************************");
                    //System.out.println("");
                    System.out.print("Username: ");
                    name = sc.next();
                    String pass = admin_password.get(admin_login.indexOf(name));
                    System.out.print("Password: ");
                    
                    if (pass.equals(sc.next())){
                        System.out.println("**************************************");
                        System.out.println("");
                        System.out.println("\t"+"   "+"Admin Verified!!");
                        System.out.println("");
                        System.out.println("**************************************");                  
                        run = false;
                        System.out.println("");
                    } else{
                        System.out.println("");
                        System.out.println("Wrong details please re-enter.");
                    }
                }
                adminmenu(admin, items_name, items_quantity, items_price, teller_name, teller_password); //if user enters 1 they login as admin
                break;
            case 2: 
                while(run){
                    System.out.println("**************************************");
                    System.out.println("########### Please login  ############");
                    System.out.println("**************************************");
                    System.out.print("Username: ");
                    name = sc.next();
                    String pass = teller_password.get(teller_name.indexOf(name));
                    System.out.print("Password: ");
                    
                    if (pass.equals(sc.next())){
                        System.out.println("**************************************");
                        System.out.println("");
                        System.out.println("\t"+"   "+"User Verified!!");
                        System.out.println("");
                        System.out.println("**************************************");                  
                        run = false;
                        System.out.println("");
                    } else{
                        System.out.println("");
                        System.out.println("Wrong details please re-enter.");
                    }
                }
                tellermenu(name, teller, items_name, items_quantity, items_price);
                case 3:
                while(run){
                    System.out.println("**************************************");
                    System.out.println(" ## Enter System Admin Credentials  ##");
                    System.out.println("**************************************");
                    //System.out.println("");
                    System.out.print("Username: ");
                    name = sc.next();
                    String pass = sysadmin_password.get(sysadmin_login.indexOf(name));
                    System.out.print("Password: ");
                    
                    if (pass.equals(sc.next())){
                        System.out.println("**************************************");
                        System.out.println("");
                        System.out.println("\t"+"   "+"Manager Verified!!");
                        System.out.println("");
                        System.out.println("**************************************");                  
                        run = false;
                        System.out.println("");
                    } else{
                        System.out.println("");
                        System.out.println("Wrong details please re-enter.");
                    }
                }
               managermenu(manager, sysadmin_login, sysadmin_password);
                
                 //if user enters 2 they login as tellers
                break;
            case 4: 

                System.out.println("You have exit");
                System.exit(4);
                break;
        }
      }
    }
    
    // Landing page
    public static int mainmenu(){
        String abcd = "\033[1;35m";
        System.out.println("*************************************");
        System.out.println(abcd+"$$$$* Welcome to Oryx Autos *$$$$$"+abcd);
        System.out.println("*************************************");
        System.out.println(abcd+"*****   P.O.Box 236 Katutura    *****"+abcd);
        System.out.println(abcd+"*****    a.amukwa@gmail.com     *****"+abcd);
        System.out.println("*************************************");
        System.out.println("");
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as Teller");
        System.out.println("3. Login as System Admin");
        System.out.println("4. Quit");
        System.out.println("*************************************");
        Scanner scan = new Scanner(System.in);
        
        int option = scan.nextInt();
        return option; //returns user choice
    }
    
    // All admin related activities happen in here.
    public static void adminmenu( Admin admin, ArrayList<String> items_name, ArrayList<Integer> items_quantity, ArrayList<Double> items_price, ArrayList<String> teller_name, ArrayList<String> teller_password) throws IOException{
        
        admin = new Admin();
        boolean run = true;
        String c = "\033[1;30m";
        String abc = "\033[1;32m";
        while(run){
            
        System.out.println(c+"Admin Menu"+c);
        System.out.println("1. Restock");
        System.out.println("2. Add New Car");
        System.out.println("3. Change Prices");
        System.out.println("4. Add New Teller");
        System.out.println("5. Cars In Stock");
        System.out.println("6. Cars Need Restock");
        System.out.println("7. Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        
        switch (choice){
            case 1: admin.restock(items_name, items_quantity); //to restock items
                break;
            case 2: admin.add_new_items(items_name, items_quantity, items_price); //to add new items
                break;
            case 3: admin.change_prices(items_name, items_price); //to change item price
                break;
            case 4: admin.add_teller(teller_name, teller_password); //to add a new teller
                break;
            case 5: admin.print_summary(items_name, items_quantity, items_price); //display details of items in stock
                break;
            case 6: admin.restock_summary(items_name, items_quantity, items_price); //display details of restocked item
                break;
            case 7: run=false; //exit
                break;
        }
      }
    }
    
     // All teller related activities happen here.
    public static void tellermenu(String name, Teller teller, ArrayList<String> items_name, ArrayList<Integer> items_quantity, ArrayList<Double> items_price){
        
        teller = new Teller(name);
        boolean run = true;
        String d = "\033[1;30m";
        
        while(run){
        System.out.println(d+"Teller Menu"+d);
        System.out.println("1. Sell Item");
        System.out.println("2. Items In Stock");
        System.out.println("3. Items Sold");
        System.out.println("4. Exit");
        
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
  
        switch (choice){
            case 1: teller.sell_items(items_name, items_quantity, items_price); //teller sold item
                break;
            case 2: teller.print_summary(items_name, items_quantity, items_price); //shows items in stock
                break;
            case 3: teller.print_sales(); //displays sold items
                break;
            case 4: run=false; //exit teller menu
                break;
        }
      }
    }
    
    //All manager related activities
    public static void managermenu(SystemAdmin manager, ArrayList<String> admin_login, ArrayList<String> admin_password){
        manager = new SystemAdmin();
        boolean run = true;
        String c = "\033[1;30m";
        String abc = "\033[1;32m";
        
        while(run){
        System.out.println(c+"Manager Menu"+c);
        System.out.println("1. Add new Manager");
        System.out.println("2. Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        
        switch (choice){
            case 1: manager.addManager(admin_login, admin_password); //to restock items
                break;
            case 2: run=false; //exit
                break;
        }
      }

}
}
