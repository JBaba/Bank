/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Group7.Bank.Account;

import com.asd.group7.common.lib.account.AAccount;
import com.asd.group7.common.lib.party.IParty;

/**
 *
 * @author naimi_000
 */
public class CheckingAccount extends AAccount {

    public CheckingAccount() {
        super.setType("Ch");
    }

    
    
    @Override
    public String getType() {
        return "Ch";
    }

    @Override
    public double getInterestAmount() {
        return 3;
    }

    @Override
    public void setParty(IParty iParty) {
        super.setParty(iParty);
    }

    @Override
    public IParty getParty() {
        return super.getParty();
    }
    
//    public double getBalance() {
//        return super.getBalance();
//    }
}
