package frames;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class ScoreManager extends JFrame {
	private MainTablePanel mtp;
	
	public ScoreManager() {
		JMenuItem menuItem;
		KeyStroke key;
		
		mtp = new MainTablePanel();
		
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
		menuItem = new JMenuItem("불러오기");
		fileMenu.add(menuItem);
		menuItem = new JMenuItem("내보내기");
		fileMenu.add(menuItem);
		fileMenu.addSeparator();
		menuItem = new JMenuItem("종료");
		fileMenu.add(menuItem);
		mb.add(fileMenu);
		
		JMenu scoreMenu = new JMenu("성적관리");
		menuItem = new JMenuItem("출결관리");
		scoreMenu.add(menuItem);
		menuItem = new JMenuItem("등급산출");
		scoreMenu.add(menuItem);
		menuItem = new JMenuItem("그래프작성");
		scoreMenu.add(menuItem);
		scoreMenu.addSeparator();
		menuItem = new JMenuItem("설정");
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

}
