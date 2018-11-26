package classes;

public class Course extends Student {
	private int scoreAttand;
	private int scoreMid;
	private int scoreFinal;
	private int scoreHomework;
	private int scoreQuiz;
	private int scorePPT;
	private int scoreReport;
	private int scoreEtc;

	public int getScoreAttand() {
		return scoreAttand;
	}

	public void setScoreAttand(int scoreAttand) {
		this.scoreAttand = scoreAttand;
	}

	public int getScoreMid() {
		return scoreMid;
	}

	public void setScoreMid(int scoreMid) {
		this.scoreMid = scoreMid;
	}

	public int getScoreFinal() {
		return scoreFinal;
	}

	public void setScoreFinal(int scoreFinal) {
		this.scoreFinal = scoreFinal;
	}

	public int getScoreHomework() {
		return scoreHomework;
	}

	public void setScoreHomework(int scoreHomework) {
		this.scoreHomework = scoreHomework;
	}

	public int getScoreQuiz() {
		return scoreQuiz;
	}

	public void setScoreQuiz(int scoreQuiz) {
		this.scoreQuiz = scoreQuiz;
	}

	public int getScorePPT() {
		return scorePPT;
	}

	public void setScorePPT(int scorePPT) {
		this.scorePPT = scorePPT;
	}

	public int getScoreReport() {
		return scoreReport;
	}

	public void setScoreReport(int scoreReport) {
		this.scoreReport = scoreReport;
	}

	public int getScoreEtc() {
		return scoreEtc;
	}

	public void setScoreEtc(int scoreEtc) {
		this.scoreEtc = scoreEtc;
	}

	@Override
	int totalScore() {
		return 0;
	}

}
