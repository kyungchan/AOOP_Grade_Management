package classes;

public class Ratio {
	private int ratioAttand;
	private int ratioMid;
	private int ratioFinal;
	private int ratioHomework;
	private int ratioQuiz;
	private int ratioPPT;
	private int ratioReport;
	private int ratioEtc;

	public Ratio(int ratioAttand, int ratioMid, int ratioFinal, int ratioHomework, int ratioQuiz, int ratioPPT,
			int ratioReport, int ratioEtc) {
		this.ratioAttand = ratioAttand;
		this.ratioMid = ratioMid;
		this.ratioFinal = ratioFinal;
		this.ratioHomework = ratioHomework;
		this.ratioQuiz = ratioQuiz;
		this.ratioPPT = ratioPPT;
		this.ratioReport = ratioReport;
		this.ratioEtc = ratioEtc;
	}

	public int getRatioAttand() {
		return ratioAttand;
	}

	public void setRatioAttand(int ratioAttand) {
		this.ratioAttand = ratioAttand;
	}

	public int getRatioMid() {
		return ratioMid;
	}

	public void setRatioMid(int ratioMid) {
		this.ratioMid = ratioMid;
	}

	public int getRatioFinal() {
		return ratioFinal;
	}

	public void setRatioFinal(int ratioFinal) {
		this.ratioFinal = ratioFinal;
	}

	public int getRatioHomework() {
		return ratioHomework;
	}

	public void setRatioHomework(int ratioHomework) {
		this.ratioHomework = ratioHomework;
	}

	public int getRatioQuiz() {
		return ratioQuiz;
	}

	public void setRatioQuiz(int ratioQuiz) {
		this.ratioQuiz = ratioQuiz;
	}

	public int getRatioPPT() {
		return ratioPPT;
	}

	public void setRatioPPT(int ratioPPT) {
		this.ratioPPT = ratioPPT;
	}

	public int getRatioReport() {
		return ratioReport;
	}

	public void setRatioReport(int ratioReport) {
		this.ratioReport = ratioReport;
	}

	public int getRatioEtc() {
		return ratioEtc;
	}

	public void setRatioEtc(int ratioEtc) {
		this.ratioEtc = ratioEtc;
	}
}
