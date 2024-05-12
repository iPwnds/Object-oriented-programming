package persoon;

import java.util.HashSet;
import java.util.Set;


/**
 * Each instance of this class represents a person in an ... is father of ... graph.
 * 
 * @invar | getFather() == null || getFather().getChildren().contains(this)
 * @invar | getChildren().stream().allMatch(c -> c.getFather() == this)
 */
public class Persoon {
	
	/**
	 * @invar | children != null
	 * @invar | children.stream().allMatch(c -> c != null)
	 * @invar | children.stream().allMatch(c -> c.father == this)
	 * @invar | father == null || father.children.contains(this)
	 * @peerObject
	 */
	private Persoon father;
	/**
	 * @representationObject
	 * @peerObjects
	 */
	private HashSet<Persoon> children;

	/**
	 * @peerObject
	 */
	public Persoon getFather() { return father; }
	
	/**
	 * @post | result != null
	 * @post | result.stream().allMatch(c -> c != null)
	 * @creates | result
	 * @peerObjects
	 */
	public Set<Persoon> getChildren() { return Set.copyOf(children); }
	
	/**
	 * @post | getFather() == null
	 * @post | getChildren().size() == 0
	 */
	public Persoon() {
		children = new HashSet<>();
	}
	
	/**
	 * @pre | getFather() == null
	 * @pre | father != null
	 * @mutates_properties | this.getFather(), father.getChildren()
	 * @post | getFather() == father
	 */
	public void setFather(Persoon father) { 
		this.father = father;
		father.children.add(this);
	}
	
	/**
	 * @pre | getFather() != null
	 * @mutates_properties | getFather(), getFather().getChildren()
	 * @post | getFather() == null
	 */
	public void unregisterFather() {
		father.children.remove(this);
		this.father = null;
	}
	
}