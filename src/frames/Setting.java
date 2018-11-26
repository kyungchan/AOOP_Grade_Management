package frames;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class Setting extends JDialog {
	public Setting() {
		setLayout(new GridLayout(7, 1));
		add(new JLabel("성적반영비율"));
		add(new JLabel("성적반영비율"));
		this.setTitle("설정");
		this.pack();
		this.setModal(true);
		this.setVisible(true);
	}
}
