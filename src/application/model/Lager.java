package application.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Lager {
    private String lokation;

    private int samletAntalFade;

    private final List<Reol> reolArrayList = new ArrayList<>();


    public Lager(String lokation) {
        this.lokation = lokation;
    }

    public String getLokation() {
        return lokation;
    }

    public int getSamletAntalFade() {
        return samletAntalFade;
    }

    public void setSamletAntalFade(){
        int totalFade = 0;
        for (Reol reol : getReolArrayList()){
            reol.setAntalFade();
            totalFade += reol.getAntalFade();
        }

        this.samletAntalFade = totalFade;
    }

    public ArrayList<Reol> getReolArrayList(){
        return new ArrayList<>(reolArrayList);
    }

    @Override
    public String toString(){
        return lokation;
    }



}
