/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import flooringMastery.dto.Order;
import flooringMastery.dto.Tax;
import flooringMastery.service.flooringMasteryServiceLayerImpl;
import java.math.BigDecimal;
import java.util.Map;
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
public class taxDaoImplTest {

    flooringMasteryServiceLayerImpl serviceTest;
    flooringMasteryServiceLayerImpl service;
    orderDaoImpl orderDao;
    orderDaoImpl orderTest = new orderDaoImpl();
    taxDaoImpl taxDaoTest = new taxDaoImpl();
    //taxDaoImpl taxTest = new taxTest();
    Order order1;
    Order order2;
    Order order3;

    public taxDaoImplTest() throws flooringMasteryPersistenceException {
         taxDaoTest = new taxDaoImpl();
         //taxTest = new taxTest();
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

   /*
    @Test
    public void testReadFromTaxFile() throws Exception {
        taxDaoTest.readFromTaxFile();

        assertEquals("OH", "3.51");
    }
*/



}
