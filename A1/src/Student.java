/**
 * 
 * @author Alma
 * CS 3560-01
 * Assignment 1
 *
 */
public class Student {
	private int studentId;
	private String answerSubmitted;

	/**
	 * Constructor
	 * 
	 * @param studentId The id of the student
	 */
	public Student(int id) {
		setStudentId(id);
	}

	/**
	 * The setStudentId method stores a String in the studentId field
	 * 
	 * @param id The value to store in studentId
	 */
	public void setStudentId(int id) {
		studentId = id;
	}

	/**
	 * The getStudentId method returns a Student object's studentId.
	 * 
	 * @return The value in the studentId field.
	 */
	public int getStudentId() {
		return studentId;
	}


	public void submitAnswer(String a) {
		answerSubmitted = a;
	}

	public String getAnswerSubmitted() {
		return answerSubmitted;
	}
}
