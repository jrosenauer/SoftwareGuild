/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DVDLibraryController {

    DVDLibraryView view; //= new DVDLibraryView();
    private UserIO io = new UserIOConsoleImpl();
    DVDLibraryDao dao; //= newUserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    createDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    editDVDInfo();
                    break;
                case 4:
                    listDVDs();
                    break;
                case 5:
                    viewDVD();
                    break;
                case 6:
                    Search();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndSelection();
    }

    private void createDVD() {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessDVDBanner();
    }

    private void listDVDs() {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void viewDVD() {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }

    private void removeDVD() {
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitleChoice();
        dao.removeDVD(title);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    public DVDLibraryController(DVDLibraryDao myDao, DVDLibraryView myView) {
        view = myView;
        dao = myDao;
    }

    private void editDVDInfo() {
        view.displayEditDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD movie = dao.Search(title);
        DVD dvd = view.editDVDInfo(movie);
        dao.editDVDInfo(dvd);
        view.displaySuccessEditedDVDBanner();
    }

    /*public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }/*

    /*private void editDVDInformation() {
        view.getAndEditInformationBanner();
        String Title = view.getDVDTitleChoice();
        DVD currentDVD = dao.getDVD(Title);
        view.displayDVD(DVD dvd);
        dao.editDVDInformation(currentDVD.getTitle(), currentDVD);
        view.displayDVD(currentDVD);*/
 /*private void searchToDisplay() {
        view.displaySearchBanner();
        listTitlesForReference();
        String title = view.getTitleToSearch();
        List<DVD> matches = new ArrayList<>();
        matches = service.getDVD(title);
        if (matches.size() >= 1) {
            for (DVD temp : matches) {
                view.displayDVDMatch(temp);
            }
        } else {
            view.displayNoMatchesFound();
        }
     
    }*/
    private DVD Search() {
        view.displaySearchBanner();
        String title = view.getTitleToSearch();
        DVD film = dao.Search(title);
        if (film != null) {
            view.displayMatchesFound();
            view.displayDVD(film);//after being replaced
        } else {
            view.displayNoMatchesFound();
        }
        return null;

    }
}
