package application.model;

import java.util.ArrayList;

public class Påfyldning {
    private double volume;
    private final ArrayList<Mængde> mængdeArrayList = new ArrayList<>();

    public Påfyldning(double volumen){
        this.volume = volumen;
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


}
