/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

/**
 *
 * @author apprentice
 */
public class InsufficientFundsException extends Exception {
    
    public InsufficientFundsException (String noMoney) {
        super(noMoney);
    }
}
