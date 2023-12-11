package application.controller;

import application.model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Controller {

    public Controller() {

    }

    public Medarbejder opretMedarbejder(String navn, String id){
        Medarbejder m = new Medarbejder(navn, id);
        Storage.getInstance().addMedarbejder(m);
        return m;
    }

   public static Destillering opretDestillering(LocalDate startDato, LocalDate slutDato, double væskeMængde, String rygeMateriale, String kornSort, String kommentar, String maltBatch){
        Destillering d = new Destillering(startDato, slutDato, væskeMængde, rygeMateriale, kornSort, kommentar, maltBatch);
        Storage.getInstance().addDestillering(d);
        return d;
    }

   public static Påfyldning opretPåfyldning( LocalDate dato, LocalDate påfyldningsDato, Fad fad){
        Påfyldning p = new Påfyldning( dato,  fad);
        Storage.getInstance().addPåfyldning(p);
        return p;
    }

    public static Påfyldning opretTomPåfyldning(){
        LocalDate dato = LocalDate.now();
        Påfyldning p = new Påfyldning( dato, null);
        Storage.getInstance().addPåfyldning(p);
        return p;
    }

    public static Mængde opretMængde(double volume, Påfyldning påfyldning, Destillering destillering){
        Mængde m = new Mængde(volume, påfyldning, destillering);
        Storage.getInstance().addMængde(m);
        return m;
    }

    public static Fad opretFad(String fadType, double fadstørrelse, boolean isBlended, String fadId, LocalDate tappeDato, String oprindelse){
        Fad f = new Fad(fadType, fadstørrelse, isBlended, fadId, tappeDato, oprindelse);
        Storage.getInstance().addFad(f);
        return f;
    }

    public static Reol opretReol(String reolId, Lager lager){
        Reol r = new Reol(reolId, lager);
        Storage.getInstance().addReol(r);
        return r;
    }

    public static Lager opretLager(String lagerId){
        Lager l = new Lager(lagerId);
        Storage.getInstance().addLager(l);
        return l;
    }

    public static WhiskyMængde opretWhiskyMængde(double liter, Whisky whisky){
        WhiskyMængde wm = new WhiskyMængde(liter, whisky);
        Storage.getInstance().addWhiskyMængde(wm);
        return wm;
    }

    public static Whisky opretWhisky(String navn, int nr, double procent, Påfyldning påfyldning, double tilsætningAfVand){
        Whisky w = new Whisky(navn, nr, procent, påfyldning, tilsætningAfVand);
        Storage.getInstance().addWhisky(w);
        return w;
    }

    public static void opretWhiskyMængdeTilWhisky(WhiskyMængde wm, Whisky w){
        w.addWhiskyMængde(wm);
    }

    public static void opretWhiskyTilWhiskyMængde(Whisky w, WhiskyMængde wm){
        wm.setWhisky(w);
    }

    public static void opretPåfyldningTilFad(Påfyldning p, Fad f){
        f.addPåfyldning(p);
    }



    public static void opretFadTilPåfyldning(Fad f, Påfyldning p){
        p.setFad(f);
    }

    public long tidPåFad(LocalDate påfyldningsDato, LocalDate tappeDato) {
        long tidPåFad = ChronoUnit.DAYS.between(påfyldningsDato, tappeDato);
        if (tidPåFad >= 1095) {
            System.out.println("Fadet er klar til tapning");
        } else {
            throw new RuntimeException("Fadet er ikke klar til tapning");
        }
        return tidPåFad;
    }
    public void createSomeObjects(){
        LocalDate dato = LocalDate.now();
        opretDestillering(LocalDate.of(2023,12,12), LocalDate.of(2023, 12, 23),150, "hø", "Byg", "Nice whisky bro", "Maltbatch1");
        opretFad("Sherry", 300, false, "1", LocalDate.of(2023, 12, 25), "Skotland");
        opretLager("Lager1");
        opretReol("Reol1", Storage.getInstance().getAllLagers().get(0));
        opretReol( "Reol2",  Storage.getInstance().getAllLagers().get(0));
        Fad f = opretFad("Eg", 280, false, "2", null,"USA");
        Fad f2 = opretFad("Ask", 280, false, "3", null, "Skotland");
        opretMedarbejder("Jens", "1");
        opretMedarbejder("Gustav", "2");
        opretMedarbejder( "Hans", "3");
        opretMedarbejder("Martin", "4");
        opretMedarbejder("Mads", "5");
        Påfyldning p = opretPåfyldning(dato, dato, f);
        Destillering d2 = opretDestillering(dato, LocalDate.of(2023, 12, 28), 150,"Halm", "Rug", "ikke så nice whisky bror", "maltBatch1");

        p.createMængde(50, d2);
        Destillering d = opretDestillering(dato, LocalDate.of(2023, 12, 28), 150,"Hø", "Byg", "Nice whisky bror", "maltBatch1");
        p.createMængde(50,d );
        f.addPåfyldning(p);

    }
}
