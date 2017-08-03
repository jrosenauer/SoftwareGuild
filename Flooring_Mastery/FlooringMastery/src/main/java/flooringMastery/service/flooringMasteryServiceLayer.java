/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.service;

import flooringMastery.dao.flooringMasteryPersistenceException;
import flooringMastery.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface flooringMasteryServiceLayer {

    public void addOrder(Order order) throws invalidStateException, invalidProductTypeException, flooringMasteryPersistenceException;

    public void save() throws flooringMasteryPersistenceException;

    public void removeOrder(LocalDate date, int orderNumber) throws flooringMasteryPersistenceException;

    public BigDecimal getMaterialCosts(BigDecimal area, BigDecimal costPerSquareFoot) throws invalidProductTypeException, flooringMasteryPersistenceException;

    public BigDecimal getLaborCosts(BigDecimal area, BigDecimal laborCostPesssrSquareFoot) throws flooringMasteryPersistenceException;

    public BigDecimal getTax(BigDecimal taxRate, BigDecimal materialCosts, BigDecimal laborCosts) throws flooringMasteryPersistenceException, invalidStateException;

    public BigDecimal getTotal(BigDecimal tax, BigDecimal laborCosts, BigDecimal materialCosts) throws flooringMasteryPersistenceException;

    //public Order getOrder(String date, int orderNumber) throws flooringMasteryPersistenceException;

    public Order editOrder(Order order) throws flooringMasteryPersistenceException, invalidProductTypeException, invalidStateException;
    
    public HashMap< Integer, Order> getOrders(LocalDate date);

}
