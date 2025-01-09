public class Partition {

	private char letter;
	private int size;

	public Partition(char letter, int size) {
		this.letter = letter;
		this.size = size;
	}

	public char getLetter(Partition partition) {
		return letter;
	}

	public int getSize(Partition partition) {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
