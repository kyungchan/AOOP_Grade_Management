package classes;

import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ClassTableModel extends AbstractTableModel {

	private String[] courseColumnNames = { "학번", "학생이름", "학년", "출결(10%)", "중간(15%)", "기말(15%)", "과제(20%)", "퀴즈(10%)",
			"발표(10%)", "보고서(10%)", "기타(10%)" };
	private String[] attandColumnNames = { "학번", "학생이름", "학년", "출석", "지각", "결석", "1주-1", "1주-2", "2주-1", "2주-2", "3주-1",
			"3주-2", "4주-1", "4주-2", "5주-1", "5주-2", "6주-1", "6주-2", "7주-1", "7주-2", "8주-1", "8주-2", "9주-1", "9주-2",
			"10주-1", "10주-2", "11주-1", "11주-2", "12주-1", "12주-2", "13주-1", "13주-2", "14주-1", "14주-2", "15주-1", "15주-2",
			"16주-1", "16주-2" };

	private LinkedList<Student> objectsData;
	private int ranks[];
	private int totals[];
	private String grades[];

	public ClassTableModel(Object[] students) {
		objectsData = new LinkedList<Student>(Arrays.asList((Student[]) students));
		ranks = new int[objectsData.size()];
		totals = new int[objectsData.size()];
		grades = new String[objectsData.size()];
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		if (column < 4)
			return false;
		else if (column > 10)
			return false;
		else
			return true;
	}

	@Override
	public Class getColumnClass(int column) throws IllegalStateException {
		if (column < 2) {
			return String.class;
		} else if (column == 13) {
			return String.class;
		} else {
			return Integer.class;
		}
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		if (objectsData.get(row) instanceof Course) {
			if (value instanceof Integer) {
				if ((int) value > 100 || (int) value < 0 && column >= 2 && column <= 10) {
					JOptionPane.showMessageDialog(null, "점수는 0에서 100사이만 가능합니다.", "성적관리", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			switch (column) {
			case 0:
				((Course) objectsData.get(row)).setStuNumber((String) value);
				break;
			case 1:
				((Course) objectsData.get(row)).setName((String) value);
				break;
			case 2:
				((Course) objectsData.get(row)).setStuGrade((Integer) value);
				break;
			case 3:
				((Course) objectsData.get(row)).setScoreAttand((Integer) value);
				break;
			case 4:
				((Course) objectsData.get(row)).setScoreMid((Integer) value);
				break;
			case 5:
				((Course) objectsData.get(row)).setScoreFinal((Integer) value);
				break;
			case 6:
				((Course) objectsData.get(row)).setScoreHomework((Integer) value);
				break;
			case 7:
				((Course) objectsData.get(row)).setScoreQuiz((Integer) value);
				break;
			case 8:
				((Course) objectsData.get(row)).setScorePPT((Integer) value);
				break;
			case 9:
				((Course) objectsData.get(row)).setScoreReport((Integer) value);
				break;
			case 10:
				((Course) objectsData.get(row)).setScoreEtc((Integer) value);
				break;
			case 11:
				totals[row] = (Integer) value;
				break;
			case 12:
				ranks[row] = (Integer) value;
				break;
			case 13:
				grades[row] = (String) value;
				break;
			}
			if(column <= 10) {
				fireTableCellUpdated(row, column);
			}
		} else if (objectsData.get(row) instanceof Attand) {
			if (column < 3) {
				switch (column) {
				case 0:
					((Attand) objectsData.get(row)).setStuNumber((String) value);
					break;
				case 1:
					((Attand) objectsData.get(row)).setName((String) value);
					break;
				case 2:
					((Attand) objectsData.get(row)).setStuGrade((Integer) value);
					break;
				}
			} else {
				System.out.println(row + "." + column);
				((Attand) objectsData.get(row)).setAttand(column - 6, (Integer) value);
			}
			fireTableCellUpdated(row, column);
		}
		fireTableDataChanged();
	}

	public void addRow(Student student) {
		objectsData.add(student);
		fireTableDataChanged();
	}

	public void removeRow(int row) {
		objectsData.remove(row - 1);
		fireTableRowsDeleted(row - 1, row - 1);
	}

	@Override
	public int getColumnCount() throws IllegalStateException {
		if (objectsData.get(0) instanceof Course) {
			if (grades[0] == null)
				return courseColumnNames.length;
			else
				return courseColumnNames.length + 3;
		} else if (objectsData.get(0) instanceof Attand)
			return attandColumnNames.length;
		return 0;
	}

	@Override
	public String getColumnName(int column) throws IllegalStateException {
		if (objectsData.get(0) instanceof Course)
			return courseColumnNames[column];
		else if (objectsData.get(0) instanceof Attand)
			return attandColumnNames[column];
		return "";
	}

	@Override
	public int getRowCount() throws IllegalStateException {
		return objectsData.size();
	}

	@Override
	public Object getValueAt(int row, int column) throws IllegalStateException {
		if (objectsData.get(row) instanceof Course) {
			switch (column) {
			case 0:
				return ((Course) objectsData.get(row)).getStuNumber();
			case 1:
				return ((Course) objectsData.get(row)).getName();
			case 2:
				return ((Course) objectsData.get(row)).getStuGrade();
			case 3:
				return ((Course) objectsData.get(row)).getScoreAttand();
			case 4:
				return ((Course) objectsData.get(row)).getScoreMid();
			case 5:
				return ((Course) objectsData.get(row)).getScoreFinal();
			case 6:
				return ((Course) objectsData.get(row)).getScoreHomework();
			case 7:
				return ((Course) objectsData.get(row)).getScoreQuiz();
			case 8:
				return ((Course) objectsData.get(row)).getScorePPT();
			case 9:
				return ((Course) objectsData.get(row)).getScoreReport();
			case 10:
				return ((Course) objectsData.get(row)).getScoreEtc();
			case 11:
				return totals[row];
			case 12:
				return ranks[row];
			case 13:
				return grades[row];
			}
		} else if (objectsData.get(row) instanceof Attand) {
			if (column < 6) {
				switch (column) {
				case 0:
					return ((Attand) objectsData.get(row)).getStuNumber();
				case 1:
					return ((Attand) objectsData.get(row)).getName();
				case 2:
					return ((Attand) objectsData.get(row)).getStuGrade();
				case 3:
					return ((Attand) objectsData.get(row)).getCheck();
				case 4:
					return ((Attand) objectsData.get(row)).getLate();
				case 5:
					return ((Attand) objectsData.get(row)).getMiss();
				}
			} else {
				switch (((Attand) objectsData.get(row)).getSerialAttand().charAt(column - 6)) {
				case '0':
					return "X";
				case '1':
					return "△";
				case '2':
					return "○";
				}
			}
		}

		return null;
	}
}
