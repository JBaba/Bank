/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View.Group7.Bank.Account;

import com.asd.group7.common.lib.account.AAccount;

/**
 *
 * @author naimi_000
 */
public class SavingAccount extends AAccount{

    @Override
    public String getType() {
        return "S";
    }

    @Override
    public double getInterestAmount() {
        return 5;
    }
    
}
