/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.util.ArrayList;
import vendingmachine.dto.Fad;

/**
 *
 * @author apprentice
 */
public interface VendingMachineDao {
 
    public ArrayList < Fad > getAllItems() throws VendingMachinePersistenceException;
    
    public void updateInventory(int Index) throws VendingMachinePersistenceException;
    
    public Fad getItem (int Selection) throws VendingMachinePersistenceException;
}
