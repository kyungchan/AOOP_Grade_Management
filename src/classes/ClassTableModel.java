package classes;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ClassTableModel extends AbstractTableModel {

	private String[] courseColumnNames = { "학번", "학생이름", "학년", "출결(10%)", "중간(15%)", "기말(15%)", "과제(20%)", "퀴즈(10%)",
			"발표(10%)", "보고서(10%)", "기타(10%)" };

	private Student[] objectsData;
	private int ranks[];
	private int totals[];
	public ClassTableModel(Object[] students) {
		
		objectsData = (Student[]) students;
		ranks = new int[objectsData.length];
		totals = new int[objectsData.length];
	}

	@Override
	public Class getColumnClass(int column) throws IllegalStateException {
		if (column < 2) {
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
				totals[row] = (Integer)value;
			}
		} else if (objectsData[row] instanceof Attand)

		{
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
		if (objectsData[0] instanceof Course) {
			return courseColumnNames.length;
		} else if (objectsData[0] instanceof Attand) {
			return 5;
		}
		return 0;
	}

	@Override
	public String getColumnName(int column) throws IllegalStateException {
		if (objectsData[0] instanceof Course) {
			return courseColumnNames[column];
		} else if (objectsData[0] instanceof Attand) {
			return courseColumnNames[column];
		}
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
				return ((Attand) objectsData[row]).getSerialAttand().charAt(column);
			}
		}
		return null;
	}

}
