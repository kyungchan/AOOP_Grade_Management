package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

	public void importCSV() {
		List<Attand> attands = new ArrayList<>();
		List<Course> courses = new ArrayList<>();
		
		BufferedReader br;
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("파일 불러오기");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV 파일", "csv");

		jfc.setFileFilter(filter);
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				File f = jfc.getSelectedFile();
				br = Files.newBufferedReader(Paths.get(f.getAbsolutePath()), Charset.forName("UTF-8"));
				String line;
				String parts[];
				while((line = br.readLine()) != null) {
					System.out.println(line);
					parts = line.split(",");
					courses.add(new Course(parts[1], parts[0], Integer.parseInt(parts[2]),
							Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]),
							Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), 
							Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), Integer.parseInt(parts[10])));
					StringBuilder sb = new StringBuilder();
					for(int i = 11; i <43; i++) 
						sb.append(parts[i]);
					attands.add(new Attand(parts[1], parts[0], Integer.parseInt(parts[2]), sb.toString()));
				}
				this.attands = attands;
				this.courses = courses;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Attand> getAttands() {
		return attands;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void exportCSV() {
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
