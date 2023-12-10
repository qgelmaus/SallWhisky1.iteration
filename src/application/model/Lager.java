package application.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Lager {
    private String lokation;

    private int samletAntalFade;

    private final ArrayList<Reol> reolArrayList = new ArrayList<>();


    public Lager(String lokation, int samletAntalFade) {
        this.lokation = lokation;
        this.samletAntalFade = samletAntalFade;
    }

    public String getLokation() {
        return lokation;
    }

    public int getSamletAntalFade() {
        return samletAntalFade;
    }



}
