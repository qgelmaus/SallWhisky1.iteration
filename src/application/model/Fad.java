package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fad {
    private double størrelse;
    private String type;
    private LocalDate tappeDato;
    private String oprindelse;

    private final ArrayList<Påfyldning> påfyldningArrayList = new ArrayList<>();

    public Fad(double størrelse, String type, String oprindelse){
        this.størrelse = størrelse;
        this.type = type;
        this.oprindelse = oprindelse;
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
                "størrelse=" + størrelse +
                ", type='" + type + '\'' +
                ", tappeDato=" + tappeDato +
                ", oprindelse='" + oprindelse + '\'' +
                ", påfyldningArrayList=" + påfyldningArrayList +
                '}';
    }
}
