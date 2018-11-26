package classes;

public class Attand extends Student {
	private String serialAttand; // 출석 표시 0-결석 1-지각 2-출석
							     // 예) 222222222222202211122222

	@Override
	int totalScore() {
		return 0;
	}

	public String getSerialAttand() {
		return serialAttand;
	}

	public void setSerialAttand(String serialAttand) {
		this.serialAttand = serialAttand;
	}

}
