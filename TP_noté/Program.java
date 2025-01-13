package TP_noté;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    static Train train;
    static ArrayList<Integer> idList;

    public static void main(String[] args) {
        train = new Train();
        idList = new ArrayList<Integer>();
        idList.add(1);

        Scanner scan = new Scanner(System.in);

        for (int choice = 0; choice != 8;) {
            System.out.println("\n1. Voir le train" +
                    "\n2. Ajouter la locomotive" +
                    "\n3. Modifier la locomotive" +
                    "\n4. Supprimer la locomotive" +
                    "\n5. Ajouter un vehicule remorque" +
                    "\n6. Modifier un vehicule remorque" +
                    "\n7. Supprimer un vehicule remorque" +
                    "\n8. Quitter\n");

            switch (choice = scan.nextInt()) {
                case 1:
                    System.out.println(train.draw());
                    break;
                case 2:
                    addLoco(scan, args);
                    break;
                case 3:
                    editLoco(scan, args);
                    break;
                case 4:
                    train.removeLoco();
                    System.out.println("locomotive supprimée");
                    break;
                case 5:
                    addVehicule(scan, args);
                    break;
                case 6:
                    editVehicule(scan, args);
                    break;
                case 7:
                    removeVehicule(scan, args);
                    break;
                case 8:
                    scan.close();
                    return;
            }
        }
        scan.close();
    }

    public static void addLoco(Scanner scan, String[] args) {
        System.out.println("entrez la puissance de la locomotive :");
        int power = scan.nextInt();
        scan.nextLine();

        System.out.println("entrez la longueur de la locomotive :");
        int length = scan.nextInt();
        scan.nextLine();

        boolean leading = false;
        for (int choice = 0; choice != 1 && choice != 2;) {
            System.out.println("entrez la position de la locomotive : 1. avant ; 2. arriere");
            switch (choice = scan.nextInt()) {
                case 1:
                    leading = true;
                    break;
                case 2:
                    leading = false;
                    break;
            }
        }
        train.addLoco(new Locomotive(power, leading, length));
        System.out.println("locomotive ajoutée avec l'id 1");
    }

    public static void editLoco(Scanner scan, String[] args) {
        Locomotive loco = train.getLoco();
        if (loco == null) {
            System.out.println("le train n'a pas de locomotive");
            return;
        }
        System.out.println("que voulez vous modifier ?" +
                "\n1. position\n2. puissance\n3. longueur\n4. quitter");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                for (int position = 0; position != 3;) {
                    position = scan.nextInt();
                    System.out.println("où voulez vous placer la locomotive ? 1. avant ; 2. arrière ; 3. annuler");
                    switch (position) {
                        case 1:
                            train.editLoco(loco.getPower(), true, loco.getLenght());
                            break;
                        case 2:
                            train.editLoco(loco.getPower(), false, loco.getLenght());
                            break;
                        case 3:
                            break;
                    }
                }
                break;
            case 2:
                System.out.println("entrez la puissance :");
                train.editLoco(scan.nextInt(), loco.getLeading(), loco.getLenght());
                scan.nextLine();
                break;
            case 3:
                System.out.println("entrez la longueur :");
                train.editLoco(loco.getPower(), loco.getLeading(), scan.nextInt());
                scan.nextLine();
                break;
            case 4:
                return;
            default:
                editLoco(scan, args);
                return;
        }
        System.out.println("locommotive modifiée");
    }

    public static void addWagon(Scanner scan, String[] args) {
        System.out.println("entrez la charge max :");
        int maxLoad = scan.nextInt();
        scan.nextLine();

        System.out.println("entrez la charge actuelle :");
        int load = scan.nextInt();
        scan.nextLine();

        if (maxLoad < load) {
            System.out.println("erreur : surcharge pondérale");
            return;
        }

        System.out.println("entrez la longueur :");
        int length = scan.nextInt();
        scan.nextLine();

        train.addVehicule(new Wagon(maxLoad, load, length, idList.getLast() + 1));

        idList.add(idList.getLast() + 1);
        System.out.println("wagon ajouté avec l'id " + idList.getLast());
    }

    public static void addCar(Scanner scan, String[] args) {
        System.out.println("entrez le nombre de places :");
        int seats = scan.nextInt();
        scan.nextLine();

        System.out.println("entrez le nombre de passagers :");
        int passengers = scan.nextInt();
        scan.nextLine();

        if (seats < passengers) {
            System.out.println("erreur : il y a plus de passagers que de sièges");
            return;
        }

        System.out.println("entrez la longueur :");
        int length = scan.nextInt();
        scan.nextLine();

        train.addVehicule(new Car(seats, passengers, length, idList.getLast() + 1));

        idList.add(idList.getLast() + 1);
        System.out.println("voiture ajoutée avec l'id " + idList.getLast());
    }

    public static void addVehicule(Scanner scan, String[] args) {
        for (int type = 0; type != 3;) {
            System.out.println("selectionnez le type : 1. wagon ; 2. voiture passagers ; 3. retour");
            type = scan.nextInt();
            switch (type) {
                case 1:
                    addWagon(scan, args);
                    break;
                case 2:
                    addCar(scan, args);
                    break;
                case 3:
                    break;
            }

        }
    }

    public static void editVehicule(Scanner scan, String[] args) {
        ArrayList<TrackedVehicule> tracked = train.getTracked();
        if (tracked.isEmpty()) {
            System.out.println("le train n'a pas de remorque");
            return;
        }
        System.out.println("entrez l'id de la remorque :");
        for (int i = 0; i < tracked.size(); i++) {
            for (int j = i; j <= i + 2 && j < tracked.size(); j++) {
                TrackedVehicule vehicule = tracked.get(j);
                System.out.print(vehicule.getID() + ".  " + vehicule.draw());
                if (j < i + 2) {
                    System.out.print("\t\t");
                }
            }
            i += 2;
            System.out.println();
        }

        int id = scan.nextInt();
        for (TrackedVehicule vehicule : tracked) {
            if (vehicule.getID() == id) {
                if (vehicule instanceof Car) {
                    System.out.println("entrez le nombre de passagers :");
                    Car car = (Car) vehicule;
                    int passengers = scan.nextInt();
                    scan.nextLine();
                    if (car.getPassengers() < passengers) {
                        System.out.println("erreur : il y a plus de passagers que de sièges");
                        return;
                    }
                    car.setPassengers(passengers);
                    System.out.println("voiture modifiée");
                    return;
                } else {
                    System.out.println("entrez la charge :");
                    Wagon wagon = (Wagon) vehicule;
                    int load = scan.nextInt();
                    scan.nextLine();
                    if (wagon.getMaxLoad() < load) {
                        System.out.println("erreur : surcharge pondérale");
                        return;
                    }
                    wagon.setLoad(load);
                    System.out.println("wagon modifié");
                    return;
                }
            }
        }
        System.out.println("l'id ne correspond à aucune remorque");
    }

    public static void removeVehicule(Scanner scan, String[] args) {
        if (train.getTracked().isEmpty()) {
            System.out.println("le train n'a pas de remorques");
            return;
        }

        System.out.println("entrez l'id de la remorque :");
        int id = scan.nextInt();
        for (TrackedVehicule vehicule : train.getTracked()) {
            if (vehicule.getID() == id) {
                train.getTracked().remove(vehicule);
                System.out.println("remorque supprimée");
                return;
            }
        }
        System.out.println("l'id ne correspond à aucune remorque");
    }

}
