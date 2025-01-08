public class Server extends Computer {
	private int bayNumber;
	private int raid;

	public Server(String id, String brand, String model, int ram, float cpuFrequency, int bayNumber, int raid) {
		super(id, brand, model, ram, cpuFrequency);
		setBayNumber(bayNumber);
		setRaid(raid);
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