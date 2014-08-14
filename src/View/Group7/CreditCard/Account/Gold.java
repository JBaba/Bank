/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Group7.CreditCard.Account;

import com.asd.group7.common.lib.account.AAccount;

/**
 *
 * @author dhruba
 */
public class Gold extends CreditCardAccount {

    public double mi=0.06,mp=0.10;   
    
    @Override
    public String getType() {
        return "Gold";
    }

    @Override
    public double getInterestAmount() {
        return 3;
    }

    public double getMi() {
        return mi;
    }

    public void setMi(double mi) {
        this.mi = mi;
    }

    public double getMp() {
        return mp;
    }

    public void setMp(double mp) {
        this.mp = mp;
    }

    
}
