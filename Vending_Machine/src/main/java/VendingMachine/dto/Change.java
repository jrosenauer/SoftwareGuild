/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dto;

/**
 *
 * @author apprentice
 */
public class Change {
    
    private int Quarter, Dime, Nickel, Penny;

    /**
     * @return the Quarter
     */
    public int getQuarter() {
        return Quarter;
    }

    /**
     * @param Quarter the Quarter to set
     */
    public void setQuarter(int Quarter) {
        this.Quarter = Quarter;
    }

    /**
     * @return the Dime
     */
    public int getDime() {
        return Dime;
    }

    /**
     * @param Dime the Dime to set
     */
    public void setDime(int Dime) {
        this.Dime = Dime;
    }

    /**
     * @return the Nickel
     */
    public int getNickel() {
        return Nickel;
    }

    /**
     * @param Nickel the Nickel to set
     */
    public void setNickel(int Nickel) {
        this.Nickel = Nickel;
    }

    /**
     * @return the Penny
     */
    public int getPenny() {
        return Penny;
    }

    /**
     * @param Penny the Penny to set
     */
    public void setPenny(int Penny) {
        this.Penny = Penny;
    }
}
