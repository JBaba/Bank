/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Group7.Bank.Controller;

import View.Group7.Bank.Dailog.WithdrawDialog;
import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.JDialog_Dialogview;
import com.asd.group7.common.singleton.ClassicSingleton;
import java.awt.event.ActionEvent;

/**
 *
 * @author james
 */
public class WithdrawController extends com.asd.group7.common.gui.controller.WithdrawController {

    public WithdrawController() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm = ClassicSingleton.getInstanceAccountFrm();
        String accnr = accountFrm.getAccountNo();
        JDialog_Dialogview dep = new WithdrawDialog(accountFrm, accnr);
        dep.setBounds(430, 15, 275, 140);
        dep.show();
    }

}
