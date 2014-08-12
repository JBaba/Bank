/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Group7.CreditCard.Dialog;

import View.Group7.Bank.Controller.AddCompanyController;
import View.Group7.Bank.Type.MyAccountType;
import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.JDialog_AddAccount;
import java.awt.event.ActionEvent;

/**
 *
 * @author dhruba
 */
public class CreditCardDialog extends JDialog_AddAccount {

    public CreditCardDialog(AccountFrm parent) {
        super(parent);
        setTitle("Add Credit Card Account");

        JLabel6.setText("No of employees");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12, 204, 96, 24);
        
        repaint();
    }

    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        String name,ct,st,str,zip,acnr,noe,em;
        name=JTextField_NAME.getText();
	ct=JTextField_CT.getText();
	st=JTextField_ST.getText();
	str=JTextField_STR.getText();
	zip=JTextField_ZIP.getText();
        acnr=JTextField_ACNR.getText();
        noe=JTextField_BD.getText();
	em=JTextField_EM.getText();
        if(JRadioButton_Chk.isSelected()){
            MyAccountType accountType=MyAccountType.CHECKING;
            new AddCompanyController().createAccount(accountType, name, ct, st, str, zip, acnr, noe, em);
        }else if(JRadioButton_Sav.isSelected()){
            MyAccountType accountType=MyAccountType.SAVING;
            new AddCompanyController().createAccount(accountType, name, ct, st, str, zip, acnr, noe, em);
        }
    }

}
