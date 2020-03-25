/*** I hereby acknowledge that the work handed in is my own original work. If I
* have quoted from any other source this information has been correctly referenced.
* I also declare that I have read the Namibia University of Science and Technology 
* Policies on Academic Honesty and Integrity as indicated in my course outline and 
* the NUST general information and regulations - Yearbook 2018
 * @author Andreas Amukwa 218047967
 */
package Oryx;

import java.util.ArrayList;
import java.util.Scanner;


public class Teller {
    
    //initialisation of array
    public Scanner scan;
    ArrayList<String> sale_name;
    ArrayList<Integer> sale_quantity;
    ArrayList<Double> sale_price; 
    String username = null;
    
    public Teller(String username){
        scan = new Scanner(System.in);
        sale_name = new ArrayList<>();
        sale_quantity = new ArrayList<>();
        sale_price = new ArrayList<>();
        this.username = username;
    }
    
    //function to sell items
    public void sell_items(ArrayList<String> items_name, ArrayList<Integer> items_quantity, ArrayList<Double> items_price){
        System.out.println("**************************************");
        System.out.println("++++++++++++ SELL ITEM +++++++++++++++");
        System.out.println("**************************************");
        boolean run = true;
        while(run){
        
            System.out.println("Enter item name: ");
            String name = this.scan.next();
            int index = items_name.indexOf(name);
            int current = items_quantity.get(index);
            
            System.out.println("Available - " + current);
            
            System.out.print("Amount bought: ");
            int qty = this.scan.nextInt();
            items_quantity.set(index, current-qty);
            double price = items_price.get(index);

            // store sold items
            this.sale_name.add(name);
            this.sale_price.add(price);
            this.sale_quantity.add(qty);

            //gives options to add more items or print receipt
            System.out.println("");
            System.out.println("Press any number to add more items");
            System.out.println("2. Print receipt. ");
            
            //if user option is 2 then the following receipt will be printed
            int option = this.scan.nextInt();
            switch(option){
                case 2:
                    double vat = 0;
                    double all = 0;
                    for(int i = 0; i < sale_price.size(); i++){
                        Math.round(all += (sale_price.get(i) * sale_quantity.get(i))); 
                    }
                    vat = all * 0.15; //calculates the 15% VAT
                    
                    System.out.println("");
                    //Receipt
                    System.out.print("Amount paid: ");
                    double paid = this.scan.nextDouble();
                    System.out.println("**************************************");
                    System.out.println("$$$$* Welcome to Oryx Autos *$$$$$$");
                    System.out.println("**************************************");
                    System.out.println("*****   P.O.Box 236 Katutura    ******");
                    System.out.println("*****    a.amukwa@gmail.com     ******");
                    System.out.println("**************************************");

                    System.out.println("Name"+"\t\t"+"QTY"+"\t"+"Price"+"\t"+"Total");
                    for(int b = 0; b < sale_name.size(); b++){
                        System.out.println(sale_name.get(b) +"\t\t"+ sale_quantity.get(b) + "\t" + sale_price.get(b)+"\t"+(sale_price.get(b) * sale_quantity.get(b)));
                    } 
                    System.out.println("______________________________________");
                    System.out.println("");
                    
                    System.out.println("\t\t"+"VAT@15%"+"\t\t"+String.format("%.2f", vat));

                    System.out.println("Total:\t\t\t\t" + String.format("%.2f", all+vat));
                    System.out.println("Tendered:\t\t\t" + String.format("%.2f", paid));
                    System.out.println("Change:\t\t\t\t" + String.format("%.2f", paid - (all+vat)));
                    System.out.println("***************************************");
                    System.out.println("    Date: " + java.time.LocalDate.now());
                    System.out.println("      Cashier: " + this.username);
                    System.out.println("***************************************");
                    System.out.println("");
                    System.out.println("\tThank You For Your Support");
                    System.out.println("    \t    Please come back");
                    System.out.println("");
                    System.out.println("***************************************");

                    //shows how change will be disbursed to customer
                    String st = "Your change is disbursed as follows: ";
                    int hundered = 0;
                    double amount = (paid - (all+vat));
                    if( amount >= 200){
                        hundered = (int) amount/200;
                        amount = amount - (200*hundered);
                        st += "N$ 200's x "+hundered;
                    }

                    if (amount >= 100){
                        hundered = (int) amount/100;
                        amount = amount - (100*hundered);
                        st += ", N$ 100's x "+ hundered;
                    }

                    if (amount >= 50){
                        hundered = (int) amount/50;
                        amount = amount - (50*hundered);
                        st += ", N$ 50's x "+ hundered;
                    }

                    if (amount >= 20){
                        hundered = (int) amount/20;
                        amount = amount - (20*hundered);
                        st += ", N$ 20's x "+ hundered;
                    }

                    if (amount >= 10){
                        hundered = (int) amount/10;
                        amount = amount - (10*hundered);
                        st += ", N$ 10's x "+ hundered;
                    }

                    if (amount >= 5){
                        hundered = (int) amount/5;
                        amount = amount - (5*hundered);
                        st += ", N$ 5's x "+ hundered;
                    }

                    if (amount >= 1){
                        hundered = (int) amount/1;
                        amount = amount - (1*hundered);
                        st += ", N$ 1's x "+ hundered;
                    }

                    if (amount >= 0.5){
                       double cent = amount * 2;
                       amount = amount % 0.5;
                       st += ", N$ 0.5's x "+ (int) cent;
                    }

                    if (amount >= 0.1){
                       double cent = amount * 10;
                       amount = amount % 0.1;
                       st += ", N$ 0.1's x "+ (int) cent;
                    }
                    System.out.println(st);
                    System.out.println("");
                    run= false; 
                    break;
                    
            }
        }        
    }
    
    //prints items in stock
    public void print_summary(ArrayList<String> items_name, ArrayList<Integer> items_quantity, ArrayList<Double> items_price){
        System.out.println("**************************************");
        System.out.println("+++++++++  CARS IN STOCK  +++++++++++");
        System.out.println("**************************************");
        System.out.println("Name\tQuantity\tPrice");
        for(int b = 0; b < items_name.size(); b++){
            System.out.println(items_name.get(b) +"\t"+ items_quantity.get(b) + "\t\t"+"N$ " + items_price.get(b));
        }
        System.out.println("**************************************");
        System.out.println("");
    }
    
    // print items sold. 
    public void print_sales(){
        System.out.println("***************************************");
        System.out.println("##########  CARS SOLD  ###############");
        System.out.println("**************************************#");
        System.out.println("Name\t\tQuantity\tPrice");
        for(int i = 0; i < this.sale_name.size(); i++){
            System.out.println(this.sale_name.get(i) +"\t\t"+ this.sale_quantity.get(i) + "\t\tN$ " + this.sale_price.get(i));
            System.out.println("");
        }
        System.out.println("***************************************");
        System.out.println("");
    }
}
