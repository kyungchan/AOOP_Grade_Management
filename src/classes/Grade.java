package classes;

public class Grade {

	private int ratioAP;
	private int ratioA0;
	private int ratioBP;
	private int ratioB0;
	private int ratioCP;
	private int ratioC0;
	private int ratioD;
	private int ratioF;

	public Grade(int ratioAP, int ratioA0, int ratioBP, int ratioB0, int ratioCP, int ratioC0, int ratioD, int ratioF) {
		this.ratioAP = ratioAP;
		this.ratioA0 = ratioA0;
		this.ratioBP = ratioBP;
		this.ratioB0 = ratioB0;
		this.ratioCP = ratioCP;
		this.ratioC0 = ratioC0;
		this.ratioD = ratioD;
		this.ratioF = ratioF;
	}

	public int[] getAllRatio() {
		int[] temp = new int[8];
		temp[0] = this.ratioAP;
		temp[1] = this.ratioA0;
		temp[2] = this.ratioBP;
		temp[3] = this.ratioB0;
		temp[4] = this.ratioCP;
		temp[5] = this.ratioC0;
		temp[6] = this.ratioD;
		temp[7] = this.ratioF;
		return temp;
		
	}
	
	public int getRatioAP() {
		return ratioAP;
	}

	public void setRatioAP(int ratioAP) {
		this.ratioAP = ratioAP;
	}

	public int getRatioA0() {
		return ratioA0;
	}

	public void setRatioA0(int ratioA0) {
		this.ratioA0 = ratioA0;
	}

	public int getRatioBP() {
		return ratioBP;
	}

	public void setRatioBP(int ratioBP) {
		this.ratioBP = ratioBP;
	}

	public int getRatioB0() {
		return ratioB0;
	}

	public void setRatioB0(int ratioB0) {
		this.ratioB0 = ratioB0;
	}

	public int getRatioCP() {
		return ratioCP;
	}

	public void setRatioCP(int ratioCP) {
		this.ratioCP = ratioCP;
	}

	public int getRatioC0() {
		return ratioC0;
	}

	public void setRatioC0(int ratioC0) {
		this.ratioC0 = ratioC0;
	}

	public int getRatioD() {
		return ratioD;
	}

	public void setRatioD(int ratioD) {
		this.ratioD = ratioD;
	}

	public int getRatioF() {
		return ratioF;
	}

	public void setRatioF(int ratioF) {
		this.ratioF = ratioF;
	}
}
