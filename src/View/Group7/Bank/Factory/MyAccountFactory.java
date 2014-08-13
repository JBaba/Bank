/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Group7.Bank.Factory;

import View.Group7.Bank.Account.CheckingAccount;
import View.Group7.Bank.Account.SavingAccount;
import View.Group7.Bank.Type.MyAccountType;
import com.asd.group7.common.app.factory.AccountFactory;
import com.asd.group7.common.lib.account.IAccount;

/**
 *
 * @author naimi_000
 */
public class MyAccountFactory extends AccountFactory {

    public MyAccountFactory() {
    }

    @Override
    public IAccount getAccount(Enum type) {
        if (type == MyAccountType.CHECKING) {
            return new CheckingAccount();
        } else if (type == MyAccountType.SAVING) {
            return new SavingAccount();
        }
        return null;
    }

}
