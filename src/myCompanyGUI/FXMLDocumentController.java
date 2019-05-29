/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myCompanyGUI;

import java.io.BufferedReader;
import java.io.StringReader;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javax.lang.model.element.Element;
import myCompany.BusinessCustomer;
import myCompany.ClientBase;
import myCompany.Customer;
import myCompany.PrivateCustomer;

/**
 *
 * @author D00186562
 */
public class FXMLDocumentController implements Initializable {

    Map<String, String> cust = new TreeMap();
    ClientBase customers = new ClientBase();
    
    @FXML
    private Text txtOutput;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtCreditLimit;
    @FXML
    private TextField txtBalance;
    @FXML
    private Button addCustBtn;
    @FXML
    private Button deleteCustBtn;
    @FXML
    private Button seeOrdersBtn;
    private Label label;
    @FXML
    private ChoiceBox choicebox;
    @FXML
    private RadioButton customerP;
    @FXML
    private ToggleGroup customerType;
    @FXML
    private RadioButton customerB;
    @FXML
    private Pane businessDetails;
    @FXML
    private Pane privateDetails;
    @FXML
    private TextField txtLoyalityPoints;
    @FXML
    private Label balanceOutput;
    @FXML
    private Label randomEmailOutput;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populate();
    }

    @FXML
    private void handleButtonAddCust(ActionEvent event) {
        
        String name, address, email, customerType;
        int loyaltyPoints;
        double creditLimit, balance;
        name = txtName.getText();
        address = txtAddress.getText();
        email = txtEmail.getText();
        if(privateDetails.isVisible()){
            customerType = "private";
            loyaltyPoints = Integer.parseInt(txtLoyalityPoints.getText());
            PrivateCustomer customer = new PrivateCustomer(customerType,name,address,email,loyaltyPoints);
            customers.addCust(email, customer);
        }else{
            customerType = "business";
            creditLimit = Double.parseDouble(txtCreditLimit.getText());
            balance = Double.parseDouble(txtCreditLimit.getText());
            BusinessCustomer customer = new BusinessCustomer(customerType,name,address,email,balance,creditLimit);
            customers.addCust(email, customer);
        }
        System.out.println(customers.toString());
     
    }


    @FXML
    private void handleButtonDisplay(ActionEvent event) {
        for (Map.Entry<String, String> entry : cust.entrySet()) {
            System.out.println(entry.getKey() + ":  " + entry.getValue());
        }
    }

    @FXML
    private void handleButtonActionSeeOrders(ActionEvent event) {
        
    }

    @FXML
    private void handleButtonActionDeleteCust(ActionEvent event) {
        String email;
        email = txtEmail.getText();
        customers.deleteCust(email);
        System.out.println(customers.toString());
       

    }
    @FXML
    private void handleButtonTotalBalance(ActionEvent event){
        double total;
        total = customers.getTotalBalance();
        balanceOutput.setText(Double.toString(total));
    }
    @FXML
    private void handleButtonRandomEmail(ActionEvent event){
        String email;
        email = customers.getPCustEmail();
        randomEmailOutput.setText(email);
    }
    @FXML
    private void showPrivateDetails(ActionEvent event) {
    businessDetails.setVisible(false);
        privateDetails.setVisible(true);
    }

    @FXML
    private void showBusinessDetails(ActionEvent event) {
         businessDetails.setVisible(true);
        privateDetails.setVisible(false);
    }
//   

    private void handleButtonAction(ActionEvent event) {

    }

    private void handleButtonAction2(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    private void populate() {
        cust.put("david smith", "12 avenue road dundalk");
        cust.put("sean jones", "15 dublin road dundalk");
    }

}
