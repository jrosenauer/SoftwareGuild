/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    private Map<String, DVD> dvds = new HashMap<>();
    public static final String DVD_Library = "DVD_Library.txt";
    public static final String DELIMITER = "::";

    @Override
    public DVD addDVD(String title, DVD dvd) {
        DVD newDVD = dvds.put(title, dvd);
        writeList();
        return newDVD; // ID of new DVD and using put method to add
    }

    @Override
    public List<DVD> getAllDVDs() {
        loadList();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String title) {
        loadList();

        return dvds.get(title);

    }

    @Override
    public DVD removeDVD(String title) {
        DVD removedDVD = dvds.remove(title);
        writeList();
        return removedDVD;
    }

    /*@Override
    public DVD editDVDInformation(String title, String oldValue, String newValue) {
        loadList();:
        DVD newDVD = dvds.
        return newDVD;
     */
    private void loadList() {
        Scanner sc = null;

        try {
            sc = new Scanner(new BufferedReader(new FileReader(DVD_Library)));
        } catch (FileNotFoundException e) {
            System.out.print("No movie exists.");
        }
        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            DVD currentDVD = new DVD(currentTokens[0]);
            currentDVD.setDate(Integer.parseInt(currentTokens[1]));
            currentDVD.setMpaa(currentTokens[2]);
            currentDVD.setStudio(currentTokens[3]);
            currentDVD.setDirector(currentTokens[4]);
            currentDVD.setComment(currentTokens[5]);

            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        sc.close();

    }

    /*private void Search(String title) {
        Scanner sc = null;
        String input = "";

        /*try {
            sc = new Scanner(new BufferedReader(new FileReader(DVD_Library)));
           
        } catch (FileNotFoundException e) {
            System.out.print("No movie exists.");
        }
        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            DVD currentDVD = new DVD(currentTokens[0]);
            currentDVD.setDate(Integer.parseInt(currentTokens[1]));
            currentDVD.setMpaa(currentTokens[2]);
            currentDVD.setStudio(currentTokens[3]);
            currentDVD.setDirector(currentTokens[4]);
            currentDVD.setComment(currentTokens[5]);

        }
        sc.close();
        sc = new Scanner(DVD_Library);
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            if (input.contains(title)) {
                System.out.println(title + " exists.");
            } else {
                System.out.println("No movies exist.");
            }
        }

    }*/
    public String makeChange(String currentInfo, String infoField) {

        String input = "";

        System.out.println("Current " + infoField + ": " + currentInfo);
        if (input.length() < 1) {
            return currentInfo;
        } else {
            return input;
        }
    }

    public DVD editDVDInfo(DVD DVDToEdit) {
        DVD newDVD = dvds.put(DVDToEdit.getTitle(), DVDToEdit);
        writeList();
        //String title = DVDToEdit.getTitle();
        //int date = Integer.parseInt(makeChange(Integer.toString(DVDToEdit.getDate()), "Date"));
        //String mpaa = makeChange(DVDToEdit.getMpaa(), "MPAA Rating");
        //String director = makeChange(DVDToEdit.getDirector(), "Director");
        //String studio = makeChange(DVDToEdit.getStudio(), "Studio");
        //String comment = makeChange(DVDToEdit.getComment(), "Comments");
        //DVD updatedDVD = new DVD(title);
        //updatedDVD.setTitle(title);
        //updatedDVD.setDate(date);
        // updatedDVD.setMpaa(mpaa);
        //updatedDVD.setDirector(director);
        //updatedDVD.setStudio(studio);
        //updatedDVD.setComment(comment);
        return DVDToEdit;
    }

    @Override
    public DVD Search(String title) {
        for (DVD movies : getAllDVDs()) {
            if (title.equals(movies.getTitle())) {
                return movies;
            }
        }
        return null;
    }

    private void writeList() {

        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(DVD_Library));
        } catch (IOException e) {

        }

        List<DVD> dvdList = new ArrayList<DVD>(dvds.values());
        for (DVD currentDVD : dvdList) {
            //write student object to file
            out.print(currentDVD.getTitle() + DELIMITER
                    + currentDVD.getDate() + DELIMITER
                    + currentDVD.getMpaa() + DELIMITER
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getDirector() + DELIMITER
                    + currentDVD.getComment());
            out.flush();
        }
        //clean up
        out.close();
    }
}

/*
//check these
@Override
        public DVD addUpdatedDVD(DVD dvd) {
        DVD updatedDVD = dvds.put(dvd.getTitle(), dvd);
        writeList();
        return updatedDVD;
    }

    @Override
        public List<DVD> getAllDVDTitles() {
        loadList();
        return new ArrayList<>(dvds.values());
    }

    @Override
        public DVD editDVD(int dvdID) {
        loadList();
        return null;
    }*/
