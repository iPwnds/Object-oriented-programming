package Single__class_entity__relationship_abstractions;

public class ElementNode extends Node {
	
	/** @invar | tag != null */
	private String tag;
	
	public String getTag() {
		return tag;
	}
	
	/** @pre | tag != null */
	public ElementNode(String tag) {
		this.tag = tag;
	}

}