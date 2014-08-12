/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 */
public class Mediator implements IMediator {

    private List<IColleague> colleagueList;

    public Mediator() {
        colleagueList = new ArrayList<IColleague>();
    }

    @Override
    public void addColleague(IColleague colleague) {
        colleagueList.add(colleague);
    }

    @Override
    public void send(IColleague colleague, Message message) {
        System.out.println(colleague.getName().toUpperCase() + " : " + message.getAbout().toUpperCase() + " : " + message.isStatus());
        for (IColleague c : colleagueList) {
            if (c != colleagueList) {
                if (c instanceof IReceiverColleague) {
                    ((IReceiverColleague) c).receive(message);
                }
            }
        }
    }
}
