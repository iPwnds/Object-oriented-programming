package Multi__class_entity__relationship_abstractions;

//public class ProjectCourseStudent {
//    
//    private Team team;
//    
//    public Team getTeam() { return team; }
//    
//    public ProjectCourseStudent() {}
//
//    public void join(Team team) {
//        if (this.team != null)
//            throw new IllegalStateException("this student is already in a team");
//        
//        this.team = team;
//        team.members.add(this);
//    }
//
//    public void leaveTeam() {
//        if (this.team == null)
//            throw new IllegalStateException("this student is not in a team");
//        
//        team.members.remove(this);
//        team = null;
//    }
//}


/**
 * Each instance of this class represents a student in a project course,
 * as part of a student-team graph.
 * 
 * @invar If a student is in a team, it is among its members.
 *    | getTeam() == null || getTeam().getMembers().contains(this)
 */
public class ProjectCourseStudent {
    
    /**
     * @invar | true  // Phase 1 representation invariant
     * @invar | team == null || team.members.contains(this)  // Phase 2 rep. inv.
     * 
     * @peerObject
     */
    Team team;
    
    /**
     * Returns this student's team, or {@code null} if they are not in a team.
     * 
     * @peerObject
     */
    public Team getTeam() { return team; }
    
    /**
     * Initializes this object as representing a student who is not in a team.
     */
    public ProjectCourseStudent() {}

    /**
     * Make this student a member of the given team.
     *
     * @throws IllegalArgumentException if {@code team} is null.
     *    | team == null
     * @throws IllegalStateException if this student is already in a team.
     *    | getTeam() != null
     * 
     * @mutates_properties | this.getTeam(), team.getMembers()
     * 
     * @post The given team's members equal its old members plus this student.
     */
    public void join(Team team) {
        if (team == null)
            throw new IllegalArgumentException("team is null");
        if (this.team != null)
            throw new IllegalStateException("this student is already in a team");
        
        this.team = team;
        team.members.add(this);
    }

    /**
     * Make this student no longer be a member of their team.
     * 
     * @throws IllegalStateException if this student is not in a team.
     *    | getTeam() == null
     * 
     * @mutates_properties | this.getTeam(), this.getTeam().getMembers()
     * 
     * @post This student is not in a team.
     *    | getTeam() == null
     * @post This student's old team's members are its old members minus this
     *       student.
     */
    public void leaveTeam() {
        if (this.team == null)
            throw new IllegalStateException("this student is not in a team");
        
        team.members.remove(this);
        team = null;
    }
}