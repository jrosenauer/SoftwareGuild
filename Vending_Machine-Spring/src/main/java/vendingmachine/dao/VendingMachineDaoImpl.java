/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import vendingmachine.dto.Fad;

/**
 *
 * @author apprentice
 */
public class VendingMachineDaoImpl implements VendingMachineDao {

    public static final String Fad_90s = "Fad_90s.txt";
    public static final String DELIMITER = "::";

    ArrayList< Fad> items = new ArrayList();

    private ArrayList< Fad> Read() throws VendingMachinePersistenceException {

        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(Fad_90s)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("Could not load vending machine menu.", e);
        }

        String currentLine;
        String[] currentTokens;
        items = new ArrayList();

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Fad currentFad = new Fad(currentTokens[0]);
            currentFad.setPrice(new BigDecimal(currentTokens[1]));
            currentFad.setInventory(Integer.parseInt(currentTokens[2]));
            items.add(currentFad);
        }
        return items;
    }

    private void write(ArrayList< Fad> commemorating) throws VendingMachinePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(Fad_90s));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not save ugly 90s fads :)", e);
        }

        for (Fad currentFad : commemorating) {
            out.println(currentFad.getItem() + DELIMITER
                    + currentFad.getPrice() + DELIMITER
                    + currentFad.getInventory());
            out.flush();
        }
        out.close();
    }

    @Override
    public ArrayList<Fad> getAllItems() throws VendingMachinePersistenceException {
        return Read();
    }

    @Override
    public void updateInventory(int Index) throws VendingMachinePersistenceException {
        getAllItems();
        int inventory = items.get(Index).getInventory();
        inventory -= 1;
        items.get(Index).setInventory(inventory);
        write(items);
    }

    @Override
    public Fad getItem(int Selection) throws VendingMachinePersistenceException {
        return items.get(Selection);
    }

}
