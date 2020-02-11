public class Vertex {
	String label;
	boolean isVisited = false;
	Vertex(String label){
		this.label = label;
	}
	
	public boolean equals(Object o) {
		return this.label.equals(((Vertex)o).label);
	}
	
	public int hashCode() {
		return this.label.hashCode();
	}
}
