package application.model;

public class Mængde {

    private double volumen;
    private Destillering destillering;
    private Påfyldning påfyldning;



    public Mængde(double volumen, Påfyldning påfyldning){
        this.påfyldning = påfyldning;
        this.volumen = volumen;
    }

    public Påfyldning getPåfyldning(){
        return påfyldning;
    }

    public Destillering getDestillering(){
        return destillering;
    }

    public void setDestillering(Destillering destillering){
        if(this.destillering != destillering){
            Destillering oldDestillering = this.destillering;
            if(oldDestillering != null){
                oldDestillering.removeMængde(this);
            }
            this.destillering = destillering;
            if(destillering != null)
                destillering.addMængde(this);
        }
    }

}
