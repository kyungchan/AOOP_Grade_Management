package classes;

abstract class Student {
	private String name;
	private String stuNumber;
	private int stuGrade;

	abstract int getTotalScore(Ratio ratio);

	public Student(String name, String stuNumber, int stuGrade) {
		setName(name);
		setStuNumber(stuNumber);
		setStuGrade(stuGrade);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStuNumber() {
		return stuNumber;
	}

	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}

	public int getStuGrade() {
		return stuGrade;
	}

	public void setStuGrade(int stuGrade) {
		this.stuGrade = stuGrade;
	}

}
