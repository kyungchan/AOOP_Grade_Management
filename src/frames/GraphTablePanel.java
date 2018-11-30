package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import classes.Course;
import classes.Ratio;


@SuppressWarnings("serial")
public class GraphTablePanel extends JFrame {
	private Container c;
	private int[] data = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private int[] percent = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private int[] arc = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private Color[] col = { Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE, Color.BLACK, Color.CYAN,
			Color.DARK_GRAY, Color.GREEN, Color.PINK, Color.LIGHT_GRAY };
	private String[] score = { "0~9", "10~19", "20~29", "30~39", "40~49", "50~59", "60~69", "70~79", "80~89",
			"90~100" };
	private List<Course> courses;
	private Ratio ratio;
	private ArrayList<Integer> chartData;
	private ArrayList<String> grade;
	public GraphTablePanel(List<Course> courses, Ratio ratio, ArrayList<String> grade) {

		setCourses(courses);
		setRatio(ratio);
		setGrade(grade);
		chartData = getChartData();
		setTitle("통계 그래프");
		c = getContentPane();

		c.setLayout(new BorderLayout());

		ChartPanel chartPanel = new ChartPanel();
		c.add(chartPanel, BorderLayout.CENTER);
		setBounds(400, 400, 600, 500);

		int sum = 0;

		for (int i = 0; i < data.length; i++) {
			sum += chartData.get(i);
		}
		for (int i = 0; i < data.length; i++) {
			percent[i] = (int) Math.round((double) chartData.get(i) / sum * 100);

		}
		for (int i = 0; i < data.length; i++) {
			arc[i] = 360 * percent[i] / 100;

			this.setVisible(true);
			
		}
	}

	public ArrayList<Integer> getChartData() {
		ArrayList<Integer> arr = new ArrayList<>();
		int k = 0, l = 0, m = 0, t = 0, a = 0, d = 0, s = 0, e = 0, w = 0, y = 0;
		for (int i = 0; i < courses.size(); i++) {
			int j = courses.get(i).getTotalScore(ratio);
			if (j < 10)
				k++;
			else if (j < 20)
				l++;
			else if (j < 30)
				m++;
			else if (j < 40)
				t++;
			else if (j < 50)
				a++;
			else if (j < 60)
				d++;
			else if (j < 70)
				s++;
			else if (j < 80)
				e++;
			else if (j < 90)
				w++;
			else if (j < 100)
				y++;
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
	public ArrayList<String> getGrade(){
		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < courses.size(); i++) {
			arr.add(grade.get(i));
		}
		return arr;
	}
	
	public ArrayList<Integer> getGradeNum() {
		ArrayList<Integer> arr = new ArrayList<>();
		int ap=0,a=0,bp=0,b=0,cp=0,c=0,d=0,f=0;
		for(int i=0;i<courses.size();i++) {
			if(getGrade().get(i)=="A+")  { ap++;}
			else if(getGrade().get(i)=="A0") { a++;}
			else if(getGrade().get(i)=="B+") { bp++;}
			else if(getGrade().get(i)=="B0") {b++;}
			else if(getGrade().get(i)=="C+") { cp++;}
			else if(getGrade().get(i)=="C0") {c++;}
			else if(getGrade().get(i)=="D") {d++;}
			else {f++;}
			}
		arr.add(ap);
		arr.add(a);
		arr.add(bp);
		arr.add(b);
		arr.add(cp);
		arr.add(c);
		arr.add(d);
		arr.add(f);
	
		return arr;
		
	}
	
	public void setRatio(Ratio ratio) {
		this.ratio = ratio;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public void setGrade(ArrayList<String> grade) {
		this.grade = grade;
	}
	class ChartPanel extends JPanel {
		String[] Score= {"A+","A","B+","B","C+","C","D","F"};
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int startAngle = 0;

			g.setFont(new Font("malgun", Font.BOLD, 15));
			for (int i = 0; i < data.length; i++) {
				g.setColor(col[i]);
				g.drawString(score[i]+" 점" + " : " + percent[i] + "" + " 명", 300, 100 + (i * 30));
			
				g.fillArc(50, 120, 200, 200, startAngle, arc[i]);
				startAngle += arc[i];
			}
			
			g.setColor(col[4]);
			for(int i=0;i<Score.length;i++)
				g.drawString(Score[i]+" : "+getGradeNum().get(i) + "" + "명", 450, 100+i*40 );
		
		}
	}

}