/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vendingmachine.controller.VendingMachineController;

/**
 *
 * @author apprentice
 */
public class Application {

    public static void main(String[] args) {

//        VendingMachineIO myIO = new VendingMachineIOImpl();
//        VendingMachineView io = new VendingMachineView(myIO);
//        VendingMachineDao myDao = new VendingMachineDaoImpl();
//        VendingMachineAuditDaoFileImpl myAuditDao = new VendingMachineAuditDaoFileImpl();
//        VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(myDao);
//        VendingMachineController controller = new VendingMachineController(service, io);
//        controller.run();
        

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
        controller.run();

    }
}
