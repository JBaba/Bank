/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View.Group7.Bank.Controller;

import View.Group7.Bank.Dailog.CompanyDialog;
import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.JDialog_AddAccount;
import com.asd.group7.common.gui.controller.AccountController;
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
        System.out.println("I am a companay");
        AccountFrm accountFrm=ClassicSingleton.getInstanceAccountFrm();
        CompanyDialog pac = new CompanyDialog(accountFrm);
        pac.setBounds(450, 20, 300, 330);
        pac.show();
    }
    
    
}
