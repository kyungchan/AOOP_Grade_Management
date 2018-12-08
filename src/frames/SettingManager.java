package frames;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.Grade;
import classes.Ratio;
import queries.SettingQueries;

public class SettingManager extends JDialog implements ActionListener, FocusListener {
	private Ratio ratio;
	private Grade grade;
	private SettingQueries settingQueries;
	private JTextField textAttand;
	private JTextField textMid;
	private JTextField textFinal;
	private JTextField textHomework;
	private JTextField textQuiz;
	private JTextField textPPT;
	private JTextField textReport;
	private JTextField textEtc;

	private JTextField textAP;
	private JTextField textA0;
	private JTextField textBP;
	private JTextField textB0;
	private JTextField textCP;
	private JTextField textC0;
	private JTextField textD;
	private JTextField textF;

	private JTextField totalRatio;
	private JTextField totalGrade;

	private JCheckBox privacy;
	private boolean flagPriv;

	public SettingManager(Ratio ratio, Grade grade, SettingQueries settingQueries) {
		setTitle("설정");
		this.setLayout(new GridLayout(0, 2, 10, 10));
		this.ratio = ratio;
		this.grade = grade;
		this.settingQueries = settingQueries;
		flagPriv = false;
		textAttand = new JTextField(Integer.toString(ratio.getRatioAttand()));
		textMid = new JTextField(Integer.toString(ratio.getRatioMid()));
		textFinal = new JTextField(Integer.toString(ratio.getRatioFinal()));
		textHomework = new JTextField(Integer.toString(ratio.getRatioHomework()));
		textQuiz = new JTextField(Integer.toString(ratio.getRatioQuiz()));
		textPPT = new JTextField(Integer.toString(ratio.getRatioPPT()));
		textReport = new JTextField(Integer.toString(ratio.getRatioReport()));
		textEtc = new JTextField(Integer.toString(ratio.getRatioEtc()));
		totalRatio = new JTextField("100");
		textAP = new JTextField(Integer.toString(grade.getRatioAP()));
		textA0 = new JTextField(Integer.toString(grade.getRatioA0()));
		textBP = new JTextField(Integer.toString(grade.getRatioBP()));
		textB0 = new JTextField(Integer.toString(grade.getRatioB0()));
		textCP = new JTextField(Integer.toString(grade.getRatioCP()));
		textC0 = new JTextField(Integer.toString(grade.getRatioC0()));
		textD = new JTextField(Integer.toString(grade.getRatioD()));
		textF = new JTextField(Integer.toString(grade.getRatioF()));
		totalGrade = new JTextField("100");

		JLabel label = new JLabel("출결반영비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textAttand);
		textAttand.addFocusListener(this);
		textMid.addFocusListener(this);
		textFinal.addFocusListener(this);
		textHomework.addFocusListener(this);
		textQuiz.addFocusListener(this);
		textPPT.addFocusListener(this);
		textReport.addFocusListener(this);
		textEtc.addFocusListener(this);

		textAP.addFocusListener(this);
		textA0.addFocusListener(this);
		textBP.addFocusListener(this);
		textB0.addFocusListener(this);
		textCP.addFocusListener(this);
		textC0.addFocusListener(this);
		textD.addFocusListener(this);
		textF.addFocusListener(this);

		label = new JLabel("중간반영비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textMid);
		label = new JLabel("기말비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textFinal);
		label = new JLabel("과제비율 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(textHomework);
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
		label = new JLabel("반영비율합계 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(totalRatio);
		totalRatio.setEnabled(false);

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
		label = new JLabel("B0배정비율 :");
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
		label = new JLabel("배정비율합계 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(totalGrade);
		totalGrade.setEnabled(false);

		label = new JLabel("개인정보 감추기 :");
		label.setHorizontalAlignment(JLabel.CENTER);
		privacy = new JCheckBox("감추기");
		add(label);
		privacy.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					flagPriv = true;
				} else {
					flagPriv = false;
				}

			}
		});
		add(privacy);

		if (settingQueries.getPrivacy() == 1) {
			flagPriv = true;
			privacy.setSelected(true);
		}

		JButton save = new JButton("적용");
		save.addActionListener(this);
		add(save);
		JButton cancle = new JButton("취소");
		save.addActionListener(this);
		add(cancle);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(300, 600);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "적용":
			if (!(totalGrade.getText().equals("100") && totalRatio.getText().equals("100")))
				JOptionPane.showMessageDialog(null, "적용비율과 배정비율의 합이 100이 아닙니다.", "성적관리", JOptionPane.ERROR_MESSAGE);
			else {
				this.ratio.setRatioAttand(Integer.parseInt(textAttand.getText()));
				this.ratio.setRatioMid(Integer.parseInt(textMid.getText()));
				this.ratio.setRatioFinal(Integer.parseInt(textFinal.getText()));
				this.ratio.setRatioHomework(Integer.parseInt(textHomework.getText()));
				this.ratio.setRatioQuiz(Integer.parseInt(textQuiz.getText()));
				this.ratio.setRatioPPT(Integer.parseInt(textPPT.getText()));
				this.ratio.setRatioReport(Integer.parseInt(textReport.getText()));
				this.ratio.setRatioEtc(Integer.parseInt(textEtc.getText()));
				settingQueries.updateSetting(0, (Integer.parseInt(textAttand.getText())));
				settingQueries.updateSetting(1, (Integer.parseInt(textMid.getText())));
				settingQueries.updateSetting(2, (Integer.parseInt(textFinal.getText())));
				settingQueries.updateSetting(3, (Integer.parseInt(textHomework.getText())));
				settingQueries.updateSetting(4, (Integer.parseInt(textQuiz.getText())));
				settingQueries.updateSetting(5, (Integer.parseInt(textPPT.getText())));
				settingQueries.updateSetting(6, (Integer.parseInt(textReport.getText())));
				settingQueries.updateSetting(7, (Integer.parseInt(textEtc.getText())));

				this.grade.setRatioAP(Integer.parseInt(textAP.getText()));
				this.grade.setRatioA0(Integer.parseInt(textA0.getText()));
				this.grade.setRatioBP(Integer.parseInt(textBP.getText()));
				this.grade.setRatioB0(Integer.parseInt(textB0.getText()));
				this.grade.setRatioCP(Integer.parseInt(textCP.getText()));
				this.grade.setRatioC0(Integer.parseInt(textC0.getText()));
				this.grade.setRatioD(Integer.parseInt(textD.getText()));
				this.grade.setRatioF(Integer.parseInt(textF.getText()));
				settingQueries.updateSetting(8, (Integer.parseInt(textAP.getText())));
				settingQueries.updateSetting(9, (Integer.parseInt(textA0.getText())));
				settingQueries.updateSetting(10, (Integer.parseInt(textBP.getText())));
				settingQueries.updateSetting(11, (Integer.parseInt(textB0.getText())));
				settingQueries.updateSetting(12, (Integer.parseInt(textCP.getText())));
				settingQueries.updateSetting(13, (Integer.parseInt(textC0.getText())));
				settingQueries.updateSetting(14, (Integer.parseInt(textD.getText())));
				settingQueries.updateSetting(15, (Integer.parseInt(textF.getText())));

				if (flagPriv)
					settingQueries.updateSetting(16, 1);
				else
					settingQueries.updateSetting(16, 0);

				this.dispose();
			}
			break;
		case "취소":

			break;
		}

	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		int total = Integer.parseInt(textAttand.getText()) + Integer.parseInt(textMid.getText())
				+ Integer.parseInt(textFinal.getText()) + Integer.parseInt(textHomework.getText())
				+ Integer.parseInt(textQuiz.getText()) + Integer.parseInt(textPPT.getText())
				+ Integer.parseInt(textReport.getText()) + Integer.parseInt(textEtc.getText());
		totalRatio.setText(Integer.toString(total));

		total = Integer.parseInt(textAP.getText()) + Integer.parseInt(textA0.getText())
				+ Integer.parseInt(textBP.getText()) + Integer.parseInt(textB0.getText())
				+ Integer.parseInt(textCP.getText()) + Integer.parseInt(textC0.getText())
				+ Integer.parseInt(textD.getText()) + Integer.parseInt(textF.getText());
		totalGrade.setText(Integer.toString(total));

	}
}
