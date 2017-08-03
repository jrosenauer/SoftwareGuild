/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.service;

import flooringMastery.dao.orderDaoImpl;
import flooringMastery.dto.Order;
import java.math.BigDecimal;
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
public class flooringMasteryServiceLayerImplTest {
    
    flooringMasteryServiceLayerImpl serviceTest = new flooringMasteryServiceLayerImpl();
    flooringMasteryServiceLayerImpl service = new flooringMasteryServiceLayerImpl();
    orderDaoImpl orderDao = new orderDaoImpl();
    
    Order order1;
    Order order2;
    Order order3;
    
    public flooringMasteryServiceLayerImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
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
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMaterialCosts method, of class flooringMasteryServiceLayerImpl.
     */
    
    @Test
    public void testGetMaterialCosts() throws Exception {
        
        BigDecimal materialCosts = service.getMaterialCosts(new BigDecimal("7.51"), new BigDecimal("7.00"));
                
        assertEquals(new BigDecimal("52.5700"), materialCosts);
        

    }
    
    
    /**
     * Test of getLaborCosts method, of class flooringMasteryServiceLayerImpl.
     */
    
    @Test
    public void testGetLaborCosts() throws Exception {
       
        BigDecimal laborCosts = service.getLaborCosts(new BigDecimal("8.00"), new BigDecimal("8.49"));
        
        assertEquals(new BigDecimal("67.9200"), laborCosts);
    }
    

    /**
     * Test of getTax method, of class flooringMasteryServiceLayerImpl.
     */
    
    @Test
    public void testGetTax() throws Exception {
        
        BigDecimal tax = service.getTax(new BigDecimal("5.32"), new BigDecimal("52.57"), new BigDecimal("67.92"));
        
        assertEquals(new BigDecimal("6.410068"), tax);
    }
    

    /**
     * Test of getTotal method, of class flooringMasteryServiceLayerImpl.
     */
    
    @Test
    public void testGetTotal() throws Exception {
        
        BigDecimal total = service.getTotal(new BigDecimal("6.41"), new BigDecimal("52.57"), new BigDecimal("67.92"));
        
        assertEquals(new BigDecimal("126.90"), total);
    }
    
    
}
