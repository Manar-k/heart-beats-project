/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartbeats;

import static heartbeats.loginController.showAlert;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lokamloka
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    public TextField readrate; // the heart beats drum device reads the heartbeats of patient
    
    @FXML
    public Label enterrate; // show the heartbeats rate to doctor from app
    
    
    @FXML
    private void ratepage(ActionEvent event)throws IOException{//changes interface to rate interface
        Parent rate_page_parent=FXMLLoader.load(getClass().getResource("rate.fxml"));
        Scene rate_page_scene=new Scene(rate_page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(rate_page_scene);
        stage1.show();
    }
     @FXML
    private void loginpage(ActionEvent event)throws IOException{//changes interface to login interface
        Parent login_page_parent=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene login_page_scene=new Scene(login_page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(login_page_scene);
        stage1.show();
    }
     @FXML
    private void headphonsepage(ActionEvent event)throws IOException{//changes interface to headsphone interface
        Parent headphons_page_parent=FXMLLoader.load(getClass().getResource("headphone.fxml"));
        Scene headphons_page_scene=new Scene(headphons_page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(headphons_page_scene);
        stage1.show();
    }
    
    Rate r=new Rate();//object of rate to store it in database
    @FXML
    public void getHeartBeatsRate(ActionEvent event) throws IOException{//get the rate
        
        r.setRate(readrate.getText());
        enterrate.setText(r.getRate());
        
        //insert new rate to database
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sId3 = (String) session.save(r);
        tx.commit();
        session.close();
        System.out.println("inserted Rate: "+r.getRate());
                

    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
