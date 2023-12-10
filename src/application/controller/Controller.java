package application.controller;

import application.model.Destillering;
import application.model.Medarbejder;
import application.model.Mængde;
import application.model.Påfyldning;
import storage.Storage;

import java.time.LocalDate;

public class Controller {

    public Controller(){

    }

    public Medarbejder opretMedarbejder(String navn, String id){
        Medarbejder m = new Medarbejder(navn, id);
        Storage.getInstance().addMedarbejder(m);
        return m;
    }

    public static Destillering opretDestillering(LocalDate startDato, LocalDate slutDato, double væskeMængde, String rygeMateriale, String kornSort, String kommentar){
        Destillering d = new Destillering(startDato, slutDato, væskeMængde, rygeMateriale, kornSort, kommentar);
        Storage.getInstance().addDestillering(d);
        return d;
    }

    public static Påfyldning opretPåfyldning(double volume){
        Påfyldning p = new Påfyldning(volume);
        Storage.getInstance().addPåfyldning(p);
        return p;
    }

    public static Mængde opretMængde(double volume, Påfyldning påfyldning){
        Mængde m = new Mængde(volume, påfyldning);
        Storage.getInstance().addMængde(m);
        return m;
    }

    public void createSomeObjects(){
        opretDestillering(LocalDate.of(2023, 12, 9), LocalDate.of(2023, 12, 25), 300, "Birk", "Byg", "Første destillering");
    }



}
