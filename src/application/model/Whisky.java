package application.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Whisky {


    private String navn;

    private int nr;

    private double procent;

    Påfyldning påfyldning;

    private double tilsætningAfVand;

    private final ArrayList<WhiskyMængde> whiskyMængdeArrayList = new ArrayList<>();

public Whisky(String navn, int nr, double procent, Påfyldning påfyldning, double tilsætningAfVand){
        this.navn = navn;
        this.nr = nr;
        this.procent = procent;
        this.påfyldning = påfyldning;
        this.tilsætningAfVand = tilsætningAfVand;
    }

    public String getNavn() {
        return navn;
    }

    public int getNr() {
        return nr;
    }

    public double getProcent() {
        return procent;
    }

    public Påfyldning getPåfyldning() {
        return påfyldning;
    }

    public double getTilsætningAfVand() {
        return tilsætningAfVand;
    }

    public ArrayList<WhiskyMængde> getWhiskyMængdeArrayList() {
        return whiskyMængdeArrayList;
    }



    public WhiskyMængde createWhiskyMængde(double liter, Whisky whisky){
        WhiskyMængde whiskyMængde = new WhiskyMængde(liter, this);
        whiskyMængdeArrayList.add(whiskyMængde);
        return whiskyMængde;
    }

    public void removeWhiskyMængde(WhiskyMængde whiskyMængde){
        if(whiskyMængdeArrayList.contains(whiskyMængde))
            whiskyMængdeArrayList.remove(whiskyMængde);
    }

    public void addWhiskyMængde(WhiskyMængde wm) {
        if(!whiskyMængdeArrayList.contains(wm))
            whiskyMængdeArrayList.add(wm);
    }

    @Override
    public String toString() {
        return  "navn: " + navn + '\'' +
                ", nr: " + nr +
                ", VOL: " + procent +
                ", Vand: " + tilsætningAfVand;
    }
}
