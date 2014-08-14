/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Group7.CreditCard.Controller;

import View.Group7.Bank.Dailog.PersonDialog;
import View.Group7.Bank.Type.MyAccountType;
import View.Group7.CreditCard.Account.CreditCardAccount;
import View.Group7.CreditCard.Dialog.CreditCardDialog;
import View.Group7.CreditCard.Type.CreditAccountType;
import com.asd.group7.common.app.party.Person;
import com.asd.group7.common.app.type.PartyType;
import com.asd.group7.common.app.type.Types;
import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.controller.AccountController;
import com.asd.group7.common.lib.account.AAccount;
import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.factory.FactoryProducer;
import com.asd.group7.common.lib.party.IParty;
import com.asd.group7.common.singleton.ClassicSingleton;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 *
 * @author naimi
 */
public class AddCreditCardController extends AccountController {

    @Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm = ClassicSingleton.getInstanceAccountFrm();
        CreditCardDialog pac = new CreditCardDialog(accountFrm);
        pac.setBounds(450, 20, 300, 330);
        pac.show();
    }

    public void createAccount(Enum accountType, String name, String ct, String st, String str, String zip, String acnr, String expdate, String em) {
        //IAccount account=new MyAccountFactory().getAccount(accountType);
        IAccount account = FactoryProducer.getFactory(CreditAccountType.MYAC).getAccount(accountType);
        CreditCardAccount aAccount = (CreditCardAccount) account;
        aAccount.setAcctNumber(acnr);
        try {
            aAccount.setExpiryDate(expdate);
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException in setDateOfBirth");
            aAccount.setExpiryDate("08/08/2014");
        }
        account = aAccount;

        IParty party = FactoryProducer.getFactory(Types.PARTY).getParty(PartyType.PERSONAL);
        Person c = (Person) party;
        c.setName(name);
        c.setCity(ct);
        c.setState(st);
        c.setStreet(str);
        c.setZip(zip);
        c.setEmail(em);
        party = c;
        party.addAccount(account);
        ClassicSingleton.getInstanceAccountManager().addAccountToList(account);

    }
}
