package TP4;

import java.util.*;

public class Program {

	static List<Computer> computers = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		for (int choice = 0; choice != 6;) {
			System.out.println("\n1. Show all computers\n2. Show a computer's details\n" +
					"3. Add a computer\n4. Edit a computer\n5. Delete a computer\n6. Exit");

			choice = scan.nextInt();
			scan.nextLine();
			switch (choice) {
				case 1:
					showAll();
					break;
				case 2:
					showPC(args, scan);
					break;
				case 3:
					addPC(args, scan);
					break;
				case 4:
					editPC(args, scan);
					break;
				case 5:
					deletePC(args, scan);
					break;
				case 6:
					scan.close();
					return;
				default:
					System.out.println("Invalid choice");
			}
		}
		scan.close();
	}

	public static void showAll() {
		if (computers.isEmpty()) {
			System.out.println("No registered computer");
			return;
		}
		for (Computer pc : computers) {
			System.out.println(pc.getId() + pc.getClass() + pc.getBrand() + pc.getModel());
		}
	}

	public static void showPC(String[] args, Scanner scan) {
		if (computers.isEmpty()) {
			System.out.println("No registered computer");
			return;
		}
		System.out.println("Enter the id of the computer to display. 0 to go back to main menu");
		String id = scan.nextLine();
		if (id.equals("0")) {
			return;
		}
		for (Computer pc : computers) {
			if (pc.getId().equals(id)) {
				pc.toString();
				return;
			}
		}
		System.out.println("Invalid id");
		showPC(args, scan);
	}

	public static void addPC(String[] args, Scanner scan) {
		System.out.println("Select a computer type:\n1. Laptop\n2. Desktop\n3. Server\n4. Back to main menu");
		int type = scan.nextInt();
		switch (type) {
			case 1:
				laptopInit(args, scan);
				break;
			case 2:
				desktopInit(args, scan);
				break;
			case 3:
				serverInit(args, scan);
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid choice");
				addPC(args, scan);
				return;
		}
	}

	public static void editPC(String[] args, Scanner scan) {
		if (computers.isEmpty()) {
			System.out.println("No registered computer");
			return;
		}
		System.out.println("Enter a computer id to edit. 0 to go back to main menu");
		String id = scan.nextLine();
		if (id.equals("0")) {
			return;
		}
		for (Computer pc : computers) {
			if (pc.getId().equals(id)) {
				if (pc instanceof Laptop) {
					laptopOptions((Laptop) pc, scan);
				} else if (pc instanceof Server) {
					serverOptions((Server) pc, scan);
				} else {
					desktopOptions(pc, scan);
				}
				return;
			}
		}
		System.out.println("Invalid id");
		editPC(args, scan);
	}

	public static void deletePC(String[] args, Scanner scan) {
		if (computers.isEmpty()) {
			System.out.println("No registered computer");
			return;
		}
		System.out.println("Enter a computer id to delete. 0 to go back to main menu.");
		String id = scan.nextLine();
		if (id.equals("0")) {
			return;
		}
		for (Computer pc : computers) {
			if (pc.getId().equals(id)) {
				computers.remove(pc);
				System.out.println("Computer deleted");
				return;
			}
		}
		System.out.println("Incorrect id");
		deletePC(args, scan);
		return;
	}

	public static void laptopOptions(Laptop laptop, Scanner scan) {

		System.out.println("\n1 Display the laptop's characteristics" +
				"\n2 Change RAM quantity" +
				"\n3 Change CPU frequency" +
				"\n4 Charge battery" +
				"\n5 Start laptop" +
				"\n6 Use laptop" +
				"\n7 Put to sleep" +
				"\n8 Power off" +
				"\n9 Back to main menu");
		int choice = scan.nextInt();
		switch (choice) {
			case 1:
				System.out.println(laptop.toString());
				break;
			case 2:
				System.out.println("\nEnter the amount of RAM :");
				laptop.setRam(scan.nextInt());
				break;
			case 3:
				System.out.println("\nEnter the CPU frequency :");
				laptop.setCpuFrequency(scan.nextFloat());
				break;
			case 4:
				laptop.load();
				System.out.println("Battery charged.");
				break;
			case 5:
				laptop.setStatus("on");
				System.out.println("Laptop on");
				break;
			case 6:
				System.out.println("For how do you want to use the computer ?");
				int time = scan.nextInt();
				laptop.run(time);
				System.out.println("Battery now at " + laptop.getBatteryLoad() + "%");
				break;
			case 7:
				laptop.sleep();
				System.out.println("Laptop put to sleep");
				break;
			case 8:
				laptop.halt();
				System.out.println("Powered off");
				break;
			case 9:
				return;
			default:
				System.out.println("Invalid choice");
				laptopOptions(laptop, scan);
				return;
		}
	}

	public static void serverOptions(Server server, Scanner scan) {
		System.out.println("\n1 Display the server's characteristics" +
				"\n2 Change RAM quantity" +
				"\n3 Change CPU frequency" +
				"\n4 Change bay number" +
				"\n5 Change raid protocol" +
				"\n6 Start server" +
				"\n7 Power off" +
				"\n8 Back to main menu");
		int choice = scan.nextInt();
		switch (choice) {
			case 1:
				System.out.println(server.toString());
				break;
			case 2:
				System.out.println("\nEnter the amount of RAM :");
				server.setRam(scan.nextInt());
				break;
			case 3:
				System.out.println("\nEnter the CPU frequency :");
				server.setCpuFrequency(scan.nextFloat());
				break;
			case 4:
				System.out.println("Enter new bay number");
				int bayNumber = scan.nextInt();
				server.setBayNumber(bayNumber);
				break;
			case 5:
				System.out.println("Enter new raid protocol (number)");
				int raid = scan.nextInt();
				server.setRaid(raid);
				break;
			case 6:
				server.start();
				System.out.println("Server started");
				break;
			case 7:
				server.halt();
				System.out.println("Powered off");
				break;
			case 8:
				return;
			default:
				System.out.println("Invalid entry");
				serverOptions(server, scan);
				return;
		}
	}

	public static void desktopOptions(Computer desktop, Scanner scan) {

		System.out.println("\n1 Display the desktop's characteristics" +
				"\n2 Change RAM quantity" +
				"\n3 Change CPU frequency" +
				"\n4 Start desktop" +
				"\n5 Power off" +
				"\n6 Back to main menu");
		int choice = scan.nextInt();
		switch (choice) {
			case 1:
				System.out.println(desktop.toString());
				break;
			case 2:
				System.out.println("\nEnter the amount of RAM :");
				desktop.setRam(scan.nextInt());
				break;
			case 3:
				System.out.println("\nEnter the CPU frequency :");
				desktop.setCpuFrequency(scan.nextFloat());
				break;
			case 4:
				desktop.setStatus("on");
				System.out.println("Laptop on");
				break;
			case 5:
				desktop.halt();
				System.out.println("Powered off");
				break;
			case 6:
				return;
			/*
			 * case 7:
			 * Partition part = new Partition('Z', 142);
			 * desktop.add(part);
			 * case 8:
			 * Partition newPart = new Partition('R', 55);
			 * desktop.set(0, newPart);
			 * desktop.p
			 */
			default:
				System.out.println("Invalid choice");
				desktopOptions(desktop, scan);
				return;
		}
	}

	public static Laptop laptopInit(String[] args, Scanner scan) {
		System.out.println("Please enter laptop specs");

		System.out.println("\nEnter computer id: ");
		String id = scan.nextLine();

		System.out.println("\nEnter screen size: ");
		int screenSize = scan.nextInt();
		scan.nextLine();

		System.out.println("\nEnter computer brand: ");
		String brand = scan.nextLine();

		System.out.println("\nEnter computer model: ");
		String model = scan.nextLine();

		System.out.println("\nEnter computer ram: ");
		int ram = scan.nextInt();
		scan.nextLine();

		System.out.println("\nEnter computer cpu frequency: ");
		float cpuFrequency = scan.nextFloat();
		scan.nextLine();

		return new Laptop(id, brand, model, ram, cpuFrequency, screenSize);
	}

	public static Server serverInit(String[] args, Scanner scan) {
		System.out.println("Please enter server specs");

		System.out.println("\nEnter bay number: ");
		int bayNumber = scan.nextInt();
		scan.nextLine();

		System.out.println("\nEnter raid protocol (number): ");
		int raid = scan.nextInt();
		scan.nextLine();

		System.out.println("\nEnter computer id: ");
		String id = scan.nextLine();

		System.out.println("\nEnter computer brand: ");
		String brand = scan.nextLine();

		System.out.println("\nEnter computer model: ");
		String model = scan.nextLine();

		System.out.println("\nEnter computer ram: ");
		int ram = scan.nextInt();
		scan.nextLine();

		System.out.println("\nEnter computer cpu frequency: ");
		float cpuFrequency = scan.nextFloat();
		scan.nextLine();

		return new Server(id, brand, model, ram, cpuFrequency, bayNumber, raid);
	}

	public static Computer desktopInit(String[] args, Scanner scan) {
		System.out.println("Please enter desktop specs");

		System.out.println("\nEnter computer id: ");
		String id = scan.nextLine();

		System.out.println("\nEnter computer ram: ");
		int ram = scan.nextInt();
		scan.nextLine();

		System.out.println("\nEnter computer cpu frequency: ");
		float cpuFrequency = scan.nextFloat();
		scan.nextLine();

		return new Computer(id, ram, cpuFrequency);
	}
}
