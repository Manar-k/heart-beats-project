/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartbeats;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



/**
 *
 * @author lokamloka
 */
public class headphonController implements Initializable {
    @FXML
    public RadioButton R1;//change the state of bluetooth headphons & drum when it sucssesfully pairing
    @FXML
    public AnchorPane headphone_color;//this is to make sure that headphone is pairing to drum sucssesfully
    @FXML
    public AnchorPane drum_color;//this is to make sure that drum is pairing to headphone sucssesfully
    
    public void state() throws IOException{ //the changese of state red for unsucssesful $ green for sucssesful pairing
        
        
        if (R1.isSelected()){
            headphone_color.setStyle("-fx-background-color:Green");
            drum_color.setStyle("-fx-background-color:Green");     
        }
        else {
            
            headphone_color.setStyle("-fx-background-color:Red");
            drum_color.setStyle("-fx-background-color:Red");
        }
    }
    
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            state();//state of the two devices
        } catch (IOException ex) {
            Logger.getLogger(headphonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
