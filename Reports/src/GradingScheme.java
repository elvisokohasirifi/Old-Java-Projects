
public class GradingScheme {

	public static String ifGrade(int score){
		String grade;
		if (score == 10 || score == 9) grade = "Excellent";
		else if (score == 8) grade = "Very Good";
		else if (score == 7 || score == 6) grade = "Good";
		else if (score == 5) grade = "Satisfactory";
		else if(score >= 0 && score <= 4) grade = "Failed";
		else grade = null;
		return grade;
	}
	
	public static String caseGrade(int score){
		String grade;
		switch (score){
		case 10:
		case 9: grade = "Excellent"; break;
		case 8: grade = "Very Good"; break;
		case 7:
		case 6: grade = "Good"; break;
		case 5: grade = "Satisfactory"; break;
		case 4:
		case 3:
		case 2:
		case 1:
		case 0: grade = "Failed"; break;
		default: grade = null;
		}
		return grade;
	}
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 12; i ++){
			System.out.println("\nGrade for " + i + " using if...else block is " + ifGrade(i));
			System.out.println("Grade for " + i + " using switch case block is " + caseGrade(i));
			Thread.sleep(1000);
		}

	}

}
