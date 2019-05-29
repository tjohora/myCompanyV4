package myCompany;

import java.util.ArrayList;

/**
 *
 * @author D00186562
 */
public class CustomerData {
    
    private ArrayList<Customer> allCustomers;
    
    public CustomerData(){
        allCustomers= new ArrayList<>();
    }
    
    public void addCustomer(Customer c){
        allCustomers.add(c);
    }

    @Override
    public String toString() {
        return "CustomerData{" + "allCustomers=" + allCustomers + '}';
    }
}
