/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartbeats;

import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author lokamloka
 */
public class loginController {
    static Doctor loggeduser;//object of doctor username $ password
    @FXML
    private TextField usertxt;//enter user name

    @FXML
    private TextField passtxt;//enter password
    
    @FXML
    private Button loginBTN;//button to login
    
    @FXML
    protected void handleLoginButtonAction(ActionEvent event) throws IOException {
        Window owner = loginBTN.getScene().getWindow();//to show the notification in diff states of login
        
        if (usertxt.getText().isEmpty()) {//if the field of username is empty
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your user name");
            return;
        }
        if (passtxt.getText().isEmpty()) {//if the field of password is empty
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
            return;
        }

        List<Doctor> allusers=null ; 
        //this helps to get the values from database to compare it with what doctor inter

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        Query query = session1.createQuery("from Doctor");
        allusers = query.list();
        session1.close();
        loggeduser = null;//**

        for (Doctor s : allusers) {//compare with database
            if (usertxt.getText().equals( s.getUsername()) && passtxt.getText().equals( s.getPassword())) {
                loggeduser = s;
                
            }

        }
        if (loggeduser != null) { //to show a sucssesfull notification
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!", "Welcome " + loggeduser.getUsername());
            
        Parent rate_page_parent=FXMLLoader.load(getClass().getResource("rate.fxml"));//to go in rate intersce
        Scene rate_page_scene=new Scene(rate_page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(rate_page_scene);
        stage1.show();
        
        } else {//wrong username or password
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Wrong username or password");
            
        }
    
}
    
 //this is for display the notification of login state   
    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {

        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
