/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import flooringMastery.dto.Product;
import flooringMastery.service.invalidProductTypeException;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface productDao {

    Product getProductInfo(String productType) throws flooringMasteryPersistenceException;

    public Map< String, Product> getAllItems() throws flooringMasteryPersistenceException;

    public BigDecimal getCostByProductType(String productType) throws flooringMasteryPersistenceException;

    public BigDecimal getLaborCostByProductType(String productType) throws flooringMasteryPersistenceException;

}

