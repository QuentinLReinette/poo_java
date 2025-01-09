public class Server extends Computer implements Connected {
	private int bayNumber;
	private int raid;
	private boolean isConnected;

	public Server(String id, String brand, String model, int ram, float cpuFrequency, int bayNumber, int raid) {
		super(id, brand, model, ram, cpuFrequency);
		this.bayNumber = bayNumber;
		this.raid = raid;
		this.isConnected = false;
	}

	public Server() {
		this.isConnected = false;
	}

	@Override
	public String toString() {
		return super.toString() + "\nbay number: " + bayNumber + "\nraid: " + raid;
	}

	@Override
	public void update() {
		this.setVersion(2);
		System.out.println("system updated");
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

	public boolean getConnected() {
		return isConnected;
	}

	@Override
	public void Connect() {
		this.isConnected = true;
	}

	@Override
	public void Disconnect() {
		this.isConnected = false;

	}
}