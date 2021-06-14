import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuizDataDAO extends ArrayList<QuestionDTO> {
		
	public boolean loadQuiz() {

		String quizDataPath = "Quiz.dat";
	
		try {
			Scanner scn = new Scanner(new FileInputStream(quizDataPath));

			while (scn.hasNext()) {
				QuestionDTO qDTO = new QuestionDTO(scn.nextLine(), scn.nextLine());
				this.add(qDTO);
			}
			
			System.out.println();
			Collections.shuffle(this);

		} catch (FileNotFoundException e) {
			System.out.println("���� : " + e);
			return true;
		}
		
		return false;
	}// loadQuiz()
}
