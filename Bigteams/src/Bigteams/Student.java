package Bigteams;


/**
 * Each instance of this class represents a
 * student in a team membership graph.
 * 
 * @invar | getTeam() == null || getTeam().getMembers().contains(this)
 */
public class Student {
	
	/**
	 * @invar | team == null || team.members.contains(this)
	 * 
	 * @peerObject
	 */
	Team team;
	
	/**
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
	 * @mutates_properties | this.getTeam(), team.getMembers()
	 * @post | getTeam() == team
	 */
	public void joinTeam(Team team) {
		this.team = team;
		team.members.add(this);
	}
	
	/**
	 * @pre | getTeam() != null
	 * @mutates_properties | getTeam(), getTeam().getMembers()
	 * @post | getTeam() == null
	 */
	public void leaveTeam() {
		team.members.remove(this);
		team = null;
	}
	
}