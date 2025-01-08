import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Laptop laptop = laptopInit(args, scan);
		Server server = serverInit(args, scan);

		for (int choice = 0; choice != 3;) {
			System.out.println("\n1 Laptop\n2 Server\n3 Exit");
			choice = scan.nextInt();
			switch (choice) {
				case 1:
					laptopOptions(laptop, scan);
					break;
				case 2:
					serverOptions(server, scan);
					break;
				case 3:
					return;
				default:
					System.out.println("Invalid choice: ");
					choice = scan.nextInt();
			}
		}
		scan.close();
	}

	public static void laptopOptions(Laptop laptop, Scanner scan) {

		for (int choice = 0; choice != 9;) {
			System.out.println("\n1 Display the laptop's characteristics" +
					"\n2 Change RAM quantity" +
					"\n3 Change CPU frequency" +
					"\n4 Charge battery" +
					"\n5 Start laptop" +
					"\n6 Use laptop" +
					"\n7 Put to sleep" +
					"\n8 Power off" +
					"\n9 Back to main menu");
			choice = scan.nextInt();
			switch (choice) {
				case 1:
					System.out.println("\nId : " + laptop.getId() +
							"\nBrand : " + laptop.getBrand() +
							"\nModel : " + laptop.getModel() +
							"\nRAM : " + laptop.getRam() +
							"\nCPU frequency : " + laptop.getCpuFrequency() +
							"\nScreen size : " + laptop.getScreenSize() +
							"\nBattery load : " + laptop.getBatteryLoad() + "%");
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
			}
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
		for (; choice != 9;) {
			switch (choice) {
				case 1:
					System.out.println("\nId : " + server.getId() +
							"\nBrand : " + server.getBrand() +
							"\nModel : " + server.getModel() +
							"\nRAM : " + server.getRam() +
							"\nCPU frequency : " + server.getCpuFrequency() +
							"\nBay number : " + server.getBayNumber() +
							"\nRaid protocol : " + server.getRaid());
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
					choice = scan.nextInt();
					break;
			}

		}
	}

	public static Laptop laptopInit(String[] args, Scanner scan) {
		System.out.println("Please enter laptop specs");

		System.out.println("\nEnter computer id: ");
		String id = scan.nextLine();
		scan.nextLine();

		System.out.println("\nEnter screen size: ");
		int screenSize = scan.nextInt();
		scan.nextLine();

		System.out.println("\nEnter computer brand: ");
		String brand = scan.nextLine();
		scan.nextLine();

		System.out.println("\nEnter computer model: ");
		String model = scan.nextLine();
		scan.nextLine();

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
}
