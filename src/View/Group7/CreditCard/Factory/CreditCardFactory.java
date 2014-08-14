/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View.Group7.CreditCard.Factory;

import View.Group7.Bank.Account.CheckingAccount;
import View.Group7.Bank.Account.SavingAccount;
import View.Group7.Bank.Type.MyAccountType;
import View.Group7.CreditCard.Account.Bronze;
import View.Group7.CreditCard.Account.Gold;
import View.Group7.CreditCard.Account.Silver;
import View.Group7.CreditCard.Type.CreditAccountType;
import com.asd.group7.common.app.factory.AccountFactory;
import com.asd.group7.common.lib.account.IAccount;

/**
 *
 * @author naimi_000
 */
public class CreditCardFactory extends AccountFactory{

    public CreditCardFactory() {
    }

    @Override
    public IAccount getAccount(Enum type) {
       if (type == CreditAccountType.GOLD) {
            return new Gold();
        } else if (type == CreditAccountType.SILVER) {
            return new Silver();
        } else if (type == CreditAccountType.BROZE) {
            return new Bronze();
        }
        return null;
    }
    
    
}
