package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Påfyldning {
    private double antalLiter;

    private LocalDate dato;

    private LocalDate påfyldningsDato;

    private double antalPåfyldteLiter;




    private final ArrayList<WhiskyMængde> whiskyMængdeArrayList = new ArrayList<>();

    private final ArrayList<Mængde> mængdeArrayList = new ArrayList<>();
    private Fad fad;


    public Påfyldning( LocalDate dato, Fad fad) {
        this.påfyldningsDato = dato;
        this.fad = fad;
    }

    @Override
    public String toString() {
        return "Påfyldning d. " + dato;
    }

    public void setAntalLiter(double antalLiter){
        for(Mængde mængde : mængdeArrayList){
            this.antalLiter += mængde.getVolumen();
            if (antalLiter >= fad.getFadstørrelse())
                fad.setFull();
        }
    }





    public LocalDate getDato() {
        return dato;
    }


    public ArrayList<Mængde> getMængdeArrayList() {
        return new ArrayList<>(mængdeArrayList);
    }

    public Mængde createMængde(double volume, Destillering destillering) {
        Mængde mængde = new Mængde(volume, this, destillering);
        mængdeArrayList.add(mængde);
        return mængde;
    }

    public void removeMængde(Mængde mængde) {
        if (mængdeArrayList.contains(mængde))
            mængdeArrayList.remove(mængde);
    }

    public double getAntalLiter() {
        return antalLiter;
    }

    public LocalDate getPåfyldningsDato() {
        return påfyldningsDato;
    }

    public double getAntalPåfyldteLiter() {
        return antalPåfyldteLiter;
    }

    public ArrayList<WhiskyMængde> getWhiskyMængdeArrayList() {
        return whiskyMængdeArrayList;
    }

    public Fad getFad() {
        return fad;
    }

    public void setFad(Fad fad) {
        if (this.fad != fad) {
            Fad oldFad = this.fad;
            if (oldFad != null)
                oldFad.removePåfyldning(this);
        }
        this.fad = fad;
        if (fad != null)
            fad.addPåfyldning(this);
    }

    public void addWhiskyMængde(WhiskyMængde whiskyMængde) {
        if (!whiskyMængdeArrayList.contains(whiskyMængde)) {
            whiskyMængdeArrayList.add(whiskyMængde);
            whiskyMængde.setPåfyldning(this);
        }
    }

    public void removeWhiskyMængde(WhiskyMængde whiskyMængde) {
        if (whiskyMængdeArrayList.contains(whiskyMængde)) {
            whiskyMængdeArrayList.remove(whiskyMængde);
            whiskyMængde.setPåfyldning(null);
        }
    }


    public double samletAntalLiter() {
        double total = 0;
        for(Mængde mængde : mængdeArrayList)
            total += mængde.getVolumen();

        return total;
    }

}





