import java.util.ArrayList;

public class student {
	final private String name;
	private ArrayList<Double> AssignmentScore;
	private ArrayList<Double> ExamScore;
	private double weightedScore;
	private double weightedScoreWithDropLowest;
	
	public student() {
		name = null;
		AssignmentScore = new ArrayList<Double>();
		ExamScore = new ArrayList<Double>();
		weightedScore = 0.0;
		weightedScoreWithDropLowest = 0.0;
	}
	
	public student(String name) {
		this.name = name;
		AssignmentScore = new ArrayList<Double>();
		ExamScore = new ArrayList<Double>();
		weightedScore = 0.0;
		weightedScoreWithDropLowest = 0.0;
	}
	
	public void addAssignmentScore (double as) {
		this.AssignmentScore.add(as);
		this.weightedScore = calculateScore(false);
		this.weightedScoreWithDropLowest = calculateScore(true);
	}
	
	public void addExamScore (double es) {
		this.ExamScore.add(es);
		this.weightedScore = calculateScore(false);
		this.weightedScoreWithDropLowest = calculateScore(true);
	}
	
	public String getStudentName() {
		return this.name;
	}
	
	public double getAssignmentScore(int index) {
		return this.AssignmentScore.get(index-1);
	}
	
	public ArrayList<Double> getAssignmentScore() {
		return this.AssignmentScore;
	}
	
	public double getExamScore(int index) {
		return this.ExamScore.get(index-1);
	}
	
	public ArrayList<Double> getExamScore(){
		return this.ExamScore;
	}
	
	public double getWeightedScore() {
		return this.weightedScore;
	}
	
	public double getWeightedScoreWithDropLowest() {
		return this.weightedScoreWithDropLowest;
	}
	
	public int getNumberOfAssignmentScore() {
		return this.AssignmentScore.size();
	}
	
	public int getNumberOfExamScore() {
		return this.ExamScore.size();
	}
	
	private double getLowestAssignmentScroe () {
		double lowest_score= Integer.MAX_VALUE;
		if (this.AssignmentScore.isEmpty())
			return 0;
		for (int i=0; i<this.AssignmentScore.size(); i++) {
			if(this.AssignmentScore.get(i)<lowest_score)
				lowest_score = this.AssignmentScore.get(i);
		}
		return lowest_score;
	}
	
	private double getAverageAssignmentScore(boolean isDropedLowest) {
		double average=0;
		double sum=0;
		if (this.AssignmentScore.isEmpty())
			return 0;
		for (int i=0; i<this.AssignmentScore.size(); i++) {
			sum += this.AssignmentScore.get(i);
		}
		if(isDropedLowest) {
			sum -= getLowestAssignmentScroe();
			average = sum/(this.AssignmentScore.size()-1);
		}
		else {
			average = sum/this.AssignmentScore.size();
		}
		
		return average;
	}
	
	private double getAverageExamScore() {
		double average=0;
		double sum=0;
		if (this.ExamScore.isEmpty())
			return 0;
		for (int i=0; i<this.ExamScore.size(); i++) {
			sum += this.ExamScore.get(i);
		}
		average = sum/this.ExamScore.size();
		return average;
	}
	
	private double calculateScore(boolean isDropedLowest) {
		double averageAssignmentScore = getAverageAssignmentScore(isDropedLowest);
		double averageExamScore = getAverageExamScore();
		double weightScore;
		
		weightScore = averageAssignmentScore*0.4 + averageExamScore*0.6;
		return weightScore;
	}
}
