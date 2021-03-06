/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Group7.Bank.Dailog;

import View.Group7.Bank.Controller.AddPersonController;
import View.Group7.Bank.Type.MyAccountType;
import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.JDialog_AddAccount;
import java.awt.event.ActionEvent;

/**
 *
 * @author naimi_000
 */
public class PersonDialog extends JDialog_AddAccount {

    public PersonDialog(AccountFrm parent) {
        super(parent);
        setTitle("Add Person Account");

        JLabel6.setText("Birthdate");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12, 204, 96, 24);

    }

    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        String name, ct, st, str, zip, acnr, bd, em;
        name = JTextField_NAME.getText();
        ct = JTextField_CT.getText();
        st = JTextField_ST.getText();
        str = JTextField_STR.getText();
        zip = JTextField_ZIP.getText();
        acnr = JTextField_ACNR.getText();
        bd = JTextField_BD.getText();
        em = JTextField_EM.getText();
        if (JRadioButton_Chk.isSelected()) {
            MyAccountType accountType = MyAccountType.CHECKING;
            new AddPersonController().createAccount(accountType, name, ct, st, str, zip, acnr, bd, em);
        } else if (JRadioButton_Sav.isSelected()) {
            MyAccountType accountType = MyAccountType.SAVING;
            new AddPersonController().createAccount(accountType, name, ct, st, str, zip, acnr, bd, em);
        }
        dispose();
        setVisible(false);
    }

}
