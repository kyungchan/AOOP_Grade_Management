package classes;

public class Attand extends Student {
	private String serialAttand; // �⼮ ǥ�� 0-�Ἦ 1-���� 2-�⼮
							     // ��) 222222222222202211122222

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
