/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oryx;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Andreas Amukwa
 */
public class SystemAdmin{
     public Scanner scanner = null;
    
     public SystemAdmin(){
         scanner = new Scanner(System.in);
     }
     
    public void addManager(ArrayList<String> admin_login, ArrayList<String> admin_password){
        System.out.println("");
        System.out.println("**************************************");
        System.out.println("+++++++++++ Add new Manager +++++++++++++");
        System.out.println("**************************************");
        System.out.print("Enter Manager name: ");
        String name = this.scanner.next();
        admin_login.add(name);
                
        System.out.print("Enter password: ");
        String pass = this.scanner.next();
        admin_password.add(pass); 
        
        System.out.println("--------------------------------------");
        System.out.println("Manager added: " + name);
        System.out.println("**************************************");
        System.out.println("");
    }
    public void viewTeller(){
        
        
    }
    
}
