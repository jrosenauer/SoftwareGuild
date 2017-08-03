/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery2;

import flooringMastery.controller.flooringMasteryController;
import flooringMastery.dao.flooringMasteryPersistenceException;
import flooringMastery.service.invalidProductTypeException;
import flooringMastery.service.invalidStateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class Application {

    public static void main(String[] args) throws flooringMasteryPersistenceException, invalidStateException, invalidProductTypeException {
//      
//        flooringMasteryIO io = new flooringMasteryIOImpl();
//        flooringMasteryView view = new flooringMasteryView(io);
//        orderDao dao = new orderDaoImpl();
//        productDao product = new productDaoImpl();
//        taxDao tax = new taxDaoImpl();
//        flooringMasteryServiceLayer service = new flooringMasteryServiceLayerImpl(dao, product, tax);
//        flooringMasteryController controller = new flooringMasteryController(service, view);
//        controller.run();

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        flooringMasteryController controller
                = ctx.getBean("controller", flooringMasteryController.class);
        controller.run();
    }
}
