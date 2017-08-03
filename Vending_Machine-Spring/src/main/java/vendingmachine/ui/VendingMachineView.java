/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.ui;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dto.Change;
import vendingmachine.dto.Fad;

/**
 *
 * @author apprentice
 */
public class VendingMachineView {

    public VendingMachineIO io;

    public VendingMachineView() {
    }

    public VendingMachineView(VendingMachineIO io) {
        this.io = io;
    }

    public BigDecimal insertMoney() {

        String insertedAmountString = io.readString("Please insert amount.");
        BigDecimal insertedAmount = new BigDecimal(insertedAmountString);
        return insertedAmount;
    }

    public int menuItems(List< Fad> style) {

        io.print(" === Menu === ");
        for (int i = 0; i < style.size(); i++) {

            io.print(i + "|" + style.get(i).getItem() + " ----------" + style.get(i).getPrice());
            //io.print("2  |" + style.get(1).getItem() + " ----------" + style.get(1).getPrice());
            //io.print("3  |" + style.get(2).getItem() + " ----------" + style.get(2).getPrice());
            //io.print("4  |" + style.get(3).getItem() + " ----------" + style.get(3).getPrice());
            //io.print("5  |" + style.get(4).getItem() + " ----------" + style.get(4).getPrice());
            // io.print("6  |" + style.get(5).getItem() + " ----------" + style.get(5).getPrice());

        }
        int Selection = io.readInt("Please insert menu item.");
        return Selection;

    }

    public int leftoverMoney(Change coins, BigDecimal change) {

        io.print("Your change is " + change);
        io.print("Quarters: " + coins.getQuarter());
        io.print("Dimes: " + coins.getDime());
        io.print("Nickels: " + coins.getNickel());
        io.print("Pennies: " + coins.getPenny());
        io.print("");
        return 0;

    }
}
