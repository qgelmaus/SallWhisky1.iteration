package application.model;

import java.util.ArrayList;
import java.util.List;

public class Reol {
    private String reolId;

    private int antalFade;

    private final List<Fad> fadArrayList = new ArrayList<>();

    private Lager lager;

    @Override
    public String toString() {
        return "Reol-" + reolId +
                " Antal fade: " + antalFade +
                ", Lokation: " + lager;
    }

    public Reol(String reolId, Lager lager) {
        this.reolId = reolId;
        this.lager = lager;
    }

    public String getReolId() {
        return reolId;
    }

    public int getAntalFade() {
        return antalFade;
    }

    public void setAntalFade(){
        this.antalFade = fadArrayList.size();
    }

    public ArrayList<Fad> getFadArrayList() {
        return new ArrayList<>(fadArrayList);
    }

    public Lager getLager() {
        return lager;
    }

    public void addFad(Fad fad){
        if(!fadArrayList.contains(fad)){
            fadArrayList.add(fad);
            fad.setReol(this);
        }
    }

    public void removeFad(Fad fad){
        if(fadArrayList.contains(fad)){
            fadArrayList.remove(fad);
            fad.setReol(null);
        }
    }

    public void setReolId(String reolId) {
        this.reolId = reolId;
    }

    public void setAntalFade(int antalFade) {
        this.antalFade = antalFade;
    }

    public void setFadArrayList(ArrayList<Fad> fadArrayList) {
        this.fadArrayList.clear();
        this.fadArrayList.addAll(fadArrayList);
    }

    public void setLager(Lager lager) {
        this.lager = lager;
    }
}
