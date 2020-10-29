/**
 * 
 * @author Alma
 * CS 3560-01
 * Assignment 1
 * 
 */
import java.util.*;

public class SimulationDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VotingService v = new VotingService();
		Random rand = new Random();
		
		//Create 10 students with unique ids and add to participants list
		for(int j = 0; j < 10; j++)
		{
			Student s = new Student(rand.nextInt(999999999));
			for(int i = 0; i < v.getNumberOfParticipants(); i++)
			{
				if(s.getStudentId() == v.getParticipantAt(i).getStudentId())
				{
					s.setStudentId(rand.nextInt());
				}
				
			}
			v.addParticipant(s);
		}
		
		createQuiz(v);
		
		for(int k = 0; k < v.getNumberOfQuestions(); k++)
		{
			System.out.println(v.askQuestion(k));
			participantsAnswer(v,k);
			v.displayQuestionResults(v.getLetterOfCorrectAnswer(v.getQuestionAt(k)));
		}
		
	}
	
	//add questions to the quiz list in voting service
	public static void createQuiz(VotingService v)
	{
		SingleAnswerQuestion q1 = new SingleAnswerQuestion("What year is it?");
		String[] q1Choices = {"1920","2019","2020","2010"};
		q1.setAnswerChoices(q1Choices);
		q1.setCorrectAnswer("2020");
		v.addQuestion(q1);
		
		SingleAnswerQuestion q2 = new SingleAnswerQuestion("Billy the Bronco is our school mascot.");
		String[] q2Choices = {"True","False"};
		q2.setAnswerChoices(q2Choices);
		q2.setCorrectAnswer("True");
		v.addQuestion(q2);
		
		MultipleAnswerQuestion q3 = new MultipleAnswerQuestion("Which of the following are 2020 Presidential Candidates?");
		String[] q3Choices = {"Barack Obama","Donald Trump","George w. Bush","Joe Biden"};
		String[] q3Answers = {"Donald Trump", "Joe Biden"};
		q3.setAnswerChoices(q3Choices);
		q3.setCorrectAnswer(q3Answers);
		v.addQuestion(q3);
		
	}
	
	public static void participantsAnswer(VotingService v, int questionIndex)
	{
		Random rand = new Random();
		char answer;
		
		for(int i = 0; i < v.getNumberOfParticipants(); i++)
		{
			if(v.getQuestionAt(questionIndex).getNumberOfCorrectAnswers() > 1)
			{
				String s;
				answer = (char)(65 + rand.nextInt(v.getQuestionAt(questionIndex).getNumberOfAnswerChoices()));
				s = String.valueOf(answer) + " ";
				answer = (char)(65 + rand.nextInt(v.getQuestionAt(questionIndex).getNumberOfAnswerChoices()));
				s = s + String.valueOf(answer);
				v.submitAnswer(v.getParticipantAt(i).getStudentId(), s);
			}
			else
			{
			    answer = (char)(65 + rand.nextInt(v.getQuestionAt(questionIndex).getNumberOfAnswerChoices()));
			    v.submitAnswer(v.getParticipantAt(i).getStudentId(), String.valueOf(answer));
			}
		}
		//participant at index 0 resubmits "A" as an answer
	v.submitAnswer(v.getParticipantAt(0).getStudentId(),"A");
	}

}
