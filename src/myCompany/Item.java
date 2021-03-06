/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myCompany;

public class Item implements Comparable <Item>{

    //Each item has these stored.
    private String name;
    private int id;
    private int sQuantity;
    private double uPrice;
    private static int idCounter = 1;

    //No argument constructor
    public Item() {
        name = "apple";
        sQuantity = 10;
        uPrice = 1.50;
        id = idCounter;
        idCounter = idCounter + 1;
    }
    //Parameterized constructor for relevant instance variables

    public Item(String name, double uPrice, int sQuantity) {
        this.name = name;
        this.uPrice = uPrice;
        this.sQuantity = sQuantity;
        id = idCounter;
        idCounter++;
    }
    
    //new paramenter added for the file scanner
    public Item(String name, int id, int sQuantity, double uPrice) {
        this.name = name;
        this.uPrice = uPrice;
        this.sQuantity = sQuantity;
        this.id = id;
    }

    //Getter methods
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getsQuantity() {
        return sQuantity;
    }

    public double getuPrice() {
        return uPrice;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    //Setter methods
    public void setName(String name) {
        this.name = name;
    }

    //prevent negative stock quantity
    public boolean setsQuantity(int sQuantity) {
        if (sQuantity >= 0) {
            this.sQuantity = sQuantity;
            return true;
        }
        return false;
    }

    public boolean setuPrice(double uPrice) {
        boolean done = true;
        if (uPrice < 0) {
            done = false;
        } else {
            this.uPrice = uPrice;
        }
        return done;

    }

    //change the quantity of an item 
    public boolean decreaseQuantity(int quantity) {
        int total = this.sQuantity - quantity;

        if (total >= 0) {
            this.sQuantity -= quantity;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", id=" + id + ", sQuantity=" + sQuantity + ", uPrice=" + uPrice + '}';
    }
    
    @Override
    public int compareTo(Item t) {
        if (t != null) {
            if (id < t.getId()) {
                return -1;
            }
            if (id > t.getId()) {
                return 1;
            }
            return 0;
        }
        return 0;
    }
    



}
