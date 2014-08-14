/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View.Group7.CreditCard.Controller;

import View.Group7.CreditCard.Dialog.JDialogGenBill;
import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.controller.Controller;
import com.asd.group7.common.singleton.ClassicSingleton;

import java.awt.event.ActionEvent;

/**
 *
 * @author naimi_000
 */
public class BillController implements Controller{

    @Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm = ClassicSingleton.getInstanceAccountFrm();
        JDialogGenBill pac = new JDialogGenBill(accountFrm);
        String a=ClassicSingleton.getInstanceAccountManager().generateReport().toString();
        pac.setReport(a);
        pac.setBounds(450, 20, 300, 330);
        pac.show();
    }
    
    
}
