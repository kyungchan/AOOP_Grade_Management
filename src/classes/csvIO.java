package classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class csvIO {
	private List<Attand> attands;
	private List<Course> courses;

	public csvIO(List<Course> courses, List<Attand> attands) {
		this.attands = attands;
		this.courses = courses;
	}

	public void out() {
		BufferedWriter bw = null;
		try {
			JFileChooser jfc = new JFileChooser();
			jfc.setDialogTitle("파일 내보내기");
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV 파일", "csv");

			jfc.setFileFilter(filter);
			if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				File f = jfc.getSelectedFile();

				bw = Files.newBufferedWriter(Paths.get(f.getAbsolutePath() + ".csv"), Charset.forName(("UTF-8")));
				List<List<String>> data;
				String temp;
				for (int i = 0; i < courses.size(); i++) {
					bw.write(courses.get(i).getStuNumber());
					bw.write(',');
					bw.write(courses.get(i).getName());
					bw.write(',');
					bw.write(Integer.toString(courses.get(i).getStuGrade()));
					bw.write(',');
					bw.write(Integer.toString(courses.get(i).getScoreAttand()));
					bw.write(',');
					bw.write(Integer.toString(courses.get(i).getScoreMid()));
					bw.write(',');
					bw.write(Integer.toString(courses.get(i).getScoreFinal()));
					bw.write(',');
					bw.write(Integer.toString(courses.get(i).getScoreHomework()));
					bw.write(',');
					bw.write(Integer.toString(courses.get(i).getScoreQuiz()));
					bw.write(',');
					bw.write(Integer.toString(courses.get(i).getScorePPT()));
					bw.write(',');
					bw.write(Integer.toString(courses.get(i).getScoreReport()));
					bw.write(',');
					bw.write(Integer.toString(courses.get(i).getScoreEtc()));
					temp = attands.get(i).getSerialAttand();
					for (int j = 0; j < 32; j++) {
						bw.write(',');
						bw.write(temp.charAt(j));
					}
					bw.newLine();
				}

				JOptionPane.showMessageDialog(null, "CSV파일 저장 완료", "성적관리", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
