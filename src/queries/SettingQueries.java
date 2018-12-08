package queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Grade;
import classes.Ratio;

public class SettingQueries {
	private Connection connection = null;
	private PreparedStatement selectSetting = null;
	private PreparedStatement updateSetting = null;
	private String colName[] = { "ratioAttand", "ratioMid", "ratioFinal", "ratioHomework", "ratioQuiz", "ratioPPT",
			"ratioReport", "ratioEtc", "ratioAP", "ratioA0", "ratioBP", "ratioB0", "ratioCP", "ratioC0", "ratioD",
			"ratioD", "privacy"};

	public SettingQueries(String DATABASE_URL, String USERNAME, String PASSWORD) {
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			selectSetting = connection.prepareStatement("SELECT * FROM setting WHERE num = 0");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	}
	
	public int getPrivacy() {
		int privacy = 0;
		try {
			ResultSet result = selectSetting.executeQuery();
			result.next();
			privacy = result.getInt("privacy");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			close();
		}
		return privacy;
	}

	public Ratio getRatio() {
		Ratio ratio = null;
		try {

			ResultSet result = selectSetting.executeQuery();
			result.next();

			ratio = new Ratio(result.getInt(2), result.getInt(3), result.getInt(4), result.getInt(5), result.getInt(6),
					result.getInt(7), result.getInt(8), result.getInt(9));
			System.out.println("" + result.getInt(2) + result.getInt(3) + result.getInt(4) + result.getInt(5)
					+ result.getInt(6) + result.getInt(7) + result.getInt(8) + result.getInt(9));
		} catch (SQLException e) {
			e.printStackTrace();
			close();
		}
		return ratio;
	}

	public Grade getGrade() {
		Grade grade = null;
		try {

			ResultSet result = selectSetting.executeQuery();
			result.next();

			grade = new Grade(result.getInt(10), result.getInt(11), result.getInt(12), result.getInt(13),
					result.getInt(14), result.getInt(15), result.getInt(16), result.getInt(17));
			System.out.println("" + result.getInt(10) + result.getInt(11) + result.getInt(12) + result.getInt(13)
					+ result.getInt(14) + result.getInt(15) + result.getInt(16) + result.getInt(17));
		} catch (SQLException e) {
			e.printStackTrace();
			close();
		}
		return grade;
	}

	public int updateSetting(int col, int value) {
		int result = 0;
		try {
			updateSetting = connection.prepareStatement("UPDATE setting SET " + colName[col] + " = ? WHERE num = 0;");
			updateSetting.setInt(1, value);
			result = updateSetting.executeUpdate();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}

	void close() {
		try {
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}
