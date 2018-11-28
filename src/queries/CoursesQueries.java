package queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Course;

public class CoursesQueries {
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/grademanager?characterEncoding=UTF-8&serverTimezone=UTC";
	static final String USERNAME = "root";
	static final String PASSWORD = "pass";

	static final String COURSES_QUERY = "SELECT * FROM students NATURAL JOIN courses;";

	private Connection connection = null;
	private PreparedStatement selectAllCourse = null;
	private PreparedStatement selectPeopleByLastName = null;
	private PreparedStatement insertNewPerson = null;

	public CoursesQueries() {
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			selectAllCourse = connection.prepareStatement("SELECT * FROM students NATURAL JOIN courses;");
			selectPeopleByLastName = connection
					.prepareStatement("SELECT * FROM students NATURAL JOIN courses WHERER studentNum = ?;");

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	}

	public List<Course> getAllCourses() {
		List<Course> results = null;
		ResultSet resultSet = null;

		try {
			resultSet = selectAllCourse.executeQuery();
			results = new ArrayList<Course>();
			
			while(resultSet.next()) {
				results.add(new Course(resultSet.getString("StudentName"), resultSet.getString("StudentNum"), resultSet.getInt("StudentGrade"),
						resultSet.getInt("ScoreAttand"), resultSet.getInt("ScoreMid"), resultSet.getInt("ScoreFinal"), resultSet.getInt("ScoreHomework"),
						resultSet.getInt("ScoreQuiz"), resultSet.getInt("ScorePPT"), resultSet.getInt("ScoreReport"), resultSet.getInt("ScoreEtc")));
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