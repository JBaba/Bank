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
public class Bronze extends AAccount{

    @Override
    public String getType() {
        return "Bronze";
    }

    @Override
    public double getInterestAmount() {
        return 3;
    }
    
}
