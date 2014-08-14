/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Group7.CreditCard;

import View.Group7.Bank.*;
import View.Group7.Bank.Controller.AddCompanyController;
import View.Group7.Bank.Controller.AddPersonController;
import View.Group7.Bank.Controller.DepositController;
import View.Group7.Bank.Controller.WithdrawController;
import View.Group7.Bank.Factory.MyAccountFactory;
import View.Group7.Bank.Type.MyAccountType;
import View.Group7.CreditCard.Account.CreditCardAccount;
import View.Group7.CreditCard.Controller.AddCreditCardController;
import View.Group7.CreditCard.Controller.BillController;
import View.Group7.CreditCard.Factory.CreditCardFactory;
import View.Group7.CreditCard.Type.CreditAccountType;
import com.asd.group7.common.app.comparator.AccountComparator;
import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.components.ext.AccountEntryDataModel;
import com.asd.group7.common.lib.account.AAccount;
import com.asd.group7.common.lib.account.AccountManager;
import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.factory.FactoryProducer;
import com.asd.group7.common.lib.mediator.Mediator;
import com.asd.group7.common.lib.mediator.Message;
import com.asd.group7.common.lib.party.AParty;
import com.asd.group7.common.singleton.ClassicSingleton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author naimi_000
 */
public class CreditCard extends AccountFrm {

    static {
        FactoryProducer.addAbstractFactory(CreditAccountType.MYAC, new CreditCardFactory());
    }

    public static CreditCard creditCard;

    public static CreditCard getInstance() {
        if (creditCard == null) {
            creditCard = new CreditCard();
            ClassicSingleton.setAccountFrm(creditCard);
        }
        return creditCard;
    }

    public CreditCard() {
        setTitle("Credit Card Application");

        JButton_PerAC.setText("Add Credit-card account");
        JButton_Withdraw.setText("Charge");
        JButton_CompAC.setText("Generate Monthly bills");

        //remove all listener that we have first
        for (ActionListener al : JButton_PerAC.getActionListeners()) {
            JButton_PerAC.removeActionListener(al);
        }
        for (ActionListener al : JButton_CompAC.getActionListeners()) {
            JButton_CompAC.removeActionListener(al);
        }
        for (ActionListener al : JButton_Deposit.getActionListeners()) {
            JButton_Deposit.removeActionListener(al);
        }
        for (ActionListener al : JButton_Withdraw.getActionListeners()) {
            JButton_Withdraw.removeActionListener(al);
        }

        JButton_CompAC.addActionListener(new BillController());
        JButton_PerAC.addActionListener(new AddCreditCardController());
        JButton_Deposit.addActionListener(new DepositController());
        JButton_Withdraw.addActionListener(new WithdrawController());
    }

    @Override
    public String getAccountNo() {
        int selection = table1.getSelectionModel().getMinSelectionIndex();
        String accnr = "0";
        try {
            accnr = (String) model.getValueAt(selection, 1);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return accnr;
    }

    @Override
    protected AccountEntryDataModel setTableModel(Mediator mediator) {
        AccountEntryDataModel model = new AccountEntryDataModel(mediator);

        model.addColumn("Name");
        model.addColumn("CC number");
        model.addColumn("Exp date");
        model.addColumn("Type");
        model.addColumn("Balance");

        return model;
    }

    @Override
    public void loadTableWithData() {
        try {
            model.setRowCount(0);
            AccountManager accountManager = ClassicSingleton.getInstanceAccountManager();
            for (Iterator<AAccount> it = accountManager.getAccountList().getSortedIterator(new AccountComparator(selectedColumn)); it.hasNext();) {
                IAccount iAccount = it.next();
                rowdata = new Object[8];
                rowdata[1] = iAccount.getAcctNumber();
                AParty aParty = (AParty) iAccount.getParty();
                rowdata[0] = aParty.getName();
                CreditCardAccount account = (CreditCardAccount) iAccount;
                rowdata[2] = account.getExpiryDate();
                rowdata[3] = iAccount.getType();
                rowdata[4] = iAccount.getCurrentBalance();
                model.addRow(rowdata);
            }
            model.send(new Message(accountManager.ACCOUNT_SELECTED, false));
        } catch (Exception ex) {
            Logger.getLogger(AccountFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            //(new Bank()).setVisible(true);
            CreditCard.getInstance().setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }
}
