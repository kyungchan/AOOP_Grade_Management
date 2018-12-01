package classes;

import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ClassTableModel extends AbstractTableModel {

	private String[] courseColumnNames = { "�й�", "�л��̸�", "�г�", "���(10%)", "�߰�(15%)", "�⸻(15%)", "����(20%)", "����(10%)",
			"��ǥ(10%)", "����(10%)", "��Ÿ(10%)" };
	private String[] attandColumnNames = { "�й�", "�л��̸�", "�г�", "�⼮", "����", "�Ἦ", "1��-1", "1��-2", "2��-1", "2��-2", "3��-1",
			"3��-2", "4��-1", "4��-2", "5��-1", "5��-2", "6��-1", "6��-2", "7��-1", "7��-2", "8��-1", "8��-2", "9��-1", "9��-2",
			"10��-1", "10��-2", "11��-1", "11��-2", "12��-1", "12��-2", "13��-1", "13��-2", "14��-1", "14��-2", "15��-1", "15��-2",
			"16��-1", "16��-2" };

	private LinkedList<Student> objectsData;
	private int ranks[];
	private int totals[];
	private String grades[];

	public ClassTableModel(Object[] students) {
		objectsData = new LinkedList<Student>(Arrays.asList((Student[]) students));
		ranks = new int[objectsData.size()];
		totals = new int[objectsData.size()];
		grades = new String[objectsData.size()];
		grades[0] = null; // Column ���� üũ��
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		if (row == getRowCount() - 1)
			return false;
		else if (column < 3)
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
		}
		fireTableDataChanged();
		super.setValueAt(value, row, column);
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
					return "��";
				case '2':
					return "��";
				}
			}
		}

		return null;
	}
}
