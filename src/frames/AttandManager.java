package frames;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class AttandManager extends JDialog {
	public AttandManager() {
		AttandTablePanel atp = new AttandTablePanel();
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.add(new JButton(new ImageIcon("images/icon_check.png")));
		toolBar.add(new JButton(new ImageIcon("images/icon_late.png")));
		toolBar.add(new JButton(new ImageIcon("images/icon_miss.png")));
		add(toolBar, BorderLayout.NORTH);
		add(atp, BorderLayout.CENTER);
		this.setTitle("출결관리");
		this.pack();
		this.setModal(true);
		this.setVisible(true);
	}
}
