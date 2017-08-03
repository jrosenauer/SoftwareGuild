/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.service;

import java.io.FileNotFoundException;

/**
 *
 * @author apprentice
 */
public class noOrderOnDateException extends Exception {
    
    public noOrderOnDateException (String message, FileNotFoundException e) {
        super(message);
    }

    public noOrderOnDateException (String message, Throwable cause) {
        super(message);
    }
}
