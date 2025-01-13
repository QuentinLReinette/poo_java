package TP6;

import java.util.*;

public abstract class Computer {

	private String id;
	private String brand;
	private String model;
	private int ram;
	private float cpuFrequency;
	private String status;
	private ArrayList<Partition> partitions;
	private int version;

	public Computer(String id, String brand, String model, int ram, float cpuFrequency) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.ram = ram;
		this.cpuFrequency = cpuFrequency;
		this.version = 1;
	}

	public Computer(String id, int ram, float cpuFrequency) {
		this.id = id;
		this.ram = ram;
		this.cpuFrequency = cpuFrequency;
		this.version = 1;
	}
	
	public Computer() {
	}

	public String toString() {
		return "\nid: " + id + "\nbrand: " + brand + "\nmodel: " + model + "\nram: " + ram
				+ "\nCPU frequency: " + cpuFrequency + "\nstatus: " + status;
	}

	public abstract void update();

	public void add(Partition partition) {
		partitions.add(partition);
	}

	public void remove(Partition partition) {
		partitions.remove(partition);
	}

	public void remove(int index) {
		partitions.remove(index);
	}

	public void modify(Partition partition, int newSize) {
		partition.setSize(newSize);
	}

	public void modify(int index, int newSize) {
		partitions.get(index).setSize(newSize);
	}

	public void set(int index, Partition partition) {
		Iterator<Partition> it = partitions.iterator();
		while (it.hasNext()) {
			if (it.equals(partitions.get(index))) {
				it.remove();
				partitions.add(partition);
			}
		}
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int newVersion) {
		this.version = newVersion;
	}

	public String getId() {
		return this.id;
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
