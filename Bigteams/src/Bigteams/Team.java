package Bigteams;

import java.util.HashSet;
import java.util.Set;

/**
 * Each instance of this class represents a team
 * in a team membership graph.
 * 
 * @invar | getMembers().stream().allMatch(s -> s != null && s.getTeam() == this)
 */
public class Team {
	
	/**
	 * @invar | members != null
	 * @invar | members.stream().allMatch(m ->
	 *        |     m != null && m.team == this)
	 *        
	 * @representationObject
	 * @peerObjects
	 */
	Set<Student> members = new HashSet<>();
	
	/**
	 * @post | result != null
	 *
	 * @creates | result
	 * @peerObjects
	 */
	public Set<Student> getMembers() { return Set.copyOf(members); }

	/**
	 * @post | getMembers().isEmpty()
	 */
	public Team() {}
}