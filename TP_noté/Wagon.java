package TP_noté;

public class Wagon extends TrackedVehicule {
    private int maxLoad;
    private int load;

    public Wagon(int maxLoad, int load, int length, int id) {
        super(length, id);
        this.maxLoad = maxLoad;
        this.load = load;
    }

    public Wagon(){
        super();
    }

    public int getMaxLoad() {
        return this.maxLoad;
    }

    public int getLoad() {
        return this.load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    @Override
    public String draw() {
        String drawing = "|" + this.getLoad();
        for (int i = 1; i <= this.getLenght(); i++) {
            drawing += "_";
        }
        drawing += this.getMaxLoad() + "|";
        return drawing;
    }

    public String toString() {
        return super.toString() + " ; charge maximale : " + this.maxLoad + " ; charge : " + this.load;
    }

}
