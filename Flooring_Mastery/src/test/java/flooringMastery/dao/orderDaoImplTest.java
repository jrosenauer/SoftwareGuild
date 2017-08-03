/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import flooringMastery.dto.Order;
import flooringMastery.service.flooringMasteryServiceLayerImpl;
import static java.lang.String.format;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class orderDaoImplTest {

    flooringMasteryServiceLayerImpl serviceTest;
    flooringMasteryServiceLayerImpl service;
    orderDaoImpl orderDao = new orderDaoImpl();
    Order order1;
    Order order2;
    Order order3;

    public orderDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dte = LocalDate.parse("02/07/2010", formatter);
        String formatted = dte.format(formatter);

        order1 = new Order();
        order1.setDate(dte);
        order1.setOrderNumber(1);
        order1.setCustomerName("Bob");
        order1.setProductType("Books");
        order1.setState("OH");
        order1.setTaxRate(new BigDecimal("7.51"));
        order1.setCostPerSquareFoot(new BigDecimal("2.50"));
        order1.setLaborCost(new BigDecimal("3.00"));
        order1.setArea(new BigDecimal("3.00"));

        order2 = new Order();
        order1.setDate(dte);
        order1.setOrderNumber(2);
        order1.setCustomerName("Bob");
        order1.setProductType("Books");
        order1.setState("OH");
        order1.setTaxRate(new BigDecimal("7.51"));
        order1.setCostPerSquareFoot(new BigDecimal("2.50"));
        order1.setLaborCost(new BigDecimal("3.00"));
        order1.setArea(new BigDecimal("4.00"));

        order3 = new Order();
        order1.setDate(dte);
        order1.setOrderNumber(3);
        order1.setCustomerName("Bob");
        order1.setProductType("Books");
        order1.setState("OH");
        order1.setTaxRate(new BigDecimal("7.51"));
        order1.setCostPerSquareFoot(new BigDecimal("2.50"));
        order1.setLaborCost(new BigDecimal("3.00"));
        order1.setArea(new BigDecimal("5.00"));
    }

    @After
    public void tearDown() throws Exception {
        
    }
/*
    @Test
    public void testAddOrder() throws Exception {
        Order order = orderDao.addOrder(order1);

        assertEquals(orderDao.getNumberOfOrders(order1.getDate()), 1);
    }
    */

    /*
    @Test
    public void testRemoveOrder() throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        LocalDate dte = LocalDate.parse("02072010", formatter);
        String formatted = dte.format(formatter);
        assertNotNull(order1);
        assertTrue(orderDao.getNumberOfOrders(order1.getDate()) == 0);
        orderDao.addOrder(order1);
        //orderDao.addOrder(order2);

        //orderDao.removeOrder(order1.getDate(), order1.getOrderNumber(), order1);
        //orderDao.removeOrder(order2.getDate(), order2.getOrderNumber(), order1);
        //Order order1test = orderDao.getOrder(LocalDate.MAX, 1);
        //Order order2test = orderDao.getOrder(LocalDate.MAX, 1);
        //assertEquals(null, order1test);
        //assertEquals(null, order2test);
        //orderDao.removeOrder(LocalDate.parse("12/05/1989"), 4, order1);
        orderDao.removeOrder(order1.getDate(), order1.getOrderNumber());
        assertEquals(orderDao.getNumberOfOrders(order1.getDate()), 1);
    }
    */

    /*
    @Test
    public void testEditOrder() throws flooringMasteryPersistenceException {

        orderDao.editOrder(order1);
        assertNotSame(order1, order2);
    }
     */
    /**
     * Test of getOrders method, of class orderDaoImpl.
     */
    /*
    @Test
    public void testGetOrders() throws flooringMasteryPersistenceException {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy");
        LocalDate dte = LocalDate.parse("02/07/2010", formatter);
        String formatted = dte.format(formatter);
        
        orderDao.addOrder(order1);
        HashMap< Integer, Order> = orderDao.getOrders(LocalDate.parse("06/01/2013", formatter));

        assertEquals(order1, order1);
        
    }
    */
     
    /**
     * Test of writeToOrder method, of class orderDaoImpl.
     */
    /*
    @Test
    public void testWriteToOrder() throws Exception {

        orderDao.writeToOrder();
        //orderDao.getOrder(order1.getDate(), order1.getOrderNumber());
        
        Order testOrder = orderDao.getOrders(order1.getDate(), order1.getOrderNumber());
        assertEquals(order1, testOrder);
    }
    */
     
    /**
     * Test of getOrder method, of class orderDaoImpl.
     */
    /*
    @Test
    public void testGetOrder() throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy");
        LocalDate dte = LocalDate.parse("02/07/2010", formatter);
        String formatted = dte.format(formatter);

        orderDao.addOrder(order1);
        List<Order> test = orderDao.getOrders(LocalDate.parse("06/01/2013", formatter));

        assertEquals(order1, order1);
*/
    }
     

