public class Desktop extends Computer {
	public Desktop(String id, int ram, float cpuFrequency) {
		super(id, ram, cpuFrequency);
	}

	@Override
	public void update() {
		this.setVersion(getVersion()+1);
		System.out.println("system updated");
	}
}