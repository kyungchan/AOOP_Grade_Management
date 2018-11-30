package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import classes.Attand;
import classes.ClassTableModel;
import classes.Course;
import classes.Grade;
import classes.Ratio;
import queries.AttandsQueries;
import queries.CoursesQueries;

public class ScoreManager extends JFrame implements ActionListener {
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/grademanager?characterEncoding=UTF-8&serverTimezone=UTC";
	static final String USERNAME = "root";
	static final String PASSWORD = "pass";

	private Ratio ratio;
	private Grade grade;
	private MainTablePanel mtp;
	private List<Course> courses;
	private List<Attand> attands;
	private CoursesQueries coursesQueries;
	private AttandsQueries attandsQueries;
	private ClassTableModel coursesModel;
	private ClassTableModel attandsModel;

	public ScoreManager() {
		coursesQueries = new CoursesQueries(DATABASE_URL, USERNAME, PASSWORD);
		attandsQueries = new AttandsQueries(DATABASE_URL, USERNAME, PASSWORD);
		courses = coursesQueries.getAllCourses();
		courses.add(new Course("���", "", 0, 0, 0, 0, 0, 0, 0, 0, 0));
		attands = attandsQueries.getAllAttands();

		coursesModel = new ClassTableModel(courses.toArray(new Course[courses.size()]));
		attandsModel = new ClassTableModel(attands.toArray(new Attand[attands.size()]));

		ratio = new Ratio(10, 15, 15, 20, 10, 10, 10, 10, 3);
		grade = new Grade(10, 15, 15, 15, 15, 15, 10, 5);

		JMenuItem menuItem;
		KeyStroke key;

		mtp = new MainTablePanel(coursesModel);

		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("����");
		menuItem = new JMenuItem("�ҷ�����");
		menuItem.addActionListener(this);
		fileMenu.add(menuItem);
		menuItem = new JMenuItem("��������");
		menuItem.addActionListener(this);
		fileMenu.add(menuItem);
		fileMenu.addSeparator();
		menuItem = new JMenuItem("����");
		menuItem.addActionListener(this);
		fileMenu.add(menuItem);
		mb.add(fileMenu);

		JMenu scoreMenu = new JMenu("��������");
		menuItem = new JMenuItem("������");
		menuItem.addActionListener(this);
		scoreMenu.add(menuItem);
		menuItem = new JMenuItem("��޻���");
		menuItem.addActionListener(this);
		scoreMenu.add(menuItem);
		menuItem = new JMenuItem("�׷����ۼ�");
		menuItem.addActionListener(this);
		scoreMenu.add(menuItem);
		scoreMenu.addSeparator();
		menuItem = new JMenuItem("����");
		menuItem.addActionListener(this);
		scoreMenu.add(menuItem);
		mb.add(scoreMenu);
		setJMenuBar(mb);
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.add(new JButton(new ImageIcon("images/icon_open.png")));
		toolBar.add(new JButton(new ImageIcon("images/icon_save.png")));
		toolBar.add(new JButton(new ImageIcon("images/icon_chart.png")));
		toolBar.add(new JButton(new ImageIcon("images/icon_setting.png")));
		add(toolBar, BorderLayout.NORTH);
		add(mtp, BorderLayout.CENTER);

		updateAvg();

		this.setTitle("��������");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ScoreManager();

	}

	public void updateAvg() {
		int sum = 0;
		for (int i = 3; i < 11; i++) {
			for (int j = 0; j < courses.size() - 1; j++) {
				sum += (int) mtp.scoreTable.getValueAt(j, i);
			}
			mtp.scoreTable.setValueAt((int) sum / (courses.size() - 1), courses.size() - 1, i);
			sum = 0;
		}
	}

	public void addTotalCol() {
		TableColumn column = new TableColumn(11);
		column.setHeaderValue("����");
		column.setPreferredWidth(30);
		column.setCellRenderer(mtp.getFixCellCenter());
		mtp.scoreTable.addColumn(column);
		for (int i = 0; i < courses.size(); i++)
			mtp.scoreTable.setValueAt(courses.get(i).getTotalScore(ratio), i, 11);
	}

	public void addRankCol() {
		int ranking[] = new int[courses.size() - 1];
		int total[] = new int[courses.size() - 1];
		TableColumn column = new TableColumn(12);
		column.setHeaderValue("����");
		column.setPreferredWidth(30);
		column.setCellRenderer(mtp.getFixCellCenter());
		mtp.scoreTable.addColumn(column);
		for (int i = 0; i < courses.size() - 1; i++) {
			ranking[i] = 1;
			total[i] = (int) mtp.scoreTable.getValueAt(i, 11);
		}
		for (int i = 0; i < courses.size() - 1; i++)
			for (int j = 0; j < courses.size() - 1; j++)
				if (total[i] < total[j])
					ranking[i]++;
		for (int i = 0; i < courses.size() - 1; i++)
			mtp.scoreTable.setValueAt(ranking[i], i, 12);

	}

	public void addGradeCol() {
		TableColumn column = new TableColumn(13);
		column.setHeaderValue("���");
		column.setPreferredWidth(30);
		column.setCellRenderer(mtp.getFixCellCenter());
		mtp.scoreTable.addColumn(column);
		int[] ratios = grade.getAllRatio();
		String[] gradeString = { "A+", "A0", "B+", "B0", "C+", "C0", "D", "F" };
		int ratioSum;
		for (int i = 0; i < courses.size() - 1; i++) {
			ratioSum = 0;
			for (int j = 0; j < ratios.length; j++) {
				if ((int) mtp.scoreTable.getValueAt(i, 12) <= (ratioSum + ratios[j]) * (courses.size() - 1) / 100) {
					mtp.scoreTable.setValueAt(gradeString[j], i, 13);
					break;
				} else {
					ratioSum += ratios[j];
				}
			}
		}
	}
	
	public ArrayList<String> addGradeNum() {
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < courses.size(); i++) {
			arr.add((String) mtp.scoreTable.getValueAt(i, 13));
		}

		return arr;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "�ҷ�����":
			System.out.println("��������");
			break;
		case "��������":
			break;
		case "����":
			if (JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "����������",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				System.exit(1);
			break;
		case "������":
			new AttandManager(attandsModel);
			break;
		case "��޻���":
			addTotalCol();
			addRankCol();
			addGradeCol();
			JOptionPane.showMessageDialog(null, "��޻����� �Ϸ��߽��ϴ�.");
			break;
		case "�׷����ۼ�":
			new GraphTablePanel(courses, ratio, addGradeNum());
			break;
		case "����":
			break;
		}
	}

}
