package TP_noté;

import java.util.ArrayList;
import java.util.Scanner;

public class Train implements Drawable {
    private Locomotive locomotive;
    private ArrayList<TrackedVehicule> tracked;
    private String startStation;
    private String endStation;

    public Train(Locomotive locomotive, ArrayList<TrackedVehicule> tracked, String startStation,
            String endStation) {
        this.locomotive = locomotive;
        this.tracked = tracked;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public Train() {
        this.tracked = new ArrayList<>();
    }

    public String getStart() {
        return this.startStation;
    }

    public String getArrival() {
        return this.endStation;
    }

    public Locomotive getLoco() {
        return this.locomotive;
    }

    public ArrayList<TrackedVehicule> getTracked() {
        return this.tracked;
    }

    public void setSart(String startStation) {
        this.startStation = startStation;
    }

    public void setArrival(String arrivalStation) {
        this.endStation = arrivalStation;
    }

    public void setLeading(boolean leading) {
        this.locomotive.setLeading(leading);
    }

    @Override
    public String draw() {
        if (tracked.isEmpty() && locomotive == null) {
            return "train vide";
        }
        String drawing = "";
        if (this.locomotive != null && this.locomotive.getLeading()) {
            drawing += this.locomotive.draw();
            if (!this.tracked.isEmpty()) {
                drawing += "-";
            }
        }
        for (TrackedVehicule trackedVehicule : tracked) {
            drawing += trackedVehicule.draw();
            if (!trackedVehicule.equals(tracked.getLast())) {
                drawing += "-";
            }
        }
        if (this.locomotive != null && !this.locomotive.getLeading()) {
            if (!this.tracked.isEmpty()) {
                drawing += "-";
            }
            drawing += this.locomotive.draw();
        }
        return drawing;
    }

    public void addLoco(Locomotive loco) {
        if (this.locomotive != null) {
            System.out.println("erreur : le train a déjà une locomotive");
            return;
        }
        this.locomotive = loco;
    }

    public void removeLoco() {
        this.locomotive = null;
    }

    public void editLoco(int power, boolean leading, int length) {
        this.removeLoco();
        this.addLoco(new Locomotive(power, leading, length));
    }

    public void addVehicule(TrackedVehicule newVehicule) {
        this.tracked.add(newVehicule);
    }

    public void removeVehicule(int id) {
        for (TrackedVehicule vehicule : tracked) {
            if (vehicule.getID() == id) {
                tracked.remove(vehicule);
                return;
            }
        }
        System.out.println("cet id ne correspond à aucune remorque");
    }

    public void editVehicule(int id, String[] args, Scanner scan) {
        for (TrackedVehicule vehicule : tracked) {
            if (vehicule.getID() == id) {
                if (vehicule instanceof Car) {
                    System.out.println("entrez le nombre de passagers :");
                    Car car = (Car) vehicule;
                    car.setPassengers(scan.nextInt());
                    scan.nextLine();
                } else {
                    System.out.println("entrez la charge :");
                    Wagon wagon = (Wagon) vehicule;
                    wagon.setLoad(scan.nextInt());
                    scan.nextLine();
                }
                return;
            }
        }
        System.out.println("cet id ne correspond à aucune remorque");
    }

    public String toString() {
        return "\nlocomotive : " + locomotive.toString() + " ; remorques : " + tracked.toString() + " ; départ : " + this.startStation + " ; arrivée : " + this.endStation;
    }
}
