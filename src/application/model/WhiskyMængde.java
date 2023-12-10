package application.model;

public class WhiskyMængde {

    // person
    private double liter;

    private Whisky whisky;

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


}
