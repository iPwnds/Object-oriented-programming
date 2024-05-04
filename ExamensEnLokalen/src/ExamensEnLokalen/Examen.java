package ExamensEnLokalen;

import java.util.HashSet;
import java.util.Set;

/**
 * Each instance of this class represents a exam
 * in an exams-and-rooms graph.
 * 
 * @invar | getRooms().stream().allMatch(r -> r.getExams().contains(this))
 */
public class Examen {
	
	/**
	 * @invar | rooms != null
	 * @invar | rooms.stream().allMatch(r -> r != null)
	 * @invar | rooms.stream().allMatch(r -> r.exams.contains(this))
	 * @representationObject
	 * @peerObjects
	 */
	HashSet<Lokaal> rooms = new HashSet<>();
	
	/**
	 * @post | result != null
	 * @creates | result
	 * @post | result.stream().allMatch(r -> r != null)
	 * @peerObjects
	 */
	public Set<Lokaal> getRooms() { return Set.copyOf(rooms); }
	
	/**
	 * @post | getRooms().isEmpty()
	 */
	public Examen() {}
	
	/**
	 * @pre | room != null
	 * @mutates_properties | getRooms(), room.getExams()
	 */
	public void addRoom(Lokaal room) {
		rooms.add(room);
		room.exams.add(this);
	}
	
	/**
	 * @pre | room != null
	 * @mutates_properties | getRooms(), room.getExams()
	 */
	public void removeRoom(Lokaal room) {
		rooms.remove(room);
		room.exams.remove(this);
	}

}