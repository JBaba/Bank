/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asd.group7.common.singleton;

import com.asd.group7.common.gui.AccountFrm;

/**
 *
 * @author naimi_000
 */
public class ClassicSingleton {
   private static AccountFrm instance = null;
   protected ClassicSingleton() {
      // Exists only to defeat instantiation.
   }
   public static AccountFrm getInstanceAccountFrm() {
      if(instance == null) {
         instance = new AccountFrm();
      }
      return instance;
   }
}
