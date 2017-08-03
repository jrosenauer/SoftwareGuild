/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dto;

import java.math.BigDecimal;

/**
 *
 * @author apprentice
 */
public class Tax {

    private String state;
    private BigDecimal taxRate;

    public Tax(String state, BigDecimal taxRate) {
        this.state = state;
        this.taxRate = taxRate;
    }


    public Tax() {
    }

    /*
    public Tax() {
        
    }
    */
    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the taxRate
     */
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate the taxRate to set
     */
    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
}
