package TP_noté;

public class Car extends TrackedVehicule {
    private int seats;
    private int passengers;

    public Car(int seats, int passengers, int length, int id){
        super(length, id);
        this.seats = seats;
        this.passengers = passengers;
    }

    public Car(){
        super();
    }

    public int getSeats() {
        return this.seats;
    }

    public int getPassengers() {
        return this.passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public String draw() {
        String drawing = "[" + this.getPassengers();
        for (int i = 1; i <= this.getLenght(); i++) {
            drawing += "=";
        }
        drawing += this.getSeats() + "]";
        return drawing;
    }

    public String toString() {
        return super.toString() + " ; sièges : " + this.seats + " ; passagers : " + this.passengers;
    }
}
