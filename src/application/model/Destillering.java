package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Destillering {

   private LocalDate startDato;
   private LocalDate slutDato;
   private double væskeMængde;
   private String rygeMateriale;
   private String kornSort;
   private String kommentar;

   private final ArrayList<Medarbejder> medarbejderList = new ArrayList<>();
   private final ArrayList<Mængde> mængdeArrayList = new ArrayList<>();




    //Constructor
    public Destillering(LocalDate startDato, LocalDate slutDato, double væskeMængde, String rygeMateriale, String kornSort, String kommentar){
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.væskeMængde = væskeMængde;
        this.rygeMateriale = rygeMateriale;
        this.kornSort = kornSort;
        this.kommentar = kommentar;
    }

    //Metoder
    public boolean dateChecker(LocalDate startDato, LocalDate slutDato){
        boolean isAfter = false;
        if(slutDato.isAfter(startDato)){
            isAfter = true;
        }
        return isAfter;
    }




    //Klassesammenhænge
    public ArrayList<Mængde> getMængdeArrayList(){
        return new ArrayList<>(mængdeArrayList);
    }

    public void addMængde(Mængde mængde){
        if(!mængdeArrayList.contains(mængde)){
            mængdeArrayList.add(mængde);
            mængde.setDestillering(this);
        }
    }

    public void removeMængde(Mængde mængde){
        if(mængdeArrayList.contains(mængde)){
            mængdeArrayList.remove(mængde);
            mængde.setDestillering(null);
        }
    }



    public ArrayList<Medarbejder> getMedarbejderList(){
        return new ArrayList<>(medarbejderList);
    }

    public void addMedarbejder(Medarbejder medarbejder){
        if(!medarbejderList.contains(medarbejder)){
            medarbejderList.add(medarbejder);
            medarbejder.addDestillering(this);
        }
    }

    public void removeMedarbejder(Medarbejder medarbejder){
        if(medarbejderList.contains(medarbejder)){
            medarbejderList.remove(medarbejder);
            medarbejder.removeDestillering(this);
        }
    }

    public String getKommentar(){
        return kommentar;
    }


    @Override
    public String toString() {
        return "Destillering: " +
                "\nStart: " + startDato +
                ", Slut: " + slutDato
                ;
    }






}
