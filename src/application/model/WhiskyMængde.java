package application.model;

public class WhiskyMængde {

    // Person
    private double liter;

    private Whisky whisky;

    private Påfyldning påfyldning;

    public WhiskyMængde(double liter, Whisky whisky) {
        this.liter = liter;
        this.whisky = whisky;
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

    public void setWhisky(Whisky w) {
        if(this.whisky != w){
            Whisky oldWhisky = this.whisky;
            if(oldWhisky != null){
                oldWhisky.removeWhiskyMængde(this);
            }
            this.whisky = w;
            if(w != null)
                w.addWhiskyMængde(this);
        }
    }
}
