/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View.Group7.Bank.Controller;

import View.Group7.Bank.Dailog.CompanyDialog;
import View.Group7.Bank.Type.MyAccountType;
import com.asd.group7.common.app.type.PartyType;
import com.asd.group7.common.app.type.Types;
import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.controller.AccountController;
import com.asd.group7.common.lib.account.AAccount;
import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.factory.FactoryProducer;
import com.asd.group7.common.app.party.Company;
import com.asd.group7.common.lib.party.IParty;
import com.asd.group7.common.singleton.ClassicSingleton;
import java.awt.event.ActionEvent;

/**
 *
 * @author naimi_000
 */
public class AddCompanyController extends AccountController{

    public AddCompanyController() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm=ClassicSingleton.getInstanceAccountFrm();
        CompanyDialog pac = new CompanyDialog(accountFrm);
        pac.setBounds(450, 20, 300, 330);
        pac.show();
    }
    
    public void createAccount(MyAccountType accountType,String name,String ct,String st,String str,String zip
            ,String acnr,String noe,String em){
        IAccount account=FactoryProducer.getFactory(MyAccountType.MYAC).getAccount(accountType);
        AAccount aAccount = (AAccount)account;
        aAccount.setAcctNumber(acnr);
        
        account = aAccount;
        IParty party=FactoryProducer.getFactory(Types.PARTY).getParty(PartyType.COMPANY);
        Company c=(Company)party;
        c.setName(name);
        c.setCity(ct);
        c.setState(st);
        c.setStreet(str);
        c.setZip(zip);
        try{
            c.setNoOfEmployee(Integer.parseInt(noe));
        }catch(NumberFormatException e){
            System.err.println("Number formate in noofemplyee");
            c.setNoOfEmployee(1);
        }
        c.setEmail(em);
        party=c;
        party.addAccount(account);
        ClassicSingleton.getInstanceAccountManager().addAccountToList(account);
    }
    
    
}
