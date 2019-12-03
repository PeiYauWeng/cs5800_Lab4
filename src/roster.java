import java.util.ArrayList;

public class roster extends student {
	final private String courseName;
	private int numberOfStudent;
	private ArrayList<student> studentList;
	private student currentStudent;
	private ArrayList<String> guideTable = new ArrayList<String>();
	
	public roster() {
		courseName = null;
		numberOfStudent = 0;
		studentList = new ArrayList<student>();
	}
	
	public roster(String courseName) {
		this.courseName = courseName;
		numberOfStudent = 0;
		studentList = new ArrayList<student>();
	}
	
	public void addStudent(student oneStudent) {
		this.studentList.add(oneStudent);
		this.numberOfStudent++;
		currentStudent = oneStudent;
		guideTable.add(currentStudent.getStudentName());
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public int getNumberOfStudent() {
		return this.numberOfStudent;
	}
	
	public double currentWeightedScore() {
		double WeightedScore = 0;
		WeightedScore = currentStudent.getWeightedScore();
		return WeightedScore;
	}
	
	public double currentWeightedScoreWithDropLowest() {
		double WeightedScoreWithDropLowest = 0;
		WeightedScoreWithDropLowest = currentStudent.getWeightedScoreWithDropLowest();
		return WeightedScoreWithDropLowest;
	}
	
	public double assignWeightedScore(String studentName) {
		int index = guideTable.indexOf(studentName);
		student assignStudent = this.studentList.get(index);
		return assignStudent.getWeightedScore();
	}
	
	public double assignWeightedScoreWithDropLowest(String studentName) {
		int index = guideTable.indexOf(studentName);
		student assignStudent = this.studentList.get(index);
		return assignStudent.getWeightedScoreWithDropLowest();
	}
	
	public void addAssignedStudentAssignmentScore(String studentName, double score) {
		int index = guideTable.indexOf(studentName);
		student assignStudent = this.studentList.get(index);
		assignStudent.addAssignmentScore(score);
	}
	
	public void addAssignedStudentExamScore(String studentName, double score) {
		int index = guideTable.indexOf(studentName);
		student assignStudent = this.studentList.get(index);
		assignStudent.addExamScore(score);
	}
	
	public void printOutAllStudentName() {
		System.out.println(guideTable);
	}
}
