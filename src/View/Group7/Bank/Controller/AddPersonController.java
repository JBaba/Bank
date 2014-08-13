/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Group7.Bank.Controller;

import View.Group7.Bank.Dailog.PersonDialog;
import View.Group7.Bank.Type.MyAccountType;
import com.asd.group7.common.app.type.PartyType;
import com.asd.group7.common.app.type.Types;
import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.controller.AccountController;
import com.asd.group7.common.lib.account.AAccount;
import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.factory.FactoryProducer;
import com.asd.group7.common.lib.party.IParty;
import com.asd.group7.common.app.party.Person;
import com.asd.group7.common.singleton.ClassicSingleton;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 *
 * @author naimi_000
 */
public class AddPersonController extends AccountController {

    public AddPersonController() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm = ClassicSingleton.getInstanceAccountFrm();
        PersonDialog pac = new PersonDialog(accountFrm);
        pac.setBounds(450, 20, 300, 330);
        pac.show();
    }

    public void createAccount(MyAccountType accountType, String name, String ct, String st, String str, String zip, String acnr, String bd, String em) {
        IAccount account = FactoryProducer.getFactory(MyAccountType.MYAC).getAccount(accountType);
        IParty party = FactoryProducer.getFactory(Types.PARTY).getParty(PartyType.PERSONAL);
        AAccount aAccount = (AAccount) account;
        aAccount.setAcctNumber(acnr);

        account = aAccount;

        Person c = (Person) party;
        c.setName(name);
        c.setCity(ct);
        c.setState(st);
        c.setStreet(str);
        c.setZip(zip);
        c.setDateOfBirth(new Date(bd));
        c.setEmail(em);
        party = c;
        party.addAccount(account);
        ClassicSingleton.getInstanceAccountManager().addAccountToList(account);

    }
}
