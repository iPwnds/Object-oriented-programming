package teams;

import java.util.HashSet;
import java.util.Set;

/**
 * @invar | getStudents() != null
 * @invar | getStudents().stream().allMatch(s -> s != null && s.getTeam() == this)
 */
public class Team {
	
	/**
	 * @invar | students != null // Phase 1 representation invariant
	 * @invar | students.stream().allMatch(s -> s != null && s.team == this) // Phase 2 representation invariant
	 * @representationObject
	 * @peerObjects
	 */
	Set<Student> students = new HashSet<>();
	
	/**
	 * @basic
	 * @creates | result
	 * @peerObjects
	 */
	public Set<Student> getStudents() { return Set.copyOf(students); }

	/**
	 * @post | getStudents().isEmpty()
	 */
	public Team() {}
	
}