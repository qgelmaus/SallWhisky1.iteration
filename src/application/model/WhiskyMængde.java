package application.model;

public class WhiskyMængde {

    // Person
    private double liter;

    private Whisky whisky;

    private Påfyldning påfyldning;

    public WhiskyMængde(double liter, Whisky whisky, Påfyldning påfyldning) {
        this.liter = liter;
        this.whisky = whisky;
        this.påfyldning = påfyldning;
    }

    public double getLiter() {
        return liter;
    }

    public Whisky getWhisky() {
        return whisky;
    }

    public Påfyldning getPåfyldning() {
        return påfyldning;
    }



    public void setPåfyldning(Påfyldning påfyldning) {
        if(this.påfyldning != påfyldning){
            Påfyldning oldPåfyldning = this.påfyldning;
            if(oldPåfyldning != null){
                oldPåfyldning.removeWhiskyMængde(this);
            }
            this.påfyldning = påfyldning;
            if(påfyldning != null)
                påfyldning.addWhiskyMængde(this);
        }
    }
}
