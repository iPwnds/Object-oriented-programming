package ExamsAndRooms;

import java.util.HashSet;
import java.util.Set;


/**
 * @invar | getExams() != null
 * @invar | getExams().stream().allMatch(exam -> exam != null && exam.getRooms().contains(this))
 */
public class Room {

	/**
	 * @invar | exams != null
	 * @invar | exams.stream().allMatch(exam -> exam != null)
	 * @representationObject
	 */
	private Set<Exam> exams = new HashSet<Exam>();
	
	/**
	 * @invar | getExamsInternal().stream().allMatch(exam -> exam.getRoomsInternal().contains(this))
	 * 
	 * @creates | result
	 * @post | result != null
	 * @post | result.stream().allMatch(exam -> exam != null)
	 * 
	 * @peerObjects (package-level)
	 */
	Set<Exam> getExamsInternal() {
		return Set.copyOf(exams);
	}
	
	/**
	 * @creates | result
	 * @peerObjects
	 * @basic
	 */
	public Set<Exam> getExams() {
		return Set.copyOf(exams); 
	}
	
	/**
	 * @mutates | this
	 * @post | getExams().isEmpty()
	 */
	public Room() {}

	/**
	 * @throws IllegalArgumentException | exam == null
	 * @mutates | this
	 */
	void addExam(Exam exam) {
		if (exam == null)
			throw new IllegalArgumentException("exam is null");
		exams.add(exam);
	}

	/**
	 * @pre | exam != null
	 * @mutates | this
	 */
	void removeExam(Exam exam) {
		exams.remove(exam);
	}
	
}