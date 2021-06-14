import java.util.Scanner;

public class Play {
	
	private int result = 0;	//�������� ����.
	private int qTotalOuput; //��� �����
	private QuizDataDAO quizData; //�������� �����ϴ� ArrayList
	public Play() {
		this(10);
	}	
	public Play(int size) {
		quizData = new QuizDataDAO();			
		qTotalOuput = size;
	}	
	

	/**�޴� �����ֱ�*/
	public void PlayQuiz(){
		System.out.println();
		System.out.println("===== Mini Quiz Start====");		
		quizData.loadQuiz();		
		startQuiz();
	}//showMenu()----------
	
	private void startQuiz() {
		System.out.println("[*] Start Quiz");
		Scanner scn = new Scanner(System.in);
		if(qTotalOuput>quizData.size()) qTotalOuput = quizData.size();
		for (int i = 0; i < qTotalOuput; i++) {
			QuestionDTO qDTO = quizData.get(i);
			APIExamTTS mp3File = new APIExamTTS();
			String question = qDTO.getQuestion();
			String answer = qDTO.getAnswer();

			System.out.println((i + 1) + ") " + question);
			mp3File.makeTTS(question, "Quiz" + Integer.toString(i + 1));
			Audio playAudio = new Audio("Quiz" + Integer.toString(i + 1));
			playAudio.play();
			String user_Answer = scn.nextLine();

			if (answer.equals(user_Answer)) {
				playAudio.stop();
				System.out.println("맞췄습니다!");
				new Audio("Correct").play();
				result++;
				try{
					Thread.sleep(1500);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			} else {
				playAudio.stop();
				System.out.println("틀렸습니다!");
				new Audio("Incorrect").play();
				try{
					Thread.sleep(1500);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			System.out.println();
		}//for()------
		System.out.println("Quiz is End");
		quizData.clear(); //������� �ʱ�ȭ
		showResult(); //��� ���
	}//startQuiz()---------
	
    public void showResult(){
       
        System.out.println("===== Mini Quiz Result====");
        System.out.println("문제수 : "+qTotalOuput);
        System.out.println("정답수 : "+result);
        System.out.printf("점  수 : %.1f 점\n", result * (100.0 / qTotalOuput));
        System.out.println("==========================");
    }//showResult()---------
}