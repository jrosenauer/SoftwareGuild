/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vendingmachine.dao.VendingMachineDaoImpl;
import vendingmachine.dto.Change;
import vendingmachine.dto.Fad;

/**
 *
 * @author apprentice
 */
public class VendingMachineServiceLayerImplTest {

    VendingMachineDaoImpl daoImpl;

    VendingMachineDaoImpl daoTest = new VendingMachineDaoImpl();
    VendingMachineServiceLayerImpl serviceTest = new VendingMachineServiceLayerImpl(daoTest);

    public VendingMachineServiceLayerImplTest() {
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

    @Test
    public void testLeftoverMoney() throws Exception {

        ArrayList< Fad> UglyItem = serviceTest.getAllItems();

        Fad item = serviceTest.getItem(1);

        BigDecimal insertAmount = new BigDecimal("3.67");

        BigDecimal result = serviceTest.Change(item, 0, insertAmount);

        assertEquals(result, serviceTest.insertedAmount);

    }

    @Test
    public void testNumberOfCoins() throws Exception {

        BigDecimal balance = new BigDecimal("0.42");

        Change testChange = serviceTest.changeToCoins(balance);

        assertEquals(1, testChange.getQuarter());
        assertEquals(1, testChange.getDime());
        assertEquals(1, testChange.getNickel());
        assertEquals(2, testChange.getPenny());
    }

    @Test
    public void testSufficientFunds() throws Exception {

        String Fad = "";
        String Item = null;
        ArrayList UglyItem = new ArrayList<>();

        boolean testExceptionThrown = false;
        BigDecimal balance = new BigDecimal("3.67");

        Fad butterflyclip = new Fad("");

        butterflyclip.setItem("butterfly clips");
        butterflyclip.setInventory(14);
        butterflyclip.setPrice(new BigDecimal("3.67"));

        UglyItem.add(butterflyclip);

        try {
            serviceTest.sufficientFunds(UglyItem, 0, balance);
        } catch (InsufficientFundsException e) {
            testExceptionThrown = true;
        }

        assertEquals(false, testExceptionThrown);
    }

    @Test
    public void testItemInventory() throws NoItemInventoryException {

        ArrayList< Fad> UglyItem = serviceTest.getAllItems();

        try {
            serviceTest.ItemInventory(UglyItem, 0);
        } catch (NoItemInventoryException e) {
            fail("No item in inventory.");
        }

    }
}
