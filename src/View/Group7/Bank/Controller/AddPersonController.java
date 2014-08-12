/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View.Group7.Bank.Controller;

import View.Group7.Bank.Dailog.CompanyDialog;
import View.Group7.Bank.Dailog.PersonDialog;
import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.controller.AccountController;
import com.asd.group7.common.singleton.ClassicSingleton;
import java.awt.event.ActionEvent;

/**
 *
 * @author naimi_000
 */
public class AddPersonController extends AccountController{

    public AddPersonController() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("I am a Person");
        AccountFrm accountFrm=ClassicSingleton.getInstanceAccountFrm();
        PersonDialog pac = new PersonDialog(accountFrm);
        pac.setBounds(450, 20, 300, 330);
        pac.show();
    }
    
    
}
