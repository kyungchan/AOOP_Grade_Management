package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
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
	private String[] select= {"출결","중간","기말","과제","퀴즈","발표","보고서","기타","총점"} ;
	private List<Course> courses;
	private Ratio ratio;
	private ArrayList<Integer> chartData;
	private ArrayList<String> grade;
	private ArrayList<Integer> mid;
	private ArrayList<Integer> attand;
	private ArrayList<Integer> finalEx;
	private ArrayList<Integer> hw;
	private ArrayList<Integer> qz;
	private ArrayList<Integer> pt;
	private ArrayList<Integer> rp;
	private ArrayList<Integer> etc;
	JComboBox<String> sc;
	private int index;
	public GraphTablePanel(List<Course> courses, Ratio ratio, ArrayList<String> grade) {
		sc = new JComboBox<>(select);

		setAttand(attand);
		setMid(mid);
		setCourses(courses);
		setRatio(ratio);
		setGrade(grade);
		setFinal(finalEx);
		setHw(hw);
		setqz(qz);
		setPt(pt);
		setReport(rp);
		setEtc(etc);
		chartData = getChartData();
		mid=getMidScore();
		attand=getAttandScore();
		finalEx=getFinalScore();
		hw=getHwScore();
		qz=getQuizScore();
		pt=getPtScore();
		rp=getReportScore();
		etc=getEtcScore();
		setTitle("통계 그래프");
		c = getContentPane();
		c.setLayout(new FlowLayout());
		c.setLayout(new BorderLayout());
		
		
		
		
		
		ChartPanel chartPanel = new ChartPanel();
		c.add(chartPanel, BorderLayout.CENTER);
		setBounds(400, 400, 600, 500);

		sc.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {         
                JComboBox<String> box = (JComboBox<String>) e.getSource();
                 index = box.getSelectedIndex();
            }
           
        });
        
		chartPanel.add(sc);
		this.setVisible(true);
		
	}
	
	public void printTotalScore() {
		int sum = 0;
		
		for (int i = 0; i < chartData.size(); i++) {
			
			sum += chartData.get(i);
		}
		for (int i = 0; i <chartData.size(); i++) {
			
			percent[i] = (int) Math.round((double) chartData.get(i) / sum * 100);

		}
		for (int i = 0; i < chartData.size(); i++) {
			
			arc[i] = 360 * percent[i] / 100;

			
			
		}
	}
	public void printMidScore() {
		int sum = 0;
		
		for (int i = 0; i < mid.size(); i++) {
			sum += mid.get(i);
		}
		for (int i = 0; i < mid.size(); i++) {
			percent[i] = (int) Math.round((float) mid.get(i) / sum * 100);
			
		}
		for (int i = 0; i <mid.size(); i++) {
			arc[i] = 360 * percent[i] / 100;
		}
		
	}
	public void printAttandScore() {
		int sum = 0;

		for (int i = 0; i < attand.size(); i++) {
			sum += attand.get(i);
		}
		for (int i = 0; i < attand.size(); i++) {
			percent[i] = (int) Math.round((double) attand.get(i) / sum * 100);

		}
		for (int i = 0; i <attand.size(); i++) {
			arc[i] = 360 * percent[i] / 100;
		}
		
	}
	public void printFinalScore() {
		int sum = 0;

		for (int i = 0; i < finalEx.size(); i++) {
			sum += finalEx.get(i);
		}
		for (int i = 0; i < finalEx.size(); i++) {
			percent[i] = (int) Math.round((double) finalEx.get(i) / sum * 100);

		}
		for (int i = 0; i <finalEx.size(); i++) {
			arc[i] = 360 * percent[i] / 100;
		}
		
	}
	public void printHwScore() {
		int sum = 0;

		for (int i = 0; i < hw.size(); i++) {
			sum += hw.get(i);
		}
		for (int i = 0; i < hw.size(); i++) {
			percent[i] = (int) Math.round((double) hw.get(i) / sum * 100);

		}
		for (int i = 0; i <hw.size(); i++) {
			arc[i] = 360 * percent[i] / 100;
		}
		
	}
	public void printQuizScore() {
		int sum = 0;

		for (int i = 0; i < qz.size(); i++) {
			sum += qz.get(i);
		}
		for (int i = 0; i < qz.size(); i++) {
			percent[i] = (int) Math.round((double) qz.get(i) / sum * 100);

		}
		for (int i = 0; i <qz.size(); i++) {
			arc[i] = 360 * percent[i] / 100;
		}
		
	}
	public void printPtScore() {
		int sum = 0;

		for (int i = 0; i < pt.size(); i++) {
			sum += pt.get(i);
		}
		for (int i = 0; i < pt.size(); i++) {
			percent[i] = (int) Math.round((double) pt.get(i) / sum * 100);

		}
		for (int i = 0; i <pt.size(); i++) {
			arc[i] = 360 * percent[i] / 100;
		}
		
	}
	public void printReportScore() {
		int sum = 0;

		for (int i = 0; i < pt.size(); i++) {
			sum += pt.get(i);
		}
		for (int i = 0; i < pt.size(); i++) {
			percent[i] = (int) Math.round((double) pt.get(i) / sum * 100);

		}
		for (int i = 0; i <pt.size(); i++) {
			arc[i] = 360 * percent[i] / 100;
		}
		
	}
	public void printEtcScore() {
		int sum = 0;

		for (int i = 0; i < etc.size(); i++) {
			sum += etc.get(i);
		}
		for (int i = 0; i < etc.size(); i++) {
			percent[i] = (int) Math.round((double)etc.get(i) / sum * 100);

		}
		for (int i = 0; i <etc.size(); i++) {
			arc[i] = 360 * percent[i] / 100;
		}
		
	}
	public ArrayList<Integer> getEtcScore() {
		ArrayList<Integer> arr = new ArrayList<>();
		int k = 0, l = 0, m = 0, t = 0, a = 0, d = 0, s = 0, e = 0, w = 0, y = 0;
		for(int i=0;i<courses.size();i++) {
			int j=courses.get(i).getScoreEtc();
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
			else if (j <= 100)
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
	public ArrayList<Integer> getReportScore() {
		ArrayList<Integer> arr = new ArrayList<>();
		int k = 0, l = 0, m = 0, t = 0, a = 0, d = 0, s = 0, e = 0, w = 0, y = 0;
		for(int i=0;i<courses.size();i++) {
			int j=courses.get(i).getScoreReport();
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
			else if (j <= 100)
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
	public ArrayList<Integer> getPtScore() {
		ArrayList<Integer> arr = new ArrayList<>();
		int k = 0, l = 0, m = 0, t = 0, a = 0, d = 0, s = 0, e = 0, w = 0, y = 0;
		for(int i=0;i<courses.size();i++) {
			int j=courses.get(i).getScorePPT();
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
			else if (j <= 100)
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
	public ArrayList<Integer> getQuizScore() {
		ArrayList<Integer> arr = new ArrayList<>();
		int k = 0, l = 0, m = 0, t = 0, a = 0, d = 0, s = 0, e = 0, w = 0, y = 0;
		for(int i=0;i<courses.size();i++) {
			int j=courses.get(i).getScoreQuiz();
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
			else if (j <= 100)
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
	public ArrayList<Integer> getHwScore() {
		ArrayList<Integer> arr = new ArrayList<>();
		int k = 0, l = 0, m = 0, t = 0, a = 0, d = 0, s = 0, e = 0, w = 0, y = 0;
		for(int i=0;i<courses.size();i++) {
			int j=courses.get(i).getScoreHomework();
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
			else if (j <= 100)
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
	public ArrayList<Integer> getAttandScore() {
		ArrayList<Integer> arr = new ArrayList<>();
		int k = 0, l = 0, m = 0, t = 0, a = 0, d = 0, s = 0, e = 0, w = 0, y = 0;
		for(int i=0;i<courses.size();i++) {
			int j=courses.get(i).getScoreAttand();
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
			else if (j <= 100)
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
	public ArrayList<Integer> getFinalScore() {
		ArrayList<Integer> arr = new ArrayList<>();
		int k = 0, l = 0, m = 0, t = 0, a = 0, d = 0, s = 0, e = 0, w = 0, y = 0;
		for(int i=0;i<courses.size();i++) {
			int j=courses.get(i).getScoreFinal();
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
			else if (j <= 100)
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
	public ArrayList<Integer> getMidScore() {
		ArrayList<Integer> arr = new ArrayList<>();
		int k = 0, l = 0, m = 0, t = 0, a = 0, d = 0, s = 0, e = 0, w = 0, y = 0;
		for(int i=0;i<courses.size();i++) {
			int j=courses.get(i).getScoreMid();
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
			else if (j <= 100)
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
			else if (j <= 100)
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
	public void setMid(ArrayList<Integer> mid) {
		this.mid = mid;
	}
	public void setAttand(ArrayList<Integer> attand) {
		this.attand = attand;
	}
	public void setFinal(ArrayList<Integer> finalEx) {
		this.finalEx = finalEx;
	}
	public void setHw(ArrayList<Integer> hw) {
		this.hw = hw;
	}
	public void setqz(ArrayList<Integer> qz) {
		this.qz = qz;
	}
	public void setPt(ArrayList<Integer> pt) {
		this.pt = pt;
	}
	public void setReport(ArrayList<Integer> rp) {
		this.rp = rp;
	}
	public void setEtc(ArrayList<Integer> etc) {
		this.etc = etc;
	}
	class ChartPanel extends JPanel {
		String[] Score= {"A+","A","B+","B","C+","C","D","F"};
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int startAngle = 0;
		g.setFont(new Font("malgun", Font.BOLD, 15));
	
		if(index==0) {
			printAttandScore();
			repaint();
			for (int i = 0; i < score.length; i++) {
				g.setColor(col[i]);
				
				g.drawString(score[i]+" 점" + " : " + attand.get(i) + "" + " 명", 300, 100 + (i * 30));
				g.fillArc(50, 120, 200, 200, startAngle, arc[i]);
				startAngle += arc[i];
			}
		}
		else if(index==1) {
			printMidScore();
			repaint();
			for (int i = 0; i < score.length; i++) {
				g.setColor(col[i]);
				
				g.drawString(score[i]+" 점" + " : " + mid.get(i) + "" + " 명", 300, 100 + (i * 30));
				g.fillArc(50, 120, 200, 200, startAngle, arc[i]);
				startAngle += arc[i];
			}
		}
		else if(index==2) {
			printFinalScore();
			repaint();
			for (int i = 0; i < score.length; i++) {
				g.setColor(col[i]);
				
				g.drawString(score[i]+" 점" + " : " + finalEx.get(i) + "" + " 명", 300, 100 + (i * 30));
				g.fillArc(50, 120, 200, 200, startAngle, arc[i]);
				startAngle += arc[i];
			}
		}
		else if(index==3) {
			printHwScore();
			repaint();
			for (int i = 0; i < score.length; i++) {
				g.setColor(col[i]);
				
				g.drawString(score[i]+" 점" + " : " + hw.get(i) + "" + " 명", 300, 100 + (i * 30));
				g.fillArc(50, 120, 200, 200, startAngle, arc[i]);
				startAngle += arc[i];
			}
		}
		else if(index==4) {
			printQuizScore();
			repaint();
			for (int i = 0; i < score.length; i++) {
				g.setColor(col[i]);
				
				g.drawString(score[i]+" 점" + " : " + qz.get(i) + "" + " 명", 300, 100 + (i * 30));
				g.fillArc(50, 120, 200, 200, startAngle, arc[i]);
				startAngle += arc[i];
			}
		}
		else if(index==5) {
			printPtScore();
			repaint();
			for (int i = 0; i < score.length; i++) {
				g.setColor(col[i]);
				
				g.drawString(score[i]+" 점" + " : " + pt.get(i) + "" + " 명", 300, 100 + (i * 30));
				g.fillArc(50, 120, 200, 200, startAngle, arc[i]);
				startAngle += arc[i];
			}
		}
		else if(index==6) {
			printReportScore();
			repaint();
			for (int i = 0; i < score.length; i++) {
				g.setColor(col[i]);
				
				g.drawString(score[i]+" 점" + " : " + rp.get(i) + "" + " 명", 300, 100 + (i * 30));
				g.fillArc(50, 120, 200, 200, startAngle, arc[i]);
				startAngle += arc[i];
			}
		}	
		else if(index==7) {
			printEtcScore();
			repaint();
			for (int i = 0; i < score.length; i++) {
				g.setColor(col[i]);
				
				g.drawString(score[i]+" 점" + " : " + etc.get(i) + "" + " 명", 300, 100 + (i * 30));
				g.fillArc(50, 120, 200, 200, startAngle, arc[i]);
				startAngle += arc[i];
			}
		}	
		else if(index==8) {
			printTotalScore();
			repaint();
			for (int i = 0; i < score.length; i++) {
				
				//	i=i+1;
				g.setColor(col[i]);
				g.drawString(score[i]+" 점" + " : " + chartData.get(i) + "" + " 명", 300, 100 + (i * 30));
				g.fillArc(50, 120, 200, 200, startAngle, arc[i]);
				startAngle += arc[i];
			}
		}	
		
			g.setColor(col[4]);
			for(int i=0;i<Score.length;i++)
				g.drawString(Score[i]+" : "+getGradeNum().get(i) + "" + "명", 450, 100+i*40 );
		
		}
	}

}