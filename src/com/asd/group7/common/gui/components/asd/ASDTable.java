/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asd.group7.common.gui.components.asd;

import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author james
 */
public class ASDTable extends JTable {

    public ASDTable(TableModel dm) {
        super(dm);
        setModel(dm);
    }
    
}
