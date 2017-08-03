/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.io.FileNotFoundException;

/**
 *
 * @author apprentice
 */
public class NoItemInventoryException extends Exception {
    
    public NoItemInventoryException (String message, FileNotFoundException e) {
        super(message);
    }

    public NoItemInventoryException (String message, Throwable cause) {
        super(message);
    }

    NoItemInventoryException(String that_item_seems_to_be_out_of_stock_Good_n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
