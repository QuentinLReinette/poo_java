package TP3;

public class Server extends Computer {
	private int bayNumber;
	private int raid;

	public Server(String id, String brand, String model, int ram, float cpuFrequency, int bayNumber, int raid) {
		super(id, brand, model, ram, cpuFrequency);
		this.bayNumber = bayNumber;
		this.raid = raid;
	}

	public Server() {
	}

	@Override
	public String toString() {
		return super.toString() + "\nbay number: " + bayNumber + "\nraid: " + raid;
	}

	public int getBayNumber() {
		return this.bayNumber;
	}

	public void setBayNumber(int newBayNumber) {
		this.bayNumber = newBayNumber;
	}

	public int getRaid() {
		return this.raid;
	}

	public void setRaid(int newRaid) {
		this.raid = newRaid;
	}
}