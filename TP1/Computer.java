public class Computer {

    private String id;
    private String brand;
    private String model;
    private int ram;
    private float cpuFrequency;

    public Computer(String id, String brand, String model, int ram, float cpuFrequency) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.cpuFrequency = cpuFrequency;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public float getCpuFrequency() {
        return cpuFrequency;
    }

    public void setCpuFrequency(float cpuFrequency) {
        this.cpuFrequency = cpuFrequency;
    }
}