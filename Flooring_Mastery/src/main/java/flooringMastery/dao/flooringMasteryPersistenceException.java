/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import java.io.FileNotFoundException;

/**
 *
 * @author apprentice
 */
public class flooringMasteryPersistenceException extends Exception {

    public flooringMasteryPersistenceException(String message) {
        super(message);
    }

    public flooringMasteryPersistenceException(String message, Throwable cause) {
        super(message);
    }
}
