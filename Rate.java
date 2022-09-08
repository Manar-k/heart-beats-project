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
@Table(name="Rate")
public class Rate {
   

   @Id
   @Column(name="Rate")
   String Rate;
   
   public Rate(){
       
    }

    public Rate(String Rate) {//getter and setter of heat beats rate

        this.Rate = Rate;

    }
    
    public String getRate() {
        return Rate;
    }

    public void setRate(String Rate) {
        this.Rate = Rate;
    }
}
