/**
 * 
 * @author Alma
 * CS 3560-01
 * Assignment 1
 * 
 */
public class MultipleAnswerQuestion extends Question
{

	private String[] correctAnswers;
	
	public MultipleAnswerQuestion(String que)
	{
		setQuestionAsked(que);
	}
	
	public MultipleAnswerQuestion(String que, String[] options, String[] solution)
	{
		setQuestionAsked(que);
		setAnswerChoices(options);
		correctAnswers = solution;
	}
	
	
	public void setCorrectAnswer(String[] answer)
	{
		correctAnswers = answer;
	}
	
	public String getCorrectAnswer()
	{
		String answer = "";
		for(int i = 0; i < correctAnswers.length; i++)
		{
			answer = answer + correctAnswers[i] + " ";
		}
		return answer;
	}
	
	public int getNumberOfCorrectAnswers()
	{
		return correctAnswers.length;
	}
}
