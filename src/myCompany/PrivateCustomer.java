package myCompany;

/**
 *
 * @author D00186562
 */
public class PrivateCustomer extends Customer{
    private double loyaltyPoints;

    public PrivateCustomer(String type, String name, String address, String email, int loyaltyPoints) {
        super(type, name, address, email);
        this.loyaltyPoints = loyaltyPoints;
    }

    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(double loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
    
    public void updateLoyaltyPoints(double orderValue){
        this.loyaltyPoints =+ Math.floor(orderValue/100);
    }

    @Override
    public String toString() {
        return "PrivateCustomer{" + "loyaltyPoints=" + loyaltyPoints + '}';
    }  
}
