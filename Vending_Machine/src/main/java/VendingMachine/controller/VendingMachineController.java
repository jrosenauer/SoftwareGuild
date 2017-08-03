/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Change;
import vendingmachine.dto.Fad;
import vendingmachine.service.InsufficientFundsException;
import vendingmachine.service.NoItemInventoryException;
import vendingmachine.service.VendingMachineServiceLayer;
import vendingmachine.ui.VendingMachineView;

/**
 *
 * @author apprentice
 */
public class VendingMachineController {

    VendingMachineView view;
    VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {

        BigDecimal price;
        int item;
        boolean statement = false;

        ArrayList< Fad> items = new ArrayList<>();

        items = service.getAllItems();
        item = view.menuItems(items);
        price = view.insertMoney();

        try {
            service.sufficientFunds(items, item, price);
        } catch (InsufficientFundsException e) {
            System.out.println("You have not inserted enough money.");

        }

        try {
            service.ItemInventory(items, item);
        } catch (NoItemInventoryException e) {
            statement = true;
            System.out.println("Unfortauntely we are out of this product. Please choose another.");
        }

        if (statement == false) {
            try {
                service.updateInventory(items, item);
                BigDecimal change = service.Change(service.getItem(item), item, price);
                Change coins = service.changeToCoins(change);
                view.leftoverMoney(coins, change);
            } catch (VendingMachinePersistenceException e) {
                System.out.println("BEEP BEEP BEEP. ERROR! LEAVE NOW!");
            }
        }
    }
}
