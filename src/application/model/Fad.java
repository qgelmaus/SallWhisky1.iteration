package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fad {

    private String fadType;

    private double fadstørrelse;

    private boolean isBlended;

    private int fadId;
    private LocalDate tappeDato;
    private String oprindelse;

    private final ArrayList<Påfyldning> påfyldningArrayList = new ArrayList<>();


    public Fad(String fadType, double fadstørrelse, boolean isBlended, int fadId, LocalDate tappeDato, String oprindelse) {
        this.fadType = fadType;
        this.fadstørrelse = fadstørrelse;
        this.isBlended = isBlended;
        this.fadId = fadId;
        this.tappeDato = tappeDato;
        this.oprindelse = oprindelse;
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

    public int getFadId() {
        return fadId;
    }

    public LocalDate getTappeDato() {
        return tappeDato;
    }

    public String getOprindelse() {
        return oprindelse;
    }

    public void setTappeDato(Påfyldning påfyldning){
        tappeDato = påfyldning.getDato().plusYears(3);
    }

    public ArrayList<Påfyldning> getPåfyldningArrayList(){
        return new ArrayList<Påfyldning>(påfyldningArrayList);
    }

    public void addPåfyldning(Påfyldning påfyldning){
        if(!påfyldningArrayList.contains(påfyldning)){
            påfyldningArrayList.add(påfyldning);
            påfyldning.setFad(this);
        }
    }

    public void removePåfyldning(Påfyldning påfyldning){
        if(påfyldningArrayList.contains(påfyldning)){
            påfyldningArrayList.remove(påfyldning);
            påfyldning.setFad(null);
        }
    }

    @Override
    public String toString() {
        return "Fad{" +
                "fadType='" + fadType + '\'' +
                ", fadstørrelse=" + fadstørrelse +
                ", isBlended=" + isBlended +
                ", fadId=" + fadId +
                ", tappeDato=" + tappeDato +
                ", oprindelse='" + oprindelse + '\'' +
                ", påfyldningArrayList=" + påfyldningArrayList +
                '}';
    }
}
