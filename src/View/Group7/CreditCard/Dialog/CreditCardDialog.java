/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Group7.CreditCard.Dialog;

import View.Group7.Bank.Controller.AddCompanyController;
import View.Group7.Bank.Type.MyAccountType;
import View.Group7.CreditCard.Controller.AddCreditCardController;
import View.Group7.CreditCard.Type.CreditAccountType;
import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.JDialog_AddAccount;
import java.awt.event.ActionEvent;

/**
 *
 * @author naimi
 */
public class CreditCardDialog extends JDialog_AddAccount {

    protected javax.swing.JRadioButton JRadioButton_Bronze = new javax.swing.JRadioButton();
    
    public CreditCardDialog(AccountFrm parent) {
        super(parent);
        setTitle("Add Credit Card Account");
        
        JRadioButton_Chk.setText("Gold");
        JRadioButton_Sav.setText("Silver");
        
        buttonGroup.add(JRadioButton_Bronze);
        
        JRadioButton_Bronze.setText("Bronze");
        JRadioButton_Bronze.setActionCommand("Bronze");
        getContentPane().add(JRadioButton_Bronze);
        JRadioButton_Bronze.setBounds(120, 24, 84, 24);
        //JRadioButton_Bronze.addMouseListener(aSymMouse);
        
        JLabel1.setText("Street");
        JLabel2.setText("City");
        JLabel3.setText("State");
        JLabel4.setText("Zip");
        JLabel5.setText("Email");
        JLabel7.setText("Exp. Date");
        JLabel8.setText("Name");
        
        JLabel6.setText("CC number");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12, 204, 96, 24);

        repaint();
    }

    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        String name, ct, st, str, zip, acnr, expdate, em;
        //name = JTextField_NAME.getText();
        name = JTextField_ACNR.getText();
        ct = JTextField_STR.getText();
        st = JTextField_CT.getText();
        str = JTextField_NAME.getText();
        zip = JTextField_ST.getText();
        acnr = JTextField_BD.getText();
        expdate = JTextField_EM.getText();
        em = JTextField_ZIP.getText();
        
        if (JRadioButton_Chk.isSelected()) {
            CreditAccountType accountType = CreditAccountType.GOLD;
            new AddCreditCardController().createAccount(accountType, name, ct, st, str, zip, acnr, expdate, em);
        } else if (JRadioButton_Sav.isSelected()) {
            CreditAccountType accountType = CreditAccountType.SILVER;
            new AddCreditCardController().createAccount(accountType, name, ct, st, str, zip, acnr, expdate, em);
        } else if( JRadioButton_Bronze.isSelected()){
            CreditAccountType accountType = CreditAccountType.BROZE;
            new AddCreditCardController().createAccount(accountType, name, ct, st, str, zip, acnr, expdate, em);
        }
        
        dispose();
    }

    public static void main(String[] s){
        new CreditCardDialog(null).setVisible(true);
    }
}
