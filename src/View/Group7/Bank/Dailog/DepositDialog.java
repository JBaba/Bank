/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View.Group7.Bank.Dailog;

import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.JDialog_Dialogview;
import com.asd.group7.common.gui.controller.DepositController;
import java.awt.event.ActionEvent;

/**
 *
 * @author naimi_000
 */
public class DepositDialog extends JDialog_Dialogview{

    public DepositDialog(AccountFrm parent, String aaccnr) {
        super(parent, aaccnr);
        setTitle("Deposit Money");
    }

    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        String name=JTextField_NAME.getText();
        String amount=JTextField_Deposit.getText();
        new DepositController().deposit(this.getAccnr(), amount, name);
        dispose();
        setVisible(false);
    }
    
    
    
}
