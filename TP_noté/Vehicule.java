package TP_noté;

public abstract class Vehicule implements Drawable {
    private int length;
    private int id;

    public Vehicule(int length, int id) {
        this.length = length;
        this.id = id;
    }

    public Vehicule() {
    }

    public int getLenght() {
        return this.length;
    }

    public int getID() {
        return this.id;
    }

    public String toString() {
        return "longueur : " + this.length + " ; id :" + this.id;
    }
}
