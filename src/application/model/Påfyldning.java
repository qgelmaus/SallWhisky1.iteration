package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Påfyldning {
    private double volume;
    private LocalDate dato;
    private final ArrayList<Mængde> mængdeArrayList = new ArrayList<>();
    private Fad fad;
    public Påfyldning(double volumen){
        this.volume = volumen;
        this.dato = LocalDate.now();
    }

    public LocalDate getDato(){
        return dato;
    }

    public ArrayList<Mængde> getMængdeArrayList(){
        return new ArrayList<>(mængdeArrayList);
    }

    public Mængde createMængde(double volume){
        Mængde mængde = new Mængde(volume, this);
        mængdeArrayList.add(mængde);
        return mængde;
    }

    public void removeMængde(Mængde mængde){
        if(mængdeArrayList.contains(mængde))
            mængdeArrayList.remove(mængde);
    }

    public double getVolumen(){
        return volume;
    }

    public void setFad(Fad fad){
        if(this.fad != fad) {
            Fad oldFad = this.fad;
            if (oldFad != null)
                oldFad.removePåfyldning(this);
        }
        this.fad = fad;
        if(fad != null)
            fad.addPåfyldning(this);
        }
    }


