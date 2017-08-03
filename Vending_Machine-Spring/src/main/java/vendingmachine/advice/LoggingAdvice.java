/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.advice;

import java.math.BigDecimal;
import org.aspectj.lang.JoinPoint;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachinePersistenceException;

/**
 *
 * @author apprentice
 */
public class LoggingAdvice {

    VendingMachineAuditDao auditDao;

    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void createAuditEntry(JoinPoint jp, Exception ex) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachinePersistenceException e) {
            System.err.println("ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
/*
    public void createAuditEntryInsufficientFunds(JoinPoint jp) {
        Object[] amount = jp.getArgs();
        Item purchased = jp.getArgs();
        String entry = jp.getSignature().getName() + "threw an insufficient funds exception.";
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachinePersistenceException e) {
            System.err.println("ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

    public void createAuditEntryPersistenceException(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + "Persistence Exception thrown.";
        for (Object currentArg : args) {
            auditEntry += currentArg;
            try {
                auditDao.writeAuditEntry(auditEntry);
            } catch (VendingMachinePersistenceException e) {
                System.err.println("ERROR: Could not create audit entry in LoggingAdvice.");
            }
        }
    }
*/
}
