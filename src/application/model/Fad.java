package application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Fad {

    private String fadType;

    private double fadstørrelse;

    private boolean isBlended;

    private String fadId;
    private LocalDate tappeDato;
    private String oprindelse;
    private boolean isFull;
    private boolean isEmpty;

    private double antalPåfyldteLiter;

    private final ArrayList<Påfyldning> påfyldningArrayList = new ArrayList<>();

    private Reol reol;


    public Fad(String fadType, double fadstørrelse, boolean isBlended, String fadId, LocalDate tappeDato, String oprindelse) {
        this.fadType = fadType;
        this.fadstørrelse = fadstørrelse;
        this.fadId = fadId;
        this.tappeDato = tappeDato;
        this.oprindelse = oprindelse;
        this.antalPåfyldteLiter = 0;
        this.isEmpty = true;
        this.isFull = false;
    }

    public String getFadType() {
        return fadType;
    }

    public double getFadstørrelse() {
        return fadstørrelse;
    }

    public boolean isBlended() {
        return isBlended;
    }

    public void setEmpty(){
        this.isEmpty = true;
    }

    public void setFull(){
        this.isFull = true;
    }

    public int getFadId() {
        int id = 0;
        id++;
        return id;

    }



    public boolean getEmptyStatus(){
        boolean isEmpty = false;
        if(antalPåfyldteLiter > 0){
                isEmpty = false;
            }
        else
            isEmpty = true;
        return isEmpty;
    }

    public boolean getFullStatus(){
        boolean isFull = false;
        if(fadstørrelse - antalPåfyldteLiter <= 0 )
            isFull = true;
        return isFull;
    }

    public LocalDate getTappeDato() {
        return tappeDato;
    }

    public String getOprindelse() {
        return oprindelse;
    }

    public void setAntalPåfyldteLiter() {
        for(Påfyldning påfyldning : påfyldningArrayList){
            antalPåfyldteLiter += påfyldning.getAntalLiter();
        }
    }

    public double getAntalPåfyldteLiter(){
        return antalPåfyldteLiter;
    }

    public Reol getReol() {
        return reol;
    }

    public void setTappeDato(Påfyldning påfyldning) {
        tappeDato = påfyldning.getDato().plusYears(3);
    }

    public ArrayList<Påfyldning> getPåfyldningArrayList() {
        return new ArrayList<Påfyldning>(påfyldningArrayList);
    }

    public void addPåfyldning(Påfyldning påfyldning) {
        if (!påfyldningArrayList.contains(påfyldning) && !isFull) {
            påfyldningArrayList.add(påfyldning);
            påfyldning.setFad(this);
        }
        else if(isFull)
            throw new RuntimeException("Fadet er fuldt");

    }

    public void removePåfyldning(Påfyldning påfyldning) {
        if (påfyldningArrayList.contains(påfyldning)) {
            påfyldningArrayList.remove(påfyldning);
            påfyldning.setFad(null);
        }
    }

    public void setReol(Reol reol) {
        if (this.reol != reol) {
            Reol oldReol = this.reol;
            if (oldReol != null)
                oldReol.removeFad(this);
        }
        this.reol = reol;
        if (reol != null)
            reol.addFad(this);
    }

    @Override
    public String toString() {
        return "Fad: " + '\'' +
                "Type: " + fadType + '\'' +
                "Størresle: " + fadstørrelse + "L" +  '\'' +
                "Tilgængelig volumen: " + (fadstørrelse - antalPåfyldteLiter) + "L"
                ;
    }

}
