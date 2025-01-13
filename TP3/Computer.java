package TP3;

public class Computer {

	private String id;
	private String brand;
	private String model;
	private int ram;
	private float cpuFrequency;
	private String status;

	public Computer(String id, String brand, String model, int ram, float cpuFrequency) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.ram = ram;
		this.cpuFrequency = cpuFrequency;
	}

	public Computer(String id, int ram, float cpuFrequency) {
		this.id = id;
		this.ram = ram;
		this.cpuFrequency = cpuFrequency;
	}

	public String toString() {
		return "\nid: " + id + "\nbrand: " + brand + "\nmodel: " + model + "\nram: " + ram
				+ "\nCPU frequency: " + cpuFrequency + "\nstatus: " + status;
	}

	public Computer() {
	}

	public String getId() {
		return id;
	}

	public String getBrand() {
		return this.brand;
	}

	public String getModel() {
		return this.model;
	}

	public int getRam() {
		return this.ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public float getCpuFrequency() {
		return this.cpuFrequency;
	}

	public void setCpuFrequency(float cpuFrequency) {
		this.cpuFrequency = cpuFrequency;
	}

	public String getStatus() {
		return this.status;
	}

	protected void setStatus(String newStatus) {
		this.status = newStatus;
	}

	public void start() {
		setStatus("on");
	}

	public void halt() {
		setStatus("off");
	}
}
