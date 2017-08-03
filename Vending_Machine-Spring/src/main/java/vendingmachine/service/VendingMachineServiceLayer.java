/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Change;
import vendingmachine.dto.Fad;

/**
 *
 * @author apprentice
 */
public interface VendingMachineServiceLayer {

    public ArrayList< Fad> getAllItems();

    public void sufficientFunds(ArrayList< Fad> UglyItem, int Inventory, BigDecimal Payment) throws InsufficientFundsException;

    public void updateInventory(ArrayList< Fad> UglyItem, int Inventory) throws VendingMachinePersistenceException;

    public BigDecimal Change(Fad item, int Inventory, BigDecimal Payment);

    public Change changeToCoins(BigDecimal Change);

    public void ItemInventory(ArrayList< Fad> UglyItem, int Inventory) throws NoItemInventoryException;

    public Fad getItem(int Selection) throws VendingMachinePersistenceException;

}
