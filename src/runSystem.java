import java.util.Scanner;

public class runSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input the course name:");
		String courseName = scanner.nextLine();
		roster roster = new roster(courseName);
		while(true) {
			System.out.println("Input the student name:");
			String studentName = scanner.nextLine();
			student student = new student(studentName);
			System.out.println("want to input assignment score(Y/N)");
			String isInput = scanner.nextLine();
			if (isInput.equals("Y")) {
				System.out.println("Input assignment scores");
				String InputAssignment = scanner.nextLine();
				double[] assignmentList = splitInput(InputAssignment);
				for(int i=0; i<assignmentList.length; i++) {
					student.addAssignmentScore(assignmentList[i]);
				}
				System.out.println("Input exam scores");
				String InputExam = scanner.nextLine();
				double[] examList = splitInput(InputExam);
				for(int i=0; i<examList.length; i++) {
					student.addExamScore(examList[i]);
				}
				roster.addStudent(student);
				System.out.println("current score: "+roster.currentWeightedScore()+" Grade: "+gradeScore(roster.currentWeightedScore()));
				System.out.println("current score: "+roster.currentWeightedScoreWithDropLowest()+" Grade: "+gradeScore(roster.currentWeightedScoreWithDropLowest()));
			}
			System.out.println("want to assign specific score(Y/N)");
			isInput = scanner.nextLine();
			if (isInput.equals("Y")) {
				roster.printOutAllStudentName();
				System.out.println("Input student name");
				String assignStudentName = scanner.nextLine();
				System.out.println("Score only using method A: "+roster.assignWeightedScore(assignStudentName)+" Grade: "+gradeScore(roster.assignWeightedScore(assignStudentName)));
				System.out.println("Score using method B: "+roster.assignWeightedScoreWithDropLowest(assignStudentName)+" Grade: "+gradeScore(roster.assignWeightedScoreWithDropLowest(assignStudentName)));
			}
			System.out.println("want to add a new score in existed student(Y/N)");
			isInput = scanner.nextLine();
			if (isInput.equals("Y")) {
				roster.printOutAllStudentName();
				System.out.println("Input student name");
				String assignStudentName = scanner.nextLine();
				System.out.println("Input assignment scores");
				String newAssignmentScore = scanner.nextLine();
				if(!newAssignmentScore.equals("none")) {
					roster.addAssignedStudentAssignmentScore(assignStudentName, new Double(newAssignmentScore));
				}
				System.out.println("Input exam scores");
				String newExamScore = scanner.nextLine();
				if(!newExamScore.equals("none")) {
					roster.addAssignedStudentExamScore(assignStudentName, new Double(newExamScore));
				}
				System.out.println("Score only using method A: "+roster.assignWeightedScore(assignStudentName)+" Grade: "+gradeScore(roster.assignWeightedScore(assignStudentName)));
				System.out.println("Score using method B: "+roster.assignWeightedScoreWithDropLowest(assignStudentName)+" Grade: "+gradeScore(roster.assignWeightedScoreWithDropLowest(assignStudentName)));
			}
		}
		//scanner.close();
	}
	
	private static double[] splitInput(String Input) {
		String[] tempArray = Input.split(" ");
		double[] scoreList = new double[tempArray.length];
		for (int i=0; i<tempArray.length; i++) {
			scoreList[i] = Double.valueOf(tempArray[i]);
		}
		return scoreList;
	}
	
	private static String gradeScore(double score) {
		if (score >= 90)
			return "A";
		else if (score >= 80)
			return "B";
		else if (score >= 70)
			return "C";
		else if (score >= 60)
			return "D";
		else
			return "F";
	}
}
