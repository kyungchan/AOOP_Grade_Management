package frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
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
		attands = attandsQueries.getAllAttands();

		coursesModel = new ClassTableModel(courses.toArray(new Course[courses.size()]));
		attandsModel = new ClassTableModel(attands.toArray(new Attand[attands.size()]));

		ratio = new Ratio(10, 15, 15, 20, 10, 10, 10, 10, 3);
		grade = new Grade(10, 15, 15, 15, 15, 15, 10, 5);

		JMenuItem menuItem;
		KeyStroke key;

		mtp = new MainTablePanel(coursesModel);

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
		toolBar.add(new JButton(new ImageIcon("images/icon_open.png")));
		toolBar.add(new JButton(new ImageIcon("images/icon_save.png")));
		toolBar.add(new JButton(new ImageIcon("images/icon_chart.png")));
		toolBar.add(new JButton(new ImageIcon("images/icon_setting.png")));
		add(toolBar, BorderLayout.NORTH);
		add(mtp, BorderLayout.CENTER);

		this.setTitle("성적관리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ScoreManager();

	}

	public void addGradeCol() {
		TableColumn column = new TableColumn(13);
		column.setHeaderValue("등급");
		column.setPreferredWidth(30);
		mtp.scoreTable.addColumn(column);
		int[] ratios = grade.getAllRatio();
		String[] gradeString = { "A+", "A0", "B+", "B0", "C+", "C0", "D", "F" };
		int ratioSum;
		for (int i = 0; i < courses.size(); i++) {
			ratioSum = 0;
			for (int j = 0; j < ratios.length; j++) {
				if ((int) mtp.scoreTable.getValueAt(i, 12) <= (ratioSum + ratios[j]) * courses.size() / 100) {
					mtp.scoreTable.setValueAt(gradeString[j], i, 13);
					break;
				} else {
					ratioSum += ratios[j];
				}
			}
		}
	}
	int j=0;
	ArrayList<Integer> arr = new ArrayList<>();
		public ArrayList<Integer> Num() {
			int k=0,l=0,m=0,t=0,a=0,d=0,s=0,e=0,w=0,y=0;
			for (int i = 0; i < courses.size(); i++) {
			int j = courses.get(i).getTotalScore(ratio);
			if( j<10) k++;
			else if(j<20) l++;
			else if(j<30) m++;
			else if(j<40) t++;
			else if(j<50) a++;
			else if(j<60) d++;
			else if(j<70) s++;
			else if(j<80) e++;
			else if(j<90) w++;
			else if(j<100) y++;
			}
			arr.add(k);
			arr.add(l);
			arr.add(m);
			arr.add(t);
			arr.add(a);
			arr.add(d);
			arr.add(s);
			arr.add(e);
			arr.add(w);
			arr.add(y);
			return arr;
		}
	public void addTotalCol() {
		TableColumn column = new TableColumn(11);
		column.setHeaderValue("총점");
		column.setPreferredWidth(30);
		mtp.scoreTable.addColumn(column);
		for (int i = 0; i < courses.size(); i++)
			mtp.scoreTable.setValueAt(courses.get(i).getTotalScore(ratio), i, 11);
	}

	public void addRankCol() {
		int ranking[] = new int[courses.size()];
		int total[] = new int[courses.size()];
		TableColumn column = new TableColumn(12);
		column.setHeaderValue("석차");
		column.setPreferredWidth(30);
		mtp.scoreTable.addColumn(column);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "불러오기":
			System.out.println("ㅂㄹㅇㄱ");
			break;
		case "내보내기":
			break;
		case "종료":
			System.exit(1);
			break;
		case "출결관리":
			new AttandManager(attandsModel);
			System.out.println("모달");
			break;
		case "등급산출":
			addTotalCol();
			addRankCol();
			addGradeCol();
			break;
		case "그래프작성":
			new GraphTablePanel();
			break;
		case "설정":
			break;
		}
	}

}
