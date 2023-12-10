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

    public static Destillering opretDestillering(LocalDate startDato, LocalDate slutDato, double væskeMængde, String rygeMateriale, String kornSort, String kommentar, String maltBatch){
        Destillering d = new Destillering(startDato, slutDato, væskeMængde, rygeMateriale, kornSort, kommentar, maltBatch);
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

    public static Reol opretReol(int antalFade, String reolId, Lager lager){
        Reol r = new Reol(reolId, antalFade, lager);
        Storage.getInstance().addReol(r);
        return r;
    }

    public static Lager opretLager(String lagerId, int samletAntalFade){
        Lager l = new Lager(lagerId, samletAntalFade);
        Storage.getInstance().addLager(l);
        return l;
    }

    public static WhiskyMængde opretWhiskyMængde(double liter, Whisky whisky, Påfyldning påfyldning){
        WhiskyMængde wm = new WhiskyMængde(liter, whisky, påfyldning);
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

    public void createSomeObjects(){
        opretDestillering(LocalDate.of(2023, 12, 9), LocalDate.of(2023, 12, 25), 300, "Birk", "Byg", "Første destillering", "MaltBatch1");
        opretFad("Sherry", 300, false, 1, LocalDate.of(2023, 12, 25), "Skotland", 300, null);
    }



}
