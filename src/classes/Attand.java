package classes;

public class Attand extends Student {
	private int miss;
	private int check;
	private int late;
	private String serialAttand; // 출석 표시 0-결석 1-지각 2-출석
									// 예) 222222222222202211122222

	public Attand(String serialAttand) {
		setSerialAttand(serialAttand);
	}

	@Override
	int totalScore(Ratio ratio) {
		return 100 - 10 * (miss + late / 3) - 3 * (miss % 3);
	}

	public int getMiss() {
		return miss;
	}

	public int getCheck() {
		return check;
	}

	public int getLate() {
		return late;
	}

	public String getSerialAttand() {
		return serialAttand;
	}

	public void setSerialAttand(String serialAttand) {
		this.serialAttand = serialAttand;
		this.miss = 0;
		this.check = 0;
		this.late = 0;
		for (int i = 0; i < 32; i++) {
			switch (serialAttand.charAt(i)) {
			case 0:
				this.miss++;
				break;
			case 1:
				this.late++;
				break;
			case 2:
				this.check++;
				break;
			}

		}

	}

}
