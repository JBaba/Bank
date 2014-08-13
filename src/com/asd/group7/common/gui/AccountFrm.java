package com.asd.group7.common.gui;

import com.asd.group7.common.gui.components.asd.ASDFrame;
import com.asd.group7.common.gui.components.asd.ASDPanel;
import com.asd.group7.common.gui.components.asd.ASDScrollPane;
import com.asd.group7.common.gui.components.ext.AccountEntryDataModel;
import com.asd.group7.common.gui.components.ext.AccountListTable;
import com.asd.group7.common.gui.components.ext.AddInterestButton;
import com.asd.group7.common.gui.components.ext.CompanyAccountButton;
import com.asd.group7.common.gui.components.ext.DepositButton;
import com.asd.group7.common.gui.components.ext.ExitButton;
import com.asd.group7.common.gui.components.ext.PersonalAccountButton;
import com.asd.group7.common.gui.components.ext.WithdrawButton;
import com.asd.group7.common.gui.controller.AccountController;
import com.asd.group7.common.gui.controller.DepositController;
import com.asd.group7.common.gui.controller.ExitController;
import com.asd.group7.common.gui.controller.InterestController;
import com.asd.group7.common.gui.controller.WithdrawController;
import com.asd.group7.common.lib.account.AccountManager;
import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.factory.FactoryProducer;
import com.asd.group7.common.lib.mediator.Mediator;
import com.asd.group7.common.lib.mediator.Message;
import com.asd.group7.common.lib.party.AParty;
import com.asd.group7.common.singleton.ClassicSingleton;
import java.awt.*;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * A basic JFC based application.
 */
public class AccountFrm extends ASDFrame {

    static {
        new FactoryProducer();
    }
    /**
     * **
     * init variables in the object **
     */
    public String accountnr, clientName, street, city, zip, state, accountType, clientType, amountDeposit;
    public boolean newaccount;
    protected static AccountEntryDataModel model;
    protected static AccountListTable table1;
    protected ASDScrollPane scrollPane1;

    AccountFrm myframe = null;

    protected Object rowdata[];

    private Mediator mediator;

    public AccountFrm() {

        myframe = this;
        mediator = ClassicSingleton.getMediator();

        setTitle("Account Application");

        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setSize(575, 310);
        setVisible(false);

        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0, 0, 575, 310);
        /*
         /Add five buttons on the pane 
         /for Adding personal account, Adding company account
         /Deposit, Withdraw and Exit from the system
         */
        scrollPane1 = new ASDScrollPane();
        model = setTableModel();
        table1 = new AccountListTable(model);
        //model=table1
        rowdata = new Object[8];
        newaccount = false;

        JPanel1.add(scrollPane1);
        scrollPane1.setBounds(12, 92, 444, 160);
        scrollPane1.getViewport().add(table1);
        table1.setBounds(0, 0, 420, 0);

        rowdata = new Object[8];

        JButton_PerAC.setText("Add personal account");
        JPanel1.add(JButton_PerAC);
        JButton_PerAC.setBounds(24, 20, 192, 33);
        JButton_CompAC.setText("Add company account");
        JButton_CompAC.setActionCommand("jbutton");
        JPanel1.add(JButton_CompAC);
        JButton_CompAC.setBounds(240, 20, 192, 33);
        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468, 104, 96, 33);
        JButton_Withdraw.setText("Withdraw");
        JPanel1.add(JButton_Withdraw);
        JButton_Addinterest.setBounds(448, 20, 106, 33);
        JButton_Addinterest.setText("Add interest");
        JPanel1.add(JButton_Addinterest);
        JButton_Withdraw.setBounds(468, 164, 96, 33);
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468, 248, 96, 31);

        JButton_PerAC.setActionCommand("jbutton");

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);

        mediator.addColleague(JButton_Deposit);
        mediator.addColleague(JButton_Withdraw);
        mediator.addColleague(JButton_Addinterest);
        mediator.addColleague(table1);

        JButton_Exit.addActionListener(new ExitController());
        JButton_PerAC.addActionListener(new AccountController());
        JButton_CompAC.addActionListener(new AccountController());
        JButton_Deposit.addActionListener(new DepositController());
        JButton_Withdraw.addActionListener(new WithdrawController());
        JButton_Addinterest.addActionListener(new InterestController());

        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                try {
                    model.send(new Message(AccountManager.ACCOUNT_SELECTED, true));
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });

    }

    /**
     * create Model for table
     *
     * @return
     */
    protected AccountEntryDataModel setTableModel() {

        AccountEntryDataModel model = new AccountEntryDataModel();
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");

        return model;
    }

    public void loadTableWithData() {
        model.setRowCount(0);
        AccountManager accountManager = ClassicSingleton.getInstanceAccountManager();
        for (Iterator<IAccount> it = accountManager.getAccountList().iterator(); it.hasNext();) {
            IAccount iAccount = it.next();
            rowdata = new Object[8];
            rowdata[0] = iAccount.getAcctNumber();
            AParty aParty = (AParty) iAccount.getParty();
            rowdata[1] = aParty.getName();
            rowdata[2] = aParty.getCity();
            rowdata[3] = aParty.getType();
            rowdata[4] = iAccount.getType();
            rowdata[5] = iAccount.getCurrentBalance();
            model.addRow(rowdata);
        }
        

    }

    public String getAccountNo() {
        int selection = table1.getSelectionModel().getMinSelectionIndex();
        String accnr = "0";
        try {
            accnr = (String) model.getValueAt(selection, 0);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return accnr;
    }

    /**
     * ***************************************************
     * The entry point for this application. Sets the Look and Feel to the
     * System Look and Feel. Creates a new JFrame1 and makes it visible.
     * ***************************************************
     */
    static public void main(String args[]) {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            //Create a new instance of our application's frame, and make it visible.
            (ClassicSingleton.getInstanceAccountFrm()).setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }

    protected ASDPanel JPanel1 = new ASDPanel();
    protected PersonalAccountButton JButton_PerAC = new PersonalAccountButton();
    protected CompanyAccountButton JButton_CompAC = new CompanyAccountButton();
    protected DepositButton JButton_Deposit = new DepositButton(mediator);
    protected WithdrawButton JButton_Withdraw = new WithdrawButton(mediator);
    protected AddInterestButton JButton_Addinterest = new AddInterestButton(mediator);
    protected ExitButton JButton_Exit = new ExitButton();

    protected void exitApplication() {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    protected class SymWindow extends java.awt.event.WindowAdapter {

        public void windowClosing(java.awt.event.WindowEvent event) {
            Object object = event.getSource();
            if (object == AccountFrm.this) {
                BankFrm_windowClosing(event);
            }
        }
    }

    protected void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
        // to do: code goes here.
        BankFrm_windowClosing_Interaction1(event);
    }

    protected void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }
}
