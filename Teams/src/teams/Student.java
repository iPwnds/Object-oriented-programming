package teams;

import logicalcollections.LogicalSet;

/**
 * @invar | getTeam() == null || getTeam().getStudents().contains(this)
 */
public class Student {
	
	/**
	 * @invar | true  // Phase 1 representation invariant
	 * @invar | team == null || team.students.contains(this) // Phase 2 representation invariant
	 * @peerObject
	 */
	Team team;

	/**
	 * @basic
	 * @peerObject
	 */
	public Team getTeam() { return team; }

	/**
	 * @post | getTeam() == null
	 */
	public Student() {}
	
	/**
	 * @pre | team != null
	 * @pre | getTeam() == null
	 * 
	 * @mutates_properties | getTeam(), team.getStudents()
	 * 
	 * @post | getTeam() == team
	 * @post | team.getStudents().equals(LogicalSet.plus(old(team.getStudents()), this))
	 */
	public void joinTeam(Team team) {
		this.team = team;
		team.students.add(this);
	}
	
	/**
	 * @pre | getTeam() != null
	 * 
	 * @mutates_properties | getTeam(), getTeam().getStudents()
	 * 
	 * @post | getTeam() == null
	 * @post | old(getTeam()).getStudents().equals(LogicalSet.minus(old(getTeam().getStudents()), this))
	 */
	public void leaveTeam() {
		team.students.remove(this);
		team = null;
	}
}