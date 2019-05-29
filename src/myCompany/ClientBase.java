/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myCompany;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author TJ Home-PC
 */
public class ClientBase {
    
    Map<String, Customer> clients;
    
    public ClientBase() {
        clients = new HashMap<>();
    }

    public boolean createBadDepts() throws FileNotFoundException, IOException {
        boolean result = false;
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("badDepts.txt")));
        for(Map.Entry<String,Customer> entry : clients.entrySet()){            
            if(entry.getValue() instanceof BusinessCustomer){
                BusinessCustomer bc = (BusinessCustomer)entry.getValue();                
                if(bc.getBalance()>bc.getCreditLimit()){
                    output.print(entry.getValue().toString());
                    result = true;
                }
            }
        }
        output.close();
        return result;
    }

    public void deleteCust(String email) {
        if(clients.containsKey(email)){
            clients.remove(email);
            
        }
    }

    public String getPCustEmail() {
        ArrayList<String> matches = new ArrayList<>();
        Random rand = new Random();
        for(Map.Entry<String,Customer> entry : clients.entrySet()){            
            if(entry.getValue() instanceof PrivateCustomer){
                matches.add(entry.getValue().getEmail());
                System.out.println(entry.getValue().getEmail());
            }
        }
        
        return matches.get(rand.nextInt(matches.size()));
    }

    public double getTotalBalance() {
        double total = 0;
        for(Map.Entry<String,Customer> entry : clients.entrySet()){
            if(entry.getValue() instanceof BusinessCustomer){
                BusinessCustomer bc = (BusinessCustomer)entry.getValue();
                total += bc.getBalance();             
            }
        }
        return total;
    }
    public void addCust(String email,Customer c){
        clients.put(email, c);
    }

    @Override
    public String toString() {
        return "ClientBase{" + "clients=" + clients + '}';
    }
    
}
