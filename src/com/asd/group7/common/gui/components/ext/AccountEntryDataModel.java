/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.gui.components.ext;

import com.asd.group7.common.gui.components.asd.ASDEntryDataModel;
import com.asd.group7.common.lib.mediator.ISenderColleague;
import com.asd.group7.common.lib.mediator.Mediator;
import com.asd.group7.common.lib.mediator.Message;

/**
 *
 * @author james
 */
public class AccountEntryDataModel extends ASDEntryDataModel implements ISenderColleague {

    private static final String NAME = "ACCOUNT_ENTRY_ROW";
    private Mediator mediator;

    public AccountEntryDataModel(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void send(Message message) {
        mediator.send(this, message);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
