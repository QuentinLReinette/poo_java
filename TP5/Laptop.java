package TP5;

public class Laptop extends Computer {
	private float screenSize;
	private int batteryLoad;

	public Laptop(String id, String brand, String model, int ram, float cpuFrequency, float screenSize) {
		super(id, brand, model, ram, cpuFrequency);
		this.screenSize = screenSize;
		this.batteryLoad = 100;
	}

	public Laptop() {
	}

	@Override
	public void update() {
		if (this.getBatteryLoad() <= 50) {
			System.out.println("error : battery load < 50%");
			return;
		}
		this.setVersion(getVersion()+1);
		System.out.println("system updated");
	}

	@Override
	public String toString() {
		return super.toString() + "\nscreen size: " + screenSize + "\nbattery load: " + batteryLoad;
	}

	public float getScreenSize() {
		return this.screenSize;
	}

	public float getBatteryLoad() {
		return this.batteryLoad;
	}

	public void sleep() {
		setStatus("sleep");
	}

	public void load() {
		this.batteryLoad = 100;
	}

	public void run(int time) {
		this.batteryLoad -= (time * 10);
	}
}
