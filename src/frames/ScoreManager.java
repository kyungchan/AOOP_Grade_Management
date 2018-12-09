package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import classes.Attand;
import classes.ClassTableModel;
import classes.Course;
import classes.Grade;
import classes.Ratio;
import classes.csvIO;
import queries.AttandsQueries;
import queries.CoursesQueries;
import queries.SettingQueries;

public class ScoreManager extends JFrame implements ActionListener {
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/grademanager?characterEncoding=UTF-8&serverTimezone=UTC";
	static final String USERNAME = "root";
	static final String PASSWORD = "pass";

	private csvIO csvManager;
	private Ratio ratio;
	private Grade grade;
	private JLabel avgLabel;
	private MainTablePanel mtp;
	private List<Course> courses;
	private List<Attand> attands;
	private CoursesQueries coursesQueries;
	private AttandsQueries attandsQueries;
	private SettingQueries ratioQueries;
	private ClassTableModel coursesModel;
	private ClassTableModel attandsModel;
	private Boolean flagTotalCol = false;

	public ScoreManager() {
		coursesQueries = new CoursesQueries(DATABASE_URL, USERNAME, PASSWORD);
		attandsQueries = new AttandsQueries(DATABASE_URL, USERNAME, PASSWORD);
		ratioQueries = new SettingQueries(DATABASE_URL, USERNAME, PASSWORD);
		courses = coursesQueries.getAllCourses();
		attands = attandsQueries.getAllAttands();

		coursesModel = new ClassTableModel(courses.toArray(new Course[courses.size()]));
		attandsModel = new ClassTableModel(attands.toArray(new Attand[attands.size()]));

		if (ratioQueries.getPrivacy() == 1)
			coursesModel.setPrivacy(true);
		else
			coursesModel.setPrivacy(false);
		ratio = ratioQueries.getRatio();
		grade = ratioQueries.getGrade();

		JMenuItem menuItem;
		KeyStroke key;

		mtp = new MainTablePanel(coursesModel);
		mtp.scoreTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				JTable table = (JTable) mouseEvent.getSource();
				Point point = mouseEvent.getPoint();
				System.out.println(table.getSelectedRow());
				int row = table.rowAtPoint(point);
				int col = table.columnAtPoint(point);
				if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1 && col == 3) {
					new AttandManager(attandsModel, coursesModel, attandsQueries, coursesQueries,
							courses.get(mtp.getSorter().convertRowIndexToModel(row)).getStuNumber());
				}
			}
		});
		mtp.updateColNames(ratio);

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
		JButton toolBarBtn;

		toolBarBtn = new JButton(new ImageIcon("images/icon_open.png"));
		toolBarBtn.setActionCommand("�ҷ�����");
		toolBarBtn.addActionListener(this);
		toolBar.add(toolBarBtn);

		toolBarBtn = new JButton(new ImageIcon("images/icon_save.png"));
		toolBarBtn.setActionCommand("��������");
		toolBarBtn.addActionListener(this);
		toolBar.add(toolBarBtn);

		toolBarBtn = new JButton(new ImageIcon("images/icon_chart.png"));
		toolBarBtn.setActionCommand("�׷����ۼ�");
		toolBarBtn.addActionListener(this);
		toolBar.add(toolBarBtn);

		toolBarBtn = new JButton(new ImageIcon("images/icon_search.png"));
		toolBarBtn.setActionCommand("�˻�");
		toolBarBtn.addActionListener(this);
		toolBar.add(toolBarBtn);

		toolBarBtn = new JButton(new ImageIcon("images/icon_setting.png"));
		toolBarBtn.setActionCommand("����");
		toolBarBtn.addActionListener(this);
		toolBar.add(toolBarBtn);

		add(toolBar, BorderLayout.NORTH);
		add(mtp, BorderLayout.CENTER);

		mtp.getTableModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				int row = e.getFirstRow();
				int col = e.getColumn();
				if (row != 0) {
					String stuNum = courses.get(row).getStuNumber();
					if (coursesQueries.updateScore(stuNum, col - 3,
							(int) mtp.getTableModel().getValueAt(row, col)) != 1) {
						JOptionPane.showMessageDialog(null, "DB�����߻�", "��������", JOptionPane.ERROR_MESSAGE);
					}
					updateAvg();
				}
				//
			}

		});
		renewAttandCol();
		csvManager = new csvIO(courses, attands);

		avgLabel = new JLabel("������");
		add(avgLabel, BorderLayout.SOUTH);

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
		List<Integer> avgList = new ArrayList<>();
		for (int i = 3; i < 11; i++) {
			for (int j = 0; j < courses.size(); j++) {
				sum += (int) mtp.scoreTable.getValueAt(j, i);
			}
			avgList.add((int) sum / (courses.size()));
			sum = 0;
		}
		avgLabel.setText(" (���) ���: " + avgList.get(0) + " | �߰�: " + avgList.get(1) + " | �⸻: " + avgList.get(2)
				+ " | ����: " + avgList.get(3) + " | ����: " + avgList.get(4) + " | ��ǥ: " + avgList.get(5) + " | ����: "
				+ avgList.get(6) + " | ��Ÿ: " + avgList.get(7));
	}

	public void addTotalCol() {
		if (!flagTotalCol) {
			TableColumn column = new TableColumn(11);
			column.setHeaderValue("����");
			column.setPreferredWidth(30);
			column.setCellRenderer(mtp.getFixCellCenter());
			mtp.scoreTable.addColumn(column);
		}
		for (int i = 0; i < courses.size(); i++)
			mtp.scoreTable.setValueAt(courses.get(i).getTotalScore(ratio), i, 11);
	}

	public void addRankCol() {
		int ranking[] = new int[courses.size()];
		int total[] = new int[courses.size()];
		if (!flagTotalCol) {
			TableColumn column = new TableColumn(12);
			column.setHeaderValue("����");
			column.setPreferredWidth(30);
			column.setCellRenderer(mtp.getFixCellCenter());
			mtp.scoreTable.addColumn(column);
		}
		for (int i = 0; i < courses.size(); i++) {
			ranking[i] = 1;
			total[i] = (int) mtp.scoreTable.getValueAt(i, 11);
		}
		for (int i = 0; i < courses.size(); i++)
			for (int j = 0; j < courses.size(); j++)
				if (total[i] < total[j])
					ranking[i]++;
		for (int i = 0; i < courses.size(); i++)
			mtp.scoreTable.setValueAt(ranking[i], i, 12);

	}

	public void renewAttandCol() {
		mtp.scoreTable.setDefaultRenderer(Integer.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if (column == 3) {
					c.setBackground(((int) value) > 70 ? Color.WHITE : Color.decode("#ffcccc"));
				}
				return c;
			}
		});
	}
	// }

	public void addGradeCol() {
		if (!flagTotalCol) {
			TableColumn column = new TableColumn(13);
			column.setHeaderValue("���");
			column.setPreferredWidth(30);
			column.setCellRenderer(mtp.getFixCellCenter());
			mtp.scoreTable.addColumn(column);
		}
		int[] ratios = grade.getAllRatio();
		String[] gradeString = { "A+", "A0", "B+", "B0", "C+", "C0", "D", "F" };
		int ratioSum;
		for (int i = 0; i < courses.size(); i++) {
			ratioSum = 0;
			for (int j = 0; j < ratios.length; j++) {
				if ((int) mtp.scoreTable.getValueAt(i, 12) <= (ratioSum + ratios[j]) * (courses.size()) / 100) {
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
			JOptionPane.showMessageDialog(null, "�� �۾��� �ϸ� ������ �ڷ�� ��� �����˴ϴ�.", "��������", JOptionPane.WARNING_MESSAGE);
			csvManager.importCSV();
			this.attands = csvManager.getAttands();
			this.courses = csvManager.getCourses();
			coursesModel = new ClassTableModel(courses.toArray(new Course[courses.size()]));
			attandsModel = new ClassTableModel(attands.toArray(new Attand[attands.size()]));
			attandsQueries.deleteAll();
			for (int i = 0; i < courses.size(); i++) {
				Attand tempAttand = attands.get(i);
				Course tempCourse = courses.get(i);
				attandsQueries.insertAll(tempAttand.getName(), tempAttand.getStuNumber(), tempAttand.getStuGrade(),
						tempCourse.getScoreAttand(), tempCourse.getScoreMid(), tempCourse.getScoreFinal(),
						tempCourse.getScoreHomework(), tempCourse.getScoreQuiz(), tempCourse.getScorePPT(),
						tempCourse.getScoreReport(), tempCourse.getScoreEtc(), tempAttand.getSerialAttand());
			}
			mtp.scoreTable.setModel(coursesModel);
			mtp.setTableApper();
			break;
		case "��������":
			csvManager.exportCSV();
			break;
		case "����":
			if (JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "����������",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				System.exit(1);
			break;
		case "������":
			new AttandManager(attandsModel, coursesModel, attandsQueries, coursesQueries, null);
			break;
		case "��޻���":
			addTotalCol();
			addRankCol();
			addGradeCol();
			flagTotalCol = true;
			JOptionPane.showMessageDialog(null, "��޻����� �Ϸ��߽��ϴ�.\n���� ����� �ٽ� ��޻����� ���ּ���.", "��������",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		case "�׷����ۼ�":
			if (flagTotalCol)
				new GraphTablePanel(courses, ratio, addGradeNum());
			else
				JOptionPane.showMessageDialog(null, "��޻����� ���� �������ּ���.", "��������", JOptionPane.WARNING_MESSAGE);
			break;
		case "�˻�":
			String keyword = JOptionPane.showInputDialog("�˻��� �й��� �Է��ϼ���", "�˻�");
			if (keyword != null)
				for (int i = 0; i < courses.size(); i++) {
					if (courses.get(i).getStuNumber().equals(keyword)) {
						mtp.scoreTable.changeSelection(mtp.getSorter().convertRowIndexToView(i), 0, false, false);
						break;
					}
					if (i == courses.size() - 1)
						JOptionPane.showMessageDialog(null, "�ش� �л��� ã�� �� �����ϴ�,", "��������", JOptionPane.ERROR_MESSAGE);
				}
			break;
		case "����":
			JDialog sm = new SettingManager(ratio, grade, ratioQueries);
			sm.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosed(WindowEvent arg0) {
					if (ratioQueries.getPrivacy() == 1)
						coursesModel.setPrivacy(true);
					else
						coursesModel.setPrivacy(false);
					mtp.updateColNames(ratio);
					super.windowClosed(arg0);
				}

			});
			break;
		}
	}

}
