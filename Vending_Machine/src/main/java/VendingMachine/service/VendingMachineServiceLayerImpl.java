/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Change;
import vendingmachine.dto.Fad;

/**
 *
 * @author apprentice
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    BigDecimal insertedAmount;
    private VendingMachineDao dao;

    public VendingMachineServiceLayerImpl(VendingMachineDao myDao) {
        this.dao = myDao;
    }

    public void sufficientFunds(ArrayList< Fad> UglyItem, int Inventory, BigDecimal insertedAmount) throws InsufficientFundsException {
        BigDecimal Price = UglyItem.get(Inventory).getPrice();

        if (insertedAmount.compareTo(Price) < 0) {
            throw new InsufficientFundsException("Please insert the correct amount.");
        }
    }

    public void ItemInventory(ArrayList< Fad> UglyItem, int Inventory) throws NoItemInventoryException {
        if (UglyItem.get(Inventory).getInventory() <= 0) {
            throw new NoItemInventoryException ("That item seems to be out of stock. Good news, though. It's ugly anyways.");
        }
    }

    @Override
    public ArrayList<Fad> getAllItems() {
        try {
            ArrayList< Fad> getUglyItem = new ArrayList<>();
            getUglyItem = dao.getAllItems();
            return getUglyItem;
        } catch (VendingMachinePersistenceException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public BigDecimal Change(Fad item, int Inventory, BigDecimal Payment) {
        insertedAmount = Payment.subtract(item.getPrice());
        return insertedAmount;
    }

    @Override
    public Change changeToCoins(BigDecimal Change) {
        Change coins = new Change();

        int Quarter = 0;
        int Dime = 0;
        int Nickel = 0;
        int Penny = 0;

        BigDecimal quarter = new BigDecimal(".25");
        BigDecimal dime = new BigDecimal(".10");
        BigDecimal nickel = new BigDecimal(".05");
        BigDecimal penny = new BigDecimal(".01");

        while (Change.compareTo(quarter) >= 0) {
            Quarter++;
            Change = Change.subtract(quarter);
        }
        while (Change.compareTo(dime) >= 0) {
            Dime++;
            Change = Change.subtract(dime);
        }
        while (Change.compareTo(nickel) >= 0) {
            Nickel++;
            Change = Change.subtract(nickel);
        }
        while (Change.compareTo(penny) >= 0) {
            Penny++;
            Change = Change.subtract(penny);
        }

        coins.setQuarter(Quarter);
        coins.setDime(Dime);
        coins.setNickel(Nickel);
        coins.setPenny(Penny);
        return coins;
    }

    @Override
    public void updateInventory(ArrayList<Fad> UglyItem, int Inventory) throws VendingMachinePersistenceException {
        dao.updateInventory(Inventory);
    }

    @Override
    public Fad getItem(int Selection) throws VendingMachinePersistenceException {
        return dao.getItem(Selection);
    }
}
