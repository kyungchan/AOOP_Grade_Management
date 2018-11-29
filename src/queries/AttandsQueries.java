package queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Attand;
import classes.Course;

public class AttandsQueries {
	private Connection connection = null;
	private PreparedStatement selectAllAttands = null;
	private PreparedStatement selectStudentByStuNumber = null;
	private PreparedStatement updateScoreByStuNumber = null;

	public AttandsQueries(String DATABASE_URL, String USERNAME, String PASSWORD) {
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			selectAllAttands = connection.prepareStatement("SELECT * FROM students NATURAL JOIN attands;");
			selectStudentByStuNumber = connection
					.prepareStatement("SELECT * FROM students NATURAL JOIN attands WHERER studentNum = ?;");
			updateScoreByStuNumber = connection.prepareStatement("UPDATE courses SET ? = ? WHERE studentNum = ?;");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	}

	public int updateScore(int studentNumber, String colName, int value) {
		int result = 0;
		try {
			updateScoreByStuNumber.setInt(1, studentNumber);
			updateScoreByStuNumber.setString(2, colName);
			updateScoreByStuNumber.setInt(3, value);
			result = updateScoreByStuNumber.executeUpdate();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}

	public String serializeAttand() {
		return null;

	}

	public List<Attand> getAllAttands() {
		List<Attand> results = null;
		ResultSet resultSet = null;
		String serialize;
		try {
			resultSet = selectAllAttands.executeQuery();
			results = new ArrayList<Attand>();

			while (resultSet.next()) {
				serialize = "";
				for (int i = 1; i <= 16; i++) {
					for (int j = 1; j <= 2; j++) {
						serialize += (Integer.toString(resultSet.getInt("Week" + i + "_" + j)));
					}
				}
				results.add(new Attand(resultSet.getString("StudentName"), resultSet.getString("StudentNum"),
						resultSet.getInt("StudentGrade"), serialize));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			}
		}

		return results;
	}

	void close() {
		try {
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}
