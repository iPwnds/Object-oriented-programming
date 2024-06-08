package Multi__class_entity__relationship_abstractions.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import org.junit.jupiter.api.Test;

import Multi__class_entity__relationship_abstractions.ProjectCourseStudent;
import Multi__class_entity__relationship_abstractions.Team;

//class BigTeamsTest {
//
//    @Test
//    void test() {
//        ProjectCourseStudent student1 = new ProjectCourseStudent();
//        ProjectCourseStudent student2 = new ProjectCourseStudent();
//        Team team = new Team();
//        
//        student1.join(team);
//        assertEquals(team, student1.getTeam());
//        assertEquals(Set.of(student1), team.getMembers());
//        
//        student2.join(team);
//        assertEquals(team, student2.getTeam());
//        assertEquals(Set.of(student1, student2), team.getMembers());
//        
//        student1.leaveTeam();
//        assertEquals(Set.of(student2), team.getMembers());
//        
//        student2.leaveTeam();
//        assertEquals(Set.of(), team.getMembers());
//    }
//
//}


class BigTeamsTest {

    @Test
    void test() {
        ProjectCourseStudent student1 = new ProjectCourseStudent();
        ProjectCourseStudent student2 = new ProjectCourseStudent();
        Team team = new Team();
        
        student1.join(team);
        assertEquals(team, student1.getTeam());
        assertEquals(Set.of(student1), team.getMembers());
        
        student2.join(team);
        assertEquals(team, student2.getTeam());
        assertEquals(Set.of(student1, student2), team.getMembers());
        
        student1.leaveTeam();
        assertEquals(Set.of(student2), team.getMembers());
        
        student2.leaveTeam();
        assertEquals(Set.of(), team.getMembers());
    }

}