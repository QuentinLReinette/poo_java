public class Desktop extends Computer implements Connected, Gamer {
	private boolean isConnected;
	private boolean isPlaying;

	public Desktop(String id, int ram, float cpuFrequency) {
		super(id, ram, cpuFrequency);
	}

	@Override
	public void update() {
		this.setVersion(2);
		System.out.println("system updated");
	}

	public boolean getConnected() {
		return isConnected;
	}

	public boolean getPlaying() {
		return isPlaying;
	}

	@Override
	public void Connect() {
		this.isConnected = true;
	}

	@Override
	public void Disconnect() {
		this.isConnected = false;

	}

	@Override
	public void Start() {
		this.isPlaying = true;
	}

	@Override
	public void Stop() {
		this.isPlaying = false;
	}
}