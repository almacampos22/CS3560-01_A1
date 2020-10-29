/**
 * 
 * @author Alma
 * CS 3560-01
 * Assignment 1
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VotingService 
{
	private ArrayList<Question> quiz = new ArrayList<>();
	private ArrayList<Student> participants = new ArrayList<>();
	private HashMap<Integer, String> submittedAnswers = new HashMap<>();
	private String representationOfCorrectAnswer;
	
	
	public VotingService()
	{
		quiz = new ArrayList<>();
		participants = new ArrayList<>();
	}

	//add student to list of participants
	public void addParticipant(Student s)
	{
		participants.add(s);
	}
	
	//get size of participants list
	public int getNumberOfParticipants()
	{
		return participants.size();
	}
	
	//get a Student from index i in the participants list
	public Student getParticipantAt(int i)
	{
		return participants.get(i);
	}
	
	//add a question to the quiz
	public void addQuestion(Question q)
	{
		quiz.add(q);
	}
	
	//return number of questions in quiz
	public int getNumberOfQuestions()
	{
		return quiz.size();
	}
	
	//get a Question from index i in the quiz 
	public Question getQuestionAt(int i)
	{
		return quiz.get(i);
	}
	
	//format question to be asked
	public String askQuestion(int i)
	{
		//checking if there is a question at index i of the question bank
		if(i < quiz.size())
		{
			Question q = quiz.get(i);
			String questionDisplayed = q.getQuestionAsked();
			char c = 'A';
		     for(int j = 0; j < q.getNumberOfAnswerChoices(); j++)
		     {
		    	 questionDisplayed = questionDisplayed + "\n" + c + ": " + q.getAnswerChoiceAt(j);
		    	 c++;
		     }
		     questionDisplayed = questionDisplayed + "\n";
		     return questionDisplayed;
		}
		return "Error loading the question..";
	}
	
	//find students location in particpants list based on id
	public int findStudentIndex(int id)
	{
		for(int i = 0; i < participants.size(); i++)
		{
			if (id == participants.get(i).getStudentId())
				return i;
		}
		return -1;
	}
	
	public void submitAnswer(int id, String answer)
	{
		int i = findStudentIndex(id);
		if (i >= 0) 
		{
		    participants.get(i).submitAnswer(answer);
		    //check if student already submitted an answer
		    if(submittedAnswers.containsKey(id))
		    {
		    	//replace student's old answer with answer most recently submitted
		    	submittedAnswers.replace(id, participants.get(i).getAnswerSubmitted());
		    	System.out.println(participants.get(i).getStudentId() + " resubmitted an answer");
		    }
		    else
		    {
		    	submittedAnswers.put(id, participants.get(i).getAnswerSubmitted());
		    	System.out.println(participants.get(i).getStudentId() + " submitted an answer");
		    }
		}
		else
		{
			System.out.println("Not a valid participant");
		}
	}
	
	public String getLetterOfCorrectAnswer(Question q)
	{
		representationOfCorrectAnswer = "";
		char c = 'A';
		for (int i = 0; i < q.getNumberOfAnswerChoices(); i++)
		{
			//if (q.getAnswerChoiceAt(i).contains(q.getCorrectAnswer()))
			if(q.getCorrectAnswer().contains(q.getAnswerChoiceAt(i)))
			{
				representationOfCorrectAnswer = representationOfCorrectAnswer + " " + String.valueOf(c);
				
			}
			c++;
		}
		return representationOfCorrectAnswer;
	}
	
	public void displayQuestionResults(String correctAnswer)
	{
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		
		for (Map.Entry<Integer, String> i : submittedAnswers.entrySet())
		{
			if (i.getValue().contains("A"))
				a++;
			if (i.getValue().contains("B"))
				b++;
			if (i.getValue().contains("C"))
				c++;
			if (i.getValue().contains("D"))
				d++;
		}
		
		System.out.print("\nResults\n-------\nA: " + a + "\nB: " 
		+ b + "\nC: " + c + "\nD: " + d + "\nCorrect Answer: " + correctAnswer + "\n\n");
		
		//clear the submittedAnswers map of values from the current question.
		submittedAnswers.clear();
	}
	
}
