/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View.Group7.CreditCard.Account;

import com.asd.group7.common.lib.account.AAccount;

/**
 *
 * @author naimi_000
 */
public class CreditCardAccount extends AAccount{

    String expiryDate;
    double lastMonthBalance;

    public CreditCardAccount() {
    }
    
    @Override
    public double getInterestAmount() {
        return 10;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getLastMonthBalance() {
        return lastMonthBalance;
    }

    public void setLastMonthBalance(double lastMonthBalance) {
        this.lastMonthBalance = lastMonthBalance;
    }
    
    
}
