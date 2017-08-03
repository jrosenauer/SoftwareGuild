/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author apprentice
 */
public class InsufficientFundsException extends Exception {

    private String message;

    public InsufficientFundsException(String message) {
        this.message = message;
    }
}
