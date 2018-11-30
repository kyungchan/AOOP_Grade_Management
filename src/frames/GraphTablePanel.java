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

	public GraphTablePanel(List<Course> courses, Ratio ratio) {
		setCourses(courses);
		setRatio(ratio);
		chartData = getChartData();
		setTitle("통계 그래프");
		c = getContentPane();

		c.setLayout(new BorderLayout());

		ChartPanel chartPanel = new ChartPanel();
		c.add(chartPanel, BorderLayout.CENTER);
		setBounds(400, 400, 450, 450);

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

	public void setRatio(Ratio ratio) {
		this.ratio = ratio;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	class ChartPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int startAngle = 0;

			g.setFont(new Font("malgun", Font.BOLD, 15));
			for (int i = 0; i < data.length; i++) {
				g.setColor(col[i]);
				g.drawString(score[i] + ":" + percent[i] + "" + " %", 300, 100 + (i * 30));
				g.fillArc(50, 120, 200, 200, startAngle, arc[i]);
				startAngle += arc[i];
			}

		}
	}

}