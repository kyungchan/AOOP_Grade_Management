package frames;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class Setting extends JDialog {
	public Setting() {
		setLayout(new GridLayout(7, 1));
		add(new JLabel("�����ݿ�����"));
		add(new JLabel("�����ݿ�����"));
		this.setTitle("����");
		this.pack();
		this.setModal(true);
		this.setVisible(true);
	}
}
