package application.controller;

import application.model.*;
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

    public static Påfyldning opretPåfyldning(double antalLiter, LocalDate dato, LocalDate påfyldningsDato, double antalPåfyldteLiter, boolean isWhisky, Fad fad){
        Påfyldning p = new Påfyldning( antalLiter,  dato, isWhisky,  fad);
        Storage.getInstance().addPåfyldning(p);
        return p;
    }

    public static Mængde opretMængde(double volume, Påfyldning påfyldning){
        Mængde m = new Mængde(volume, påfyldning);
        Storage.getInstance().addMængde(m);
        return m;
    }

    public static Fad opretFad(String fadType, double fadstørrelse, boolean isBlended, int fadId, LocalDate tappeDato, String oprindelse, double antalPåfyldteLiter, Reol reol){
        Fad f = new Fad(fadType, fadstørrelse, isBlended, fadId, tappeDato, oprindelse, antalPåfyldteLiter, reol);
        Storage.getInstance().addFad(f);
        return f;
    }

    public void createSomeObjects(){
        opretDestillering(LocalDate.of(2023, 12, 9), LocalDate.of(2023, 12, 25), 300, "Birk", "Byg", "Første destillering");
        opretFad("Eg", 180, true,1, LocalDate.of(2024, 12, 12), "Skotland");
    }



}
