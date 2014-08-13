/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Group7.Bank.Controller;

import View.Group7.Bank.Dailog.DepositDialog;
import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.JDialog_Dialogview;
import com.asd.group7.common.singleton.ClassicSingleton;
import java.awt.event.ActionEvent;

/**
 *
 * @author james
 */
public class DepositController extends com.asd.group7.common.gui.controller.DepositController {

    public DepositController() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm = ClassicSingleton.getInstanceAccountFrm();
        String accnr = accountFrm.getAccountNo();
        JDialog_Dialogview dep = new DepositDialog(accountFrm, accnr);
        dep.setBounds(430, 15, 275, 140);
        dep.show();
    }

}
