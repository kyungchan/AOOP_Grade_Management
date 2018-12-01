package frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import classes.ClassTableModel;
import queries.AttandsQueries;

public class AttandManager extends JDialog implements ActionListener {
	private AttandTablePanel atp;
	private AttandsQueries attandsQueries;

	public AttandManager(ClassTableModel tableModel, AttandsQueries attandsQueries, String studentNum) {
		this.attandsQueries = attandsQueries;
		atp = new AttandTablePanel(tableModel);
		JToolBar toolBar = new JToolBar();
		JButton toolBarBtn;
		toolBar.setFloatable(false);
		toolBarBtn = new JButton(new ImageIcon("images/icon_check.png"));
		toolBarBtn.setActionCommand("check");
		toolBarBtn.addActionListener(this);
		toolBar.add(toolBarBtn);

		toolBarBtn = new JButton(new ImageIcon("images/icon_late.png"));
		toolBarBtn.addActionListener(this);
		toolBarBtn.setActionCommand("late");
		toolBar.add(toolBarBtn);

		toolBarBtn = new JButton(new ImageIcon("images/icon_miss.png"));
		toolBarBtn.addActionListener(this);
		toolBarBtn.setActionCommand("miss");
		toolBar.add(toolBarBtn);

		add(toolBar, BorderLayout.NORTH);
		add(atp, BorderLayout.CENTER);
		if (studentNum != null) {
			for (int i = 0; i < tableModel.getRowCount(); i++) {
				if (atp.getAttandModel().getValueAt(i, 0).equals(studentNum)) {
					atp.getScoreTable().requestFocus();
					atp.getScoreTable().changeSelection(i, 0, false, false);
					break;
				}
			}
		}

		this.setTitle("출결관리");
		this.pack();
		this.setModal(true);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int selectedCols[] = atp.getScoreTable().getSelectedColumns();
		int selectedRows[] = atp.getScoreTable().getSelectedRows();

		if (selectedCols.length != 0) {
			switch (e.getActionCommand()) {
			case "check":
				for (int row : selectedRows)
					for (int col : selectedCols)
						if (col > 5)
							if (attandsQueries.updateAttand((String) atp.getScoreTable().getValueAt(row, 0), col - 5,
									2) == 0)
								JOptionPane.showMessageDialog(null, "DB오류");
							else
								atp.getScoreTable().setValueAt(2, row, col);
				break;
			case "late":
				for (int row : selectedRows)
					for (int col : selectedCols)
						if (col > 5)
							if (attandsQueries.updateAttand((String) atp.getScoreTable().getValueAt(row, 0), col - 5,
									2) == 0)
								JOptionPane.showMessageDialog(null, "DB오류");
							else
								atp.getScoreTable().setValueAt(1, row, col);
				break;
			case "miss":
				for (int row : selectedRows)
					for (int col : selectedCols)
						if (col > 5)
							if (attandsQueries.updateAttand((String) atp.getScoreTable().getValueAt(row, 0), col - 5,
									2) == 0)
								JOptionPane.showMessageDialog(null, "DB오류");
							else
								atp.getScoreTable().setValueAt(0, row, col);
				break;
			}
		} else

		{
			JOptionPane.showMessageDialog(null, "변경할 항목을 선택하지 않았습니다.");
		}
	}
}
