/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.mediator;

/**
 *
 * @author james
 */
public interface IReceiverColleague extends IColleague {

    public void receive(Message message);
}