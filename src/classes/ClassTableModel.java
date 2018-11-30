package classes;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ClassTableModel extends AbstractTableModel {

	private String[] courseColumnNames = { "�й�", "�л��̸�", "�г�", "���(10%)", "�߰�(15%)", "�⸻(15%)", "����(20%)", "����(10%)",
			"��ǥ(10%)", "����(10%)", "��Ÿ(10%)" };
	private String[] attandColumnNames = { "�й�", "�л��̸�", "�г�", "1��-1", "1��-2", "2��-1", "2��-2", "3��-1", "3��-2", "4��-1",
			"4��-2", "5��-1", "5��-2", "6��-1", "6��-2", "7��-1", "7��-2", "8��-1", "8��-2", "9��-1", "9��-2", "10��-1", "10��-2",
			"11��-1", "11��-2", "12��-1", "12��-2", "13��-1", "13��-2", "14��-1", "14��-2", "15��-1", "15��-2", "16��-1",
			"16��-2" };

	private Student[] objectsData;
	private int ranks[];
	private int totals[];
	private String grades[];

	public ClassTableModel(Object[] students) {
		objectsData = (Student[]) students;
		ranks = new int[objectsData.length];
		totals = new int[objectsData.length];
		grades = new String[objectsData.length];
	}

	
	
	@Override
	public boolean isCellEditable(int row, int column) {
		if(row == getRowCount()-1)
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
		if (objectsData[row] instanceof Course) {
			switch (column) {
			case 0:
				((Course) objectsData[row]).setStuNumber((String) value);
				break;
			case 1:
				((Course) objectsData[row]).setName((String) value);
				break;
			case 2:
				((Course) objectsData[row]).setStuGrade((Integer) value);
				break;
			case 3:
				((Course) objectsData[row]).setScoreAttand((Integer) value);
				break;
			case 4:
				((Course) objectsData[row]).setScoreMid((Integer) value);
				break;
			case 5:
				((Course) objectsData[row]).setScoreFinal((Integer) value);
				break;
			case 6:
				((Course) objectsData[row]).setScoreHomework((Integer) value);
				break;
			case 7:
				((Course) objectsData[row]).setScoreQuiz((Integer) value);
				break;
			case 8:
				((Course) objectsData[row]).setScorePPT((Integer) value);
				break;
			case 9:
				((Course) objectsData[row]).setScoreReport((Integer) value);
				break;
			case 10:
				((Course) objectsData[row]).setScoreEtc((Integer) value);
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
		} else if (objectsData[row] instanceof Attand) {
			if (column < 3) {
				switch (column) {
				case 0:
					((Attand) objectsData[row]).setStuNumber((String) value);
					break;
				case 1:
					((Attand) objectsData[row]).setName((String) value);
					break;
				case 2:
					((Attand) objectsData[row]).setStuGrade((Integer) value);
					break;
				}
			} else {
				((Attand) objectsData[row]).getSerialAttand();
			}
		}
		super.setValueAt(value, row, column);
	}

	@Override
	public int getColumnCount() throws IllegalStateException {
		if (objectsData[0] instanceof Course)
			return courseColumnNames.length;
		else if (objectsData[0] instanceof Attand)
			return attandColumnNames.length;
		return 0;
	}

	@Override
	public String getColumnName(int column) throws IllegalStateException {
		if (objectsData[0] instanceof Course)
			return courseColumnNames[column];
		else if (objectsData[0] instanceof Attand)
			return attandColumnNames[column];
		return "";
	}

	@Override
	public int getRowCount() throws IllegalStateException {
		return objectsData.length;
	}

	@Override
	public Object getValueAt(int row, int column) throws IllegalStateException {
		if (objectsData[row] instanceof Course) {
			switch (column) {
			case 0:
				return ((Course) objectsData[row]).getStuNumber();
			case 1:
				return ((Course) objectsData[row]).getName();
			case 2:
				return ((Course) objectsData[row]).getStuGrade();
			case 3:
				return ((Course) objectsData[row]).getScoreAttand();
			case 4:
				return ((Course) objectsData[row]).getScoreMid();
			case 5:
				return ((Course) objectsData[row]).getScoreFinal();
			case 6:
				return ((Course) objectsData[row]).getScoreHomework();
			case 7:
				return ((Course) objectsData[row]).getScoreQuiz();
			case 8:
				return ((Course) objectsData[row]).getScorePPT();
			case 9:
				return ((Course) objectsData[row]).getScoreReport();
			case 10:
				return ((Course) objectsData[row]).getScoreEtc();
			case 11:
				return totals[row];
			case 12:
				return ranks[row];
			case 13:
				return grades[row];
			}
		} else if (objectsData[row] instanceof Attand) {
			if (column < 3) {
				switch (column) {
				case 0:
					return ((Attand) objectsData[row]).getStuNumber();
				case 1:
					return ((Attand) objectsData[row]).getName();
				case 2:
					return ((Attand) objectsData[row]).getStuGrade();
				}
			} else {
				return ((Attand) objectsData[row]).getSerialAttand().charAt(column - 3);
			}
		}
		return null;
	}

}
