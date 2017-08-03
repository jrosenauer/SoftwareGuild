/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author apprentice
 */
public class Fad {

    public Fad(String Fad) {
        Item = Fad;

    }
    private String Item;
    private BigDecimal Price;
    private int Inventory;

    /**
     * @return the Item
     */
    public String getItem() {
        return Item;
    }

    /**
     * @param Item the Item to set
     */
    public void setItem(String Item) {
        this.Item = Item;
    }

    /**
     * @return the Price
     */
    public BigDecimal getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(BigDecimal Price) {
        this.Price = Price;
    }

    /**
     * @return the Inventory
     */
    public int getInventory() {
        return Inventory;
    }

    /**
     * @param Inventory the Inventory to set
     */
    public void setInventory(int Inventory) {
        this.Inventory = Inventory;
    }

}
