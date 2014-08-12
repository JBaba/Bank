package com.asd.group7.common.gui;

import com.asd.group7.common.gui.controller.AccountController;
import com.asd.group7.common.gui.controller.DepositController;
import com.asd.group7.common.gui.controller.ExitController;
import com.asd.group7.common.gui.controller.InterestController;
import com.asd.group7.common.gui.controller.WithdrawController;
import com.asd.group7.common.lib.factory.FactoryProducer;
import com.asd.group7.common.singleton.ClassicSingleton;
import gui.bank.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;

import javax.swing.*;

/**
 * A basic JFC based application.
 */
public class AccountFrm extends javax.swing.JFrame {

    static {
        new FactoryProducer();
    }
    /**
     * **
     * init variables in the object **
     */
    public String accountnr, clientName, street, city, zip, state, accountType, clientType, amountDeposit;
    public boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;

    AccountFrm myframe = null;

    private Object rowdata[];

    public AccountFrm() {

        myframe = this;

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
        JScrollPane1 = new JScrollPane();
        model = setTableModel();
        JTable1 = new JTable(model);

        rowdata = new Object[8];
        newaccount = false;

        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12, 92, 444, 160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];

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

        JButton_Exit.addActionListener(new ExitController());
        JButton_PerAC.addActionListener(new AccountController());
        JButton_CompAC.addActionListener(new AccountController());
        JButton_Deposit.addActionListener(new DepositController());
        JButton_Withdraw.addActionListener(new WithdrawController());
        JButton_Addinterest.addActionListener(new InterestController());

    }

    /**
     * create Model for table
     *
     * @return
     */
    protected DefaultTableModel setTableModel() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");

        return model;
    }

    public String getAccountNo() {
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
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

    protected javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
    protected javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
    protected javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
    protected javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
    protected javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
    protected javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
    protected javax.swing.JButton JButton_Exit = new javax.swing.JButton();

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
