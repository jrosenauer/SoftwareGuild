/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vendingmachine.dto.Fad;

/**
 *
 * @author apprentice
 */
public class VendingMachineDaoImplTest {
    
    VendingMachineDaoImpl daoTest = new VendingMachineDaoImpl();
    

    public VendingMachineDaoImplTest() {
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
     * Test of Read method, of class VendingMachineDaoImpl.
     */
    @Test
    public void testRead() throws Exception

    {
        ArrayList< Fad> test = daoTest.getAllItems();

        assertEquals(5, test.size());
    }
/*
    /**
     * Test of write method, of class VendingMachineDaoImpl.
     */
    /*
    @Test
    public void testWrite() throws Exception {
        System.out.println("write");
        ArrayList<Fad> commemorating = null;
        VendingMachineDaoImpl instance = new VendingMachineDaoImpl();
        instance.write(commemorating);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    */

}
