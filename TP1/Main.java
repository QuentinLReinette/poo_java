import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Computer ordi = computerInit(args, scan);

		System.out.println("\nId : " + ordi.getId() +
							"\nBrand : " + ordi.getBrand() +
							"\nModel : " + ordi.getModel() +
							"\nRAM : " + ordi.getRam() +
							"\nCPU frequency : " + ordi.getCpuFrequency());

		userOptions(ordi, scan);
		
		scan.close();
	}

	public static void userOptions(Computer ordi, Scanner scan) {
		for (int choix = 0; choix != 4;) {
			System.out.println("\n1 Display the computer's characteristics" +
					"\n2 Modify the RAM" +
					"\n3 Modify the CPU frequency" +
					"\n4 Exit");
			choix = scan.nextInt();

			switch (choix) {
				case 1:
					System.out.println("\nId : " + ordi.getId() +
							"\nBrand : " + ordi.getBrand() +
							"\nModel : " + ordi.getModel() +
							"\nRAM : " + ordi.getRam() +
							"\nCPU frequency : " + ordi.getCpuFrequency());
					break;
				case 2:
					System.out.println("\nEnter the amount of RAM :");
					ordi.setRam(scan.nextInt());
					break;
				case 3:
					System.out.println("\nEnter the CPU frequency :");
					ordi.setCpuFrequency(scan.nextFloat());
					break;
				case 4:
					break;
				default:
					System.out.println("\nInvalid choice\n");
			}
		}
		return;
	}

	public static Computer computerInit(String[] args, Scanner scan ) {

		System.out.println("\nEnter computer id: ");
		String id = scan.nextLine();

		System.out.println("\nEnter computer brand: ");
		String brand = scan.nextLine();

		System.out.println("\nEnter computer model: ");
		String model = scan.nextLine();

		System.out.println("\nEnter computer ram: ");
		int ram = scan.nextInt();

		System.out.println("\nEnter computer cpu frequency: ");
		float cpuFrequency = scan.nextFloat();

		return new Computer(id, brand, model, ram, cpuFrequency);
	}
}
