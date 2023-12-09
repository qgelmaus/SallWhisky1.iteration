package storage;

import application.model.Destillering;
import application.model.Medarbejder;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private static Storage instance = new Storage();

    private List<Medarbejder> medarbejders = new ArrayList<>();
    private List<Destillering> destillerings  = new ArrayList<>();


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

    public void initStorage(){

    }



}
