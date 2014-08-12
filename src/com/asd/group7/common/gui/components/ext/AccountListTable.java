/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.gui.components.ext;

import com.asd.group7.common.gui.components.asd.ASDTable;
import com.asd.group7.common.lib.account.AccountManager;
import com.asd.group7.common.lib.mediator.IReceiverColleague;
import com.asd.group7.common.lib.mediator.Mediator;
import com.asd.group7.common.lib.mediator.Message;
import com.asd.group7.common.singleton.ClassicSingleton;
import javax.swing.table.TableModel;

/**
 *
 * @author james
 */
public class AccountListTable extends ASDTable implements IReceiverColleague {

    private static final String NAME = "ACCOUNT_LIST_TABLE";

    public AccountListTable(TableModel dm) {
        super(dm);
    }

    @Override
    public void receive(Message message) {
        if (message.getAbout().equalsIgnoreCase(AccountManager.UPDATE_ACCOUNT_TABLE)) {
            ClassicSingleton.getInstanceAccountFrm().loadTableWithData();
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}
