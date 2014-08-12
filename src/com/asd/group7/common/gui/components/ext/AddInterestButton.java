/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asd.group7.common.gui.components.ext;

import com.asd.group7.common.gui.components.asd.ASDButton;
import com.asd.group7.common.lib.account.AccountManager;
import com.asd.group7.common.lib.mediator.IReceiverColleague;
import com.asd.group7.common.lib.mediator.Mediator;
import com.asd.group7.common.lib.mediator.Message;

/**
 *
 * @author james
 */
public class AddInterestButton extends ASDButton implements IReceiverColleague {
    
    private static final String NAME = "ADD_INTEREST_BUTTON";
    
    private Mediator mediator;

    public AddInterestButton(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receive(Message message) {
        if(message.getAbout().equalsIgnoreCase(AccountManager.ACCOUNT_LIST_NOT_EMPTY)) {
            this.setEnabled(message.isStatus());
        }
    }

    public static String getNAME() {
        return NAME;
    }
    
}
