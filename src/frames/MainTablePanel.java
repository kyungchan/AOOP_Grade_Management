package frames;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainTablePanel extends JPanel {
	public MainTablePanel() {
		String[] columnNames = {"학번", "학년", "학생이름", "출결(10%)", "중간(30%)", "레포트1(10%)", "레포트2(15%)", "기말(30%)", "총점", "순위", "등급"};
		Object[][] data = {
				{"60142626", "3", "김김김", "100","100","100","0","80","79","1","A"},
				{"60142525", "4", "이이이", "90","95","30","50","30","54","3","B"},
				{"60121212", "2", "박박박", "80","20","20","70","10","66","2","C"},
				{"60142626", "3", "김김김", "100","100","100","0","80","79","1","A"},
				{"60142525", "4", "이이이", "90","95","30","50","30","54","3","B"},
				{"60121212", "2", "박박박", "80","20","20","70","10","66","2","C"}
		};
		JTable scoreTable = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(scoreTable);
		scrollPane.setPreferredSize(new Dimension(600, 200));
		scoreTable.setCellSelectionEnabled(true);
		setLayout(new GridLayout(1, 0));
		add(scrollPane);
	}
}
