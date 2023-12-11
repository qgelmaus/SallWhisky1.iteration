package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Destillering {

   private LocalDate startDato;
   private LocalDate slutDato;
   private double væskeMængde;
   private String rygeMateriale;
   private String kornSort;
   private String bemærkning;
   private String maltBatch;
   private double leftOverVæske;
   private boolean isEmpty;

   private final ArrayList<Medarbejder> medarbejderList = new ArrayList<>();
   private final ArrayList<Mængde> mængdeArrayList = new ArrayList<>();




    //Constructor
    public Destillering(LocalDate startDato, LocalDate slutDato, double væskeMængde, String rygeMateriale, String kornSort, String bemærkning, String maltBatch){
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.væskeMængde = væskeMængde;
        this.rygeMateriale = rygeMateriale;
        this.kornSort = kornSort;
        this.bemærkning = bemærkning;
        this.maltBatch = maltBatch;
    }

    //Metoder
    public boolean dateChecker(LocalDate startDato, LocalDate slutDato){
        boolean isAfter = false;
        if(slutDato.isAfter(startDato)){
            isAfter = true;
        }
        return isAfter;
    }


    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public double getVæskeMængde() {
        return væskeMængde;
    }

    public String getRygeMateriale() {
        return rygeMateriale;
    }

    public String getKornSort() {
        return kornSort;
    }
    public String getMaltBatch() {
        return maltBatch;
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

    public void setLeftOverVæske(){
        leftOverVæske = væskeMængde;
        for(Mængde mængde : mængdeArrayList){
            leftOverVæske -= mængde.getVolumen();
        }
    }

    public void setEmpty(){
        if (leftOverVæske < 0)
            this.isEmpty = true;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    public String getBemærkning(){
        return bemærkning;
    }


    @Override
    public String toString() {
        return "Destillering{" +
                "Start: " + startDato +
                ", Slut: " + slutDato +
                ", Væske: " + væskeMængde +
                ", Røg: '" + rygeMateriale + '\'' +
                ", Korn: " + kornSort + '\''
                ;
    }






}
