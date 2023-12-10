package storage;

import application.model.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private static Storage instance = new Storage();

    private List<Medarbejder> medarbejders = new ArrayList<>();
    private List<Destillering> destillerings  = new ArrayList<>();
    private List<Påfyldning> påfyldnings = new ArrayList<>();
    private List<Mængde> mængdes = new ArrayList<>();
    private List<Fad> fads = new ArrayList<>();

    private List<Reol> reols = new ArrayList<>();

    private List<WhiskyMængde> whiskyMængdes = new ArrayList<>();

    private List<Whisky> whiskys = new ArrayList<>();

    private List<Lager> lagers = new ArrayList<>();


    private Storage(){

    }

    public static Storage getInstance(){
        if(instance == null){
            instance = new Storage();
        }
        return instance;
    }


    //Medarbejdere
    public List<Medarbejder> getAllMedarbejders() {
        return new ArrayList<>(medarbejders);
    }

    public void addMedarbejder(Medarbejder m) {
        if (!medarbejders.contains(m) && m != null)
            medarbejders.add(m);
    }

    //Destilleringer
    public List<Destillering> getAllDestillerings() {
        return new ArrayList<Destillering>(destillerings);
    }

    public void addDestillering(Destillering destillering) {
        if (!destillerings.contains(destillering))
            destillerings.add(destillering);

    }

    //Mængde
    public List<Mængde> getAllMængder(){return new ArrayList<Mængde>(mængdes);}

    public void addMængde(Mængde mængde){
        if(!mængdes.contains(mængde))
            mængdes.add(mængde);
    }

    // Påfyldninger
    public List<Påfyldning> getAllPåfyldning(){return new ArrayList<Påfyldning>(påfyldnings);}
    public void addPåfyldning(Påfyldning påfyldning){
        if(!påfyldnings.contains(påfyldning))
            påfyldnings.add(påfyldning);
    }

    public List<Fad> getAllFads(){return new ArrayList<>(fads);}
    public void addFad(Fad fad){
        if(!fads.contains(fad))
            fads.add(fad);
    }


    public List<Reol> getAllReols(){return new ArrayList<>(reols);}

    public void addReol(Reol r){
        if(!reols.contains(r))
            reols.add(r);
    }

    public List<WhiskyMængde> getAllWhiskyMængdes(){return new ArrayList<>(whiskyMængdes);}

    public void addWhiskyMængde(WhiskyMængde wm){
        if(!whiskyMængdes.contains(wm))
            whiskyMængdes.add(wm);
    }

    public List<Whisky> getAllWhiskys(){return new ArrayList<>(whiskys);}

    public void addWhisky(Whisky w){
        if(!whiskys.contains(w))
            whiskys.add(w);
    }

    public List<Lager> getAllLagers(){return new ArrayList<>(lagers);}

    public void addLager(Lager l){
        if(!lagers.contains(l))
            lagers.add(l);
    }




    public void initStorage(){


    }
}
