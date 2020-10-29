/**
 * 
 * @author Alma
 * CS 3560-01
 * Assignment 1
 * 
 */

public class SingleAnswerQuestion extends Question
{
	private String correctAnswer;
	
	public SingleAnswerQuestion(String que)
	{
		setQuestionAsked(que);
	}
	
	public SingleAnswerQuestion(String que, String[] options, String solution)
	{
		setQuestionAsked(que);
		setAnswerChoices(options);
		solution = correctAnswer;
	}
	
	public void setCorrectAnswer(String answer)
	{
		correctAnswer = answer;
	}
	
	public String getCorrectAnswer()
	{
		return correctAnswer;
	}
	
	public int getNumberOfCorrectAnswers()
	{
		return 1;
	}
}
