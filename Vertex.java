/*

 */
package faketaxi;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author carloschavez
 */
public class Vertex implements Comparable<Vertex>{
  private String placeName;
  private List<Edge> adjacenciesList;
  private boolean visited;
  private Vertex predecessor;
  private double distance = Double.MAX_VALUE;
  
  public Vertex(String placeName){
    this.placeName = placeName;
    this.adjacenciesList = new ArrayList<>();
  }
  
  public void setName(String placeName){
    this.placeName = placeName;
  }
  
 public void setAdjacenciesList(List<Edge> adjacenciesList) {
    this.adjacenciesList = adjacenciesList;
 }
  
  public void addNeighbor(Edge edge){
    this.adjacenciesList.add(edge);
  }
  
  public void setPredecessor(Vertex predecessor){
    this.predecessor = predecessor;
  }
  
  public void setVisited(boolean visited){
    this.visited = visited;
  }
  
  public void setDistance(double distance){
    this.distance = distance;
  }
  public String getName(){
    return placeName;
  }
  
  public List<Edge> getAdjacenciesList(){
    return adjacenciesList;
  }
  
  public double getDistance(){
    return distance;
  }
  @Override
  public String toString(){
    return this.placeName;
  }
  @Override
  public int compareTo(Vertex otherVertex){
    return Double.compare(this.distance, otherVertex.getDistance());
  }
  
  public boolean isVisited(){
   return visited;
  }
  
  public Vertex getPredecessor(){
    return predecessor;
  }
    
}
