package frames;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import classes.Grade;
import classes.Ratio;
import queries.RatioQueries;

public class SettingManager extends JDialog {
	private Ratio ratio;
	private Grade grade;
	private RatioQueries ratioQueries;

	public SettingManager(Ratio ratio, Grade grade, RatioQueries ratioQueries) {
		this.setLayout(new GridLayout(0, 2, 10, 10));
		this.ratio = ratio;
		this.grade = grade;
		this.ratioQueries = ratioQueries;

		JTextField textAttand = new JTextField(Integer.toString(ratio.getRatioAttand()));
		JTextField textMid = new JTextField(Integer.toString(ratio.getRatioMid()));
		JTextField textFinal = new JTextField(Integer.toString(ratio.getRatioFinal()));
		JTextField textQuiz = new JTextField(Integer.toString(ratio.getRatioQuiz()));
		JTextField textPPT = new JTextField(Integer.toString(ratio.getRatioPPT()));
		JTextField textReport = new JTextField(Integer.toString(ratio.getRatioReport()));
		JTextField textEtc = new JTextField(Integer.toString(ratio.getRatioEtc()));

		JTextField textAP = new JTextField(Integer.toString(grade.getRatioAP()));
		JTextField textA0 = new JTextField(Integer.toString(grade.getRatioA0()));
		JTextField textBP = new JTextField(Integer.toString(grade.getRatioBP()));
		JTextField textB0 = new JTextField(Integer.toString(grade.getRatioB0()));
		JTextField textCP = new JTextField(Integer.toString(grade.getRatioCP()));
		JTextField textC0 = new JTextField(Integer.toString(grade.getRatioC0()));
		JTextField textD = new JTextField(Integer.toString(grade.getRatioD()));
		JTextField textF = new JTextField(Integer.toString(grade.getRatioF()));
		
		JLabel label = new JLabel("출결반영비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textAttand);
		label = new JLabel("중간반영비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textMid);
		label = new JLabel("기말비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textFinal);
		label = new JLabel("퀴즈반영비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textQuiz);
		label = new JLabel("발표반영비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textPPT);
		label = new JLabel("보고서반영비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textReport);
		label = new JLabel("기타반영비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textEtc);
		
		label = new JLabel("A+배정비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textAP);
		label = new JLabel("A0배정비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textA0);
		label = new JLabel("B+배정비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textBP);
		label = new JLabel("B+배정비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textB0);
		label = new JLabel("C+배정비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textCP);
		label = new JLabel("C0배정비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textC0);
		label = new JLabel("D배정비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textD);
		label = new JLabel("F배정비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textF);
		
		label = new JLabel("개인정보 감추기 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		JCheckBox privacy = new JCheckBox("감추기");
		add(label);
		add(privacy);

		JButton save = new JButton("적용");
		add(save);
		JButton cancle = new JButton("취소");
		add(cancle);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(300, 600);
		setVisible(true);
	}
}
