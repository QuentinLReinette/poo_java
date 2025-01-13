package TP_noté;

public class Locomotive extends Vehicule {
    private int power;
    private boolean leading;

    public Locomotive(int power, boolean leading, int length) {
        super(length, 1);
        this.power = power;
        this.leading = leading;
    }
    
    public Locomotive() {
    }

    public int getPower() {
        return this.power;
    }

    public boolean getLeading() {
        return this.leading;
    }

    public void setLeading(boolean leading) {
        this.leading = leading;
    }

    @Override
    public String draw() {
        String drawing = "";
        if (this.leading) {
            drawing = "<" + this.power;
            for (int i = 1; i <= this.getLenght(); i++) {
                drawing += "#";
            }
        } else {
            for (int i = 1; i <= this.getLenght(); i++) {
                drawing += "#";
            }
            drawing += this.power + ">";
        }
        return drawing;
    }

    public String toString() {
        if (leading) {
            return super.toString() + "puissance : " + this.power + " ; position : avant";
        } else {
            return super.toString() + "puissance : " + this.power + " ; position : arrière";
        }
    }
}