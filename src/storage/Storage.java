package storage;

import application.model.Destillering;
import application.model.Medarbejder;
import application.model.Mængde;
import application.model.Påfyldning;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private static Storage instance = new Storage();

    private List<Medarbejder> medarbejders = new ArrayList<>();
    private List<Destillering> destillerings  = new ArrayList<>();
    private List<Påfyldning> påfyldnings = new ArrayList<>();
    private List<Mængde> mængdes = new ArrayList<>();


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



    public void initStorage(){

    }



}
