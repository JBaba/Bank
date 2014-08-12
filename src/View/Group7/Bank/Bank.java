/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Group7.Bank;

import View.Group7.Bank.Controller.AddCompanyController;
import View.Group7.Bank.Controller.AddPersonController;
import View.Group7.Bank.Factory.MyAccountFactory;
import View.Group7.Bank.Type.MyAccountType;
import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.controller.AccountController;
import com.asd.group7.common.lib.factory.FactoryProducer;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.UIManager;

/**
 *
 * @author naimi_000
 */
public class Bank extends AccountFrm {

    static {
        FactoryProducer.addAbstractFactory(MyAccountType.MYAC, new MyAccountFactory());
    }

    public Bank() {
        setTitle("Bank Application");

        //remove all listener that we have first
        for (ActionListener al : JButton_PerAC.getActionListeners()) {
            JButton_PerAC.removeActionListener(al);
        }
        for (ActionListener al : JButton_CompAC.getActionListeners()) {
            JButton_CompAC.removeActionListener(al);
        }

        JButton_CompAC.addActionListener(new AddCompanyController());
        JButton_PerAC.addActionListener(new AddPersonController());
    }

    static public void main(String args[]) {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            //Create a new instance of our application's frame, and make it visible.
            (new Bank()).setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }
}
