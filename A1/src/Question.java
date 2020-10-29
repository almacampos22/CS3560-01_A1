/**
 * 
 * @author Alma
 * CS 3560-01
 * Assignment 1
 * 
 */

public abstract class Question 
{
   private String questionAsked;
   private String[] answerChoices;
   
   public Question()
   {
	   
   }
   
   public Question(String que)
   {
	   questionAsked = que;
   }
   
   public void setQuestionAsked(String que)
   {
	   questionAsked = que;
   }
	
   public void setAnswerChoices(String[] options)
	{
		answerChoices = options;
	}
	
	
   public String getQuestionAsked()
   {
	   return questionAsked;
   }
   
   public int getNumberOfAnswerChoices()
	{
		return answerChoices.length;
	}
   
   //get a specific answer from answerChoices
   public String getAnswerChoiceAt(int i)
   {
	   return answerChoices[i];
   }
   
   abstract String getCorrectAnswer();
   abstract int getNumberOfCorrectAnswers();
   
}
