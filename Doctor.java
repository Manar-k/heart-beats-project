/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartbeats;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author lokamloka
 */
@Entity
@Table(name="Doctor")
public class Doctor {//this class for login to make sure that only doctor can acsses to it
   @Id
   @Column(name="username")
   String username;
   @Column(name="password")
   String password;
   
   public Doctor(){
       
    }

    public Doctor(String username, String password) {

        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {//getter and setter of username and password 
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
