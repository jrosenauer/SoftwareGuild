/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import flooringMastery.dto.Order;
import flooringMastery.dto.Product;
import flooringMastery.service.flooringMasteryServiceLayerImpl;
import java.math.BigDecimal;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class productDaoImplTest {
    
    flooringMasteryServiceLayerImpl serviceTest;
    flooringMasteryServiceLayerImpl service;
    orderDaoImpl orderDao = new orderDaoImpl();
    productDaoImpl productDao;
    Order order1;
    Order order2;
    Order order3;
    
    public productDaoImplTest() throws flooringMasteryPersistenceException {
       productDao = new productDaoImpl(); 
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readFromProductFile method, of class productDaoImpl.
     */
    @Test
    public void testReadFromProductFile() throws Exception {

        order1 = new Order();
        order1.setCustomerName("Bob");
        order1.setProductType("Books");
        order1.setState("OH");
        order1.setTaxRate(new BigDecimal("7.51"));
        order1.setCostPerSquareFoot(new BigDecimal("2.50"));
        order1.setLaborCost(new BigDecimal("3.00"));
        order1.setArea(new BigDecimal("3.00"));

        order2 = new Order();
        order1.setCustomerName("Bob");
        order1.setProductType("Books");
        order1.setState("OH");
        order1.setTaxRate(new BigDecimal("7.51"));
        order1.setCostPerSquareFoot(new BigDecimal("2.50"));
        order1.setLaborCost(new BigDecimal("3.00"));
        order1.setArea(new BigDecimal("4.00"));

        order3 = new Order();
        order1.setCustomerName("Bob");
        order1.setProductType("Books");
        order1.setState("OH");
        order1.setTaxRate(new BigDecimal("7.51"));
        order1.setCostPerSquareFoot(new BigDecimal("2.50"));
        order1.setLaborCost(new BigDecimal("3.00"));
        order1.setArea(new BigDecimal("5.00"));
               
    }
}
