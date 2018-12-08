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
		
		JLabel label = new JLabel("���ݿ����� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textAttand);
		label = new JLabel("�߰��ݿ����� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textMid);
		label = new JLabel("�⸻���� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textFinal);
		label = new JLabel("����ݿ����� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textQuiz);
		label = new JLabel("��ǥ�ݿ����� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textPPT);
		label = new JLabel("�����ݿ����� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textReport);
		label = new JLabel("��Ÿ�ݿ����� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textEtc);
		
		label = new JLabel("A+�������� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textAP);
		label = new JLabel("A0�������� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textA0);
		label = new JLabel("B+�������� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textBP);
		label = new JLabel("B+�������� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textB0);
		label = new JLabel("C+�������� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textCP);
		label = new JLabel("C0�������� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textC0);
		label = new JLabel("D�������� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textD);
		label = new JLabel("F�������� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textF);
		
		label = new JLabel("�������� ���߱� :");
		label.setHorizontalAlignment(JLabel.CENTER);
		JCheckBox privacy = new JCheckBox("���߱�");
		add(label);
		add(privacy);

		JButton save = new JButton("����");
		add(save);
		JButton cancle = new JButton("���");
		add(cancle);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(300, 600);
		setVisible(true);
	}
}
