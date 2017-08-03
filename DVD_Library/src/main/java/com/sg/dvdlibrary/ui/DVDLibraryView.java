/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DVDLibraryView {

    private UserIO io;

    public int printMenuAndSelection() {
        io.print("Main Menu");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD Information");
        io.print("4. List DVDs");
        io.print("5. Display DVD Information");
        io.print("6. Search for DVD");
        io.print("7. Exit");

        return io.readInt("Please select from the following:", 1, 7);
    }

    //check
    public String makeChange(String currentInfo, String infoField) {

        io.print("Current " + infoField + ": " + currentInfo);
        String input = io.readString(infoField);
        if (input.length() < 1) {
            return currentInfo;
        } else {
            return input;

        }
    }

    //check
    /*
    public DVD editDVDInfo(DVD DVDToEdit) {
        String title = DVDToEdit.getTitle();
        int date = Integer.parseInt((DVDToEdit.getDate()));
        String mpaa = makeChange(DVDToEdit.getMpaa(), "MPAA Rating");
        String director = makeChange(DVDToEdit.getDirector(), "Director");
        String studio = makeChange(DVDToEdit.getStudio(), "Studio");
        String comment = makeChange(DVDToEdit.getComment(), "Comments");
        DVD updatedDVD = new DVD(title);
        updatedDVD.setTitle(title);
        updatedDVD.setDate(date);
        updatedDVD.setMpaa(mpaa);
        updatedDVD.setDirector(director);
        updatedDVD.setStudio(studio);
        updatedDVD.setComment(comment);
        return updatedDVD;   
    }
    
        public DVD getAndEditInformationBanner() {
        io.print("=== Edit DVDs ===");
        return null;
    }
    
     */
    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter title name");
        int date = io.readInt("Please enter release date");
        String mpaa = io.readString("Please enter MPAA rating");
        String director = io.readString("Please enter director's name");
        String studio = io.readString("Please enter studio name");
        String comment = io.readString("Please enter enter any additional comments");
        DVD currentDVD = new DVD(title);
        currentDVD.setTitle(title);
        currentDVD.setDate(date);
        currentDVD.setMpaa(mpaa);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setComment(comment);
        return currentDVD;
    }

    public void displaySearchBanner() {
        io.print("=== Search for DVD ===");
    }

    public void displayNoMatchesFound() {
        io.print("No title is on record.");
    }
    
    public void displayMatchesFound() {
        io.print("DVD is on record.");
    }

    public void displayEditDVDBanner() {
        io.print("=== Edit existing DVD ===");
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displaySuccessEditedDVDBanner() {
        io.print("DVD successfully edited. Please hit enter to continue");
    }

    public void displayCreateSuccessDVDBanner() {
        io.print("DVD added successfully. Plese hit enter to continue");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            io.print(currentDVD.getTitle() + ": "
                    + currentDVD.getDate() + " "
                    + currentDVD.getMpaa() + " "
                    + currentDVD.getDirector() + " "
                    + currentDVD.getStudio() + " "
                    + currentDVD.getComment());
        }
        io.readString("Please hit enter to continue");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }

    public String getDVDTitleChoice() {
        return io.readString("Please enter the title");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(Integer.toString(dvd.getDate()));
            io.print(dvd.getMpaa());
            io.print(dvd.getDirector());
            io.print(dvd.getStudio());
            io.print(dvd.getComment());
            io.print(" ");
        } else {
            io.print("No such DVD");
        }
        io.readString("Please hit enter to continue");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Remove Student ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("DVD successfully removed. Please hit enter to continue");
    }

    public void displayExitBanner() {
        io.readString("Goodbye");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
    }

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    /*public DVD getAndEditDVD(String title, DVD currentDVD) {
        DVD edited = currentDVD;
        boolean keepLooping = true;

        if (currentDVD != null) {
            do {
                String actions = io.readString("What would you like to edit?"
                        + "\n 1. Director's Name"
                        + "\n 2. Release Date"
                        + "\n 3. MPAA Rating"
                        + "\n 4. Studio Name"
                        + "\n 5. Title"
                        + "\n 6. Additional Comments"
                        + "\n 7. Exit");
                if (actions.equals(1)) {
                    io.print("The current director's name is " + currentDVD.getDirector());
                    String Director = io.readString("Enter new director");
                    edited.setDirector(Director);
                } else if (actions.equals(3)) {
                    io.print("The rating is " + currentDVD.getMpaa());
                    String Mpaa = io.readString("Enter new rating");
                    edited.setDirector(Mpaa);
                } else if (actions.equals(2)) {
                    io.print("The release date is " + currentDVD.getDate());
                    String Date = io.readString("Enter new release date");
                    edited.setDate(Integer.parseInt(Date));
                } else if (actions.equals(4)) {
                    io.print("The studio name is " + currentDVD.getStudio());
                    String Studio = io.readString("Enter new studio");
                    edited.setStudio(Studio);
                } else if (actions.equals(5)) {
                    io.print("The title is " + currentDVD.getTitle());
                    String Title = io.readString("Enter new title");
                    edited.setTitle(Title);
                } else if (actions.equals(6)) {
                    io.print("The comment(s) is/are " + currentDVD.getComment());
                    String Comment = io.readString("Enter new comment");
                    edited.setComment(Comment);
                } else if (actions.equals(7)) {
                    System.out.println("Goodbye");
                }
            } while (keepLooping);
        }
        return edited;
    }
    public void displayEditedDVDSuccessBanner() {
        io.print("You have successfully edited your DVD");*/
    public void displayTitleList(List<String> titleList) {
        io.print(" === Here is a list of all titles on file ===");
        for (String currentTitle : titleList) {

        }
    }

    public String getTitleToSearch() {
        String title = io.readString("Please give a title from the list above.");
        return title;
    }

    public DVD editDVDInfo(DVD DVDToEdit) {

        String title = DVDToEdit.getTitle();
        int date = Integer.parseInt(makeChange(Integer.toString(DVDToEdit.getDate()), "Date"));
        String mpaa = makeChange(DVDToEdit.getMpaa(), "MPAA Rating");

        String director = makeChange(DVDToEdit.getDirector(), "Director");
        String studio = makeChange(DVDToEdit.getStudio(), "Studio");
        String comment = makeChange(DVDToEdit.getComment(), "Comments");
        DVD newDVD = new DVD();
        newDVD.setTitle(title);
        newDVD.setDate(date);
        newDVD.setMpaa(mpaa);
        newDVD.setDirector(director);
        newDVD.setStudio(studio);
        newDVD.setComment(comment);

        return newDVD;
    }
}
