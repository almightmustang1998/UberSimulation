/*

 */
package faketaxi;

/**
 *
 * @author carloschavez
 */
public class Edge {
 
	private double weight;
	private Vertex startVertex;
	private Vertex markVertex;
	
	public Edge(double weight, Vertex startVertex, Vertex markVertex) {
		this.weight = weight;
		this.startVertex = startVertex;
		this.markVertex = markVertex;
	}
        
        public Vertex getMarkVertex() {
		return markVertex;
	}
	public double getWeight() {
		return weight;
	}
        
        public Vertex getStartVertex() {
		return startVertex;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
        
        public void setStartVertex(Vertex startVertex) {
		this.startVertex = startVertex;
	}
        public void setMarkVertex(Vertex markVertex) {
		this.markVertex = markVertex;
	}
 
    }