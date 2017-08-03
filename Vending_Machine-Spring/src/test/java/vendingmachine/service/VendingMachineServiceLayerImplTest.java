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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vendingmachine.dao.VendingMachineDaoImpl;
import vendingmachine.dto.Change;
import vendingmachine.dto.Fad;

/**
 *
 * @author apprentice
 */
public class VendingMachineServiceLayerImplTest {

    VendingMachineDaoImpl daoImpl;

    VendingMachineServiceLayer service;

    VendingMachineDaoImpl daoTest = new VendingMachineDaoImpl();
    VendingMachineServiceLayerImpl serviceTest = new VendingMachineServiceLayerImpl(daoTest);

    public VendingMachineServiceLayerImplTest() {

//        VendingMachineDao dao = new VendingMachineDaoStubImpl();
//        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
// 
//        service = new VendingMachineServiceLayerImpl(dao, auditDao);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("serviceLayer", VendingMachineServiceLayer.class);
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
     * Test of getAllItems method, of class VendingMachineServiceLayerImpl.
     *
     */
    /*
    @Test
    public void testGetAllItems() {
        System.out.println("getAllItems");
        VendingMachineServiceLayerImpl instance = new VendingMachineServiceLayerImpl();
        ArrayList<Fad> expResult = null;
        ArrayList<Fad> result = instance.Read();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        f
     */

 /*
     * Test of Write method, of class VendingMachineServiceLayerImpl.
     *
     */
 /*
    @Test
    public void testWrite() throws Exception {
        System.out.println("Write");
        ArrayList<Fad> Commemorating = null;
        VendingMachineServiceLayerImpl instance = new VendingMachineServiceLayerImpl();
        instance.Write(Commemorating);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     */

 /*
     * Test of LeftoverMoney method, of class VendingMachineServiceLayerImpl.
     *
     */
    @Test
    public void testLeftoverMoney() throws Exception {

        ArrayList< Fad> UglyItem = serviceTest.getAllItems();

        Fad item = serviceTest.getItem(1);

        BigDecimal insertAmount = new BigDecimal("3.67");

        BigDecimal result = serviceTest.Change(item, 0, insertAmount);

        assertEquals(result, serviceTest.insertedAmount);

    }

    /*
     * Test of numberOfCoins method, of class VendingMachineServiceLayerImpl.
     *
     */
    @Test
    public void testNumberOfCoins() throws Exception {

        BigDecimal balance = new BigDecimal("0.42");

        Change testChange = serviceTest.changeToCoins(balance);

        assertEquals(1, testChange.getQuarter());
        assertEquals(1, testChange.getDime());
        assertEquals(1, testChange.getNickel());
        assertEquals(2, testChange.getPenny());
    }

    /*
     * Test of sufficientFunds method, of class VendingMachineServiceLayerImpl.
     */
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

    /*r
     * Test of updateInventory method, of class VendingMachineServiceLayerImpl.
     *
     */
 /*
    @Test
    public void testUpdateInventory() throws Exception { //YES
        System.out.println("updateInventory");
        ArrayList<Fad> UglyItem = null;
        int Inventory = 0;
        VendingMachineServiceLayerImpl instance = new VendingMachineServiceLayerImpl();
        instance.updateInventory(UglyItem, Inventory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     */

 /*
     * Test of ItemInventory method, of class VendingMachineServiceLayerImpl.
     *
     */
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
