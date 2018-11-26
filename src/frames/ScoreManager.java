package frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class ScoreManager extends JFrame implements ActionListener {
	private MainTablePanel mtp;
	
	public ScoreManager() {
		JMenuItem menuItem;
		KeyStroke key;
		
		mtp = new MainTablePanel();
		
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
		
		this.setTitle("��������");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ScoreManager();

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
			break;
		case "������":
			new AttandManager();
			System.out.println("���");
			break;
		case "��޻���":
			break;
		case "�׷����ۼ�":
			break;
		case "����":
			break;
		}		
	}

}
