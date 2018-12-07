package frames;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
	private Boolean flagTotalCol = false;

	public ScoreManager() {
		coursesQueries = new CoursesQueries(DATABASE_URL, USERNAME, PASSWORD);
		attandsQueries = new AttandsQueries(DATABASE_URL, USERNAME, PASSWORD);
		courses = coursesQueries.getAllCourses();
		courses.add(new Course("평균", "", 0, 0, 0, 0, 0, 0, 0, 0, 0));
		attands = attandsQueries.getAllAttands();

		coursesModel = new ClassTableModel(courses.toArray(new Course[courses.size()]));
		attandsModel = new ClassTableModel(attands.toArray(new Attand[attands.size()]));

		ratio = new Ratio(10, 15, 15, 20, 10, 10, 10, 10, 3);
		grade = new Grade(10, 15, 15, 15, 15, 15, 10, 5);

		JMenuItem menuItem;
		KeyStroke key;

		mtp = new MainTablePanel(coursesModel);
		mtp.scoreTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				JTable table = (JTable) mouseEvent.getSource();
				Point point = mouseEvent.getPoint();
				int row = table.rowAtPoint(point);
				int col = table.columnAtPoint(point);
				if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1 && col == 3) {
					new AttandManager(attandsModel, attandsQueries, (String) mtp.scoreTable.getValueAt(row, 0));
				}
			}
		});

		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
		menuItem = new JMenuItem("불러오기");
		menuItem.addActionListener(this);
		fileMenu.add(menuItem);
		menuItem = new JMenuItem("내보내기");
		menuItem.addActionListener(this);
		fileMenu.add(menuItem);
		fileMenu.addSeparator();
		menuItem = new JMenuItem("종료");
		menuItem.addActionListener(this);
		fileMenu.add(menuItem);
		mb.add(fileMenu);

		JMenu scoreMenu = new JMenu("성적관리");
		menuItem = new JMenuItem("출결관리");
		menuItem.addActionListener(this);
		scoreMenu.add(menuItem);
		menuItem = new JMenuItem("등급산출");
		menuItem.addActionListener(this);
		scoreMenu.add(menuItem);
		menuItem = new JMenuItem("그래프작성");
		menuItem.addActionListener(this);
		scoreMenu.add(menuItem);
		scoreMenu.addSeparator();
		menuItem = new JMenuItem("설정");
		menuItem.addActionListener(this);
		scoreMenu.add(menuItem);
		mb.add(scoreMenu);
		setJMenuBar(mb);
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		JButton toolBarBtn;

		toolBarBtn = new JButton(new ImageIcon("images/icon_open.png"));
		toolBarBtn.setActionCommand("불러오기");
		toolBarBtn.addActionListener(this);
		toolBar.add(toolBarBtn);

		toolBarBtn = new JButton(new ImageIcon("images/icon_save.png"));
		toolBarBtn.setActionCommand("save");
		toolBarBtn.addActionListener(this);
		toolBar.add(toolBarBtn);

		toolBarBtn = new JButton(new ImageIcon("images/icon_chart.png"));
		toolBarBtn.setActionCommand("그래프작성");
		toolBarBtn.addActionListener(this);
		toolBar.add(toolBarBtn);

		toolBarBtn = new JButton(new ImageIcon("images/icon_setting.png"));
		toolBarBtn.setActionCommand("setting");
		toolBarBtn.addActionListener(this);
		toolBar.add(toolBarBtn);

		add(toolBar, BorderLayout.NORTH);
		add(mtp, BorderLayout.CENTER);

		updateAvg();
		mtp.getTableModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				int row = e.getFirstRow();
				int col = e.getColumn();
				if (row != 0) {
					String stuNum = (String) mtp.getTableModel().getValueAt(row, 0);
					if (coursesQueries.updateScore(stuNum, col - 3,
							(int) mtp.getTableModel().getValueAt(row, col)) != 1) {
						JOptionPane.showMessageDialog(null, "DB오류발생", "성적관리", JOptionPane.ERROR_MESSAGE);
					}
				}
				//
			}

		});

		this.setTitle("성적관리");
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
		if (!flagTotalCol) {
			TableColumn column = new TableColumn(11);
			column.setHeaderValue("총점");
			column.setPreferredWidth(30);
			column.setCellRenderer(mtp.getFixCellCenter());
			mtp.scoreTable.addColumn(column);
		}
		for (int i = 0; i < courses.size(); i++)
			mtp.scoreTable.setValueAt(courses.get(i).getTotalScore(ratio), i, 11);
	}

	public void addRankCol() {
		int ranking[] = new int[courses.size() - 1];
		int total[] = new int[courses.size() - 1];
		if (!flagTotalCol) {
			TableColumn column = new TableColumn(12);
			column.setHeaderValue("석차");
			column.setPreferredWidth(30);
			column.setCellRenderer(mtp.getFixCellCenter());
			mtp.scoreTable.addColumn(column);
		}
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
		if (!flagTotalCol) {
			TableColumn column = new TableColumn(13);
			column.setHeaderValue("등급");
			column.setPreferredWidth(30);
			column.setCellRenderer(mtp.getFixCellCenter());
			mtp.scoreTable.addColumn(column);
		}
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
		case "불러오기":
			System.out.println("ㅂㄹㅇㄱ");
			break;
		case "내보내기":
			break;
		case "종료":
			if (JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "성적관리자",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				System.exit(1);
			break;
		case "출결관리":
			new AttandManager(attandsModel, attandsQueries, null);
			break;
		case "등급산출":
			addTotalCol();
			addRankCol();
			addGradeCol();
			flagTotalCol = true;
			JOptionPane.showMessageDialog(null, "등급산출을 완료했습니다.\n성적 변경시 다시 등급산출을 해주세요.","성적관리", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "그래프작성":
			if (flagTotalCol)
				new GraphTablePanel(courses, ratio, addGradeNum());
			else
				JOptionPane.showMessageDialog(null, "등급산출을 먼저 실행해주세요.", "성적관리", JOptionPane.WARNING_MESSAGE);
			break;
		case "설정":
			break;
		}
	}

}
