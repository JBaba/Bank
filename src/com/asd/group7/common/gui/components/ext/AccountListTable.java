/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asd.group7.common.gui.components.ext;

import com.asd.group7.common.gui.components.asd.ASDTable;
import com.asd.group7.common.lib.mediator.IReceiverColleague;
import com.asd.group7.common.lib.mediator.Message;
import javax.swing.table.TableModel;

/**
 *
 * @author james
 */
public class AccountListTable extends ASDTable implements IReceiverColleague{
    
    private static final String NAME = "ACCOUNT_LIST_TABLE";

    public AccountListTable(TableModel dm) {
        super(dm);
    }

    @Override
    public void receive(Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return NAME;
    }
}
