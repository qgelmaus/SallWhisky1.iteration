package application.model;

import java.util.ArrayList;

public class Medarbejder {

    private String navn;
    private String id;

    private final ArrayList<Destillering> destilleringList = new ArrayList();

    public Medarbejder(String navn, String id){
        this.navn = navn;
        this.id = id;
    }

    public ArrayList<Destillering> getDestilleringList(){
        return new ArrayList<>(destilleringList);
    }

    public void addDestillering(Destillering destillering) {
        if(!destilleringList.contains(destillering)){
            destilleringList.add(destillering);
            destillering.addMedarbejder(this);
        }
    }

    public void removeDestillering(Destillering destillering){
        if(destilleringList.contains(destillering)){
            destilleringList.remove(destillering);
            destillering.removeMedarbejder(this);
        }

    }
    @Override
    public String toString() {
        return navn + "\nID: " + id;
    }

}
