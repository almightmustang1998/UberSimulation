/*
 * class used to call its shortest path method
 */
package faketaxi;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/**
 *
 * @author carloschavez
 */
public class DijkstraShortestPath {
    
    //calculates shortest distance
    public void calculateShortestPaths(Vertex place){
 
       place.setDistance(0);
       PriorityQueue<Vertex> prioridad = new PriorityQueue<>(); //creates priorityQueue to control vertices
       prioridad.add(place);    
       place.setVisited(true);
       
       while(!prioridad.isEmpty()){
           
           //gets priority vertex 
           Vertex verdad = prioridad.poll();    
           //search through edges
           for(Edge road : verdad.getAdjacenciesList()){
               
              Vertex mark = road.getMarkVertex();
              
              if(!mark.isVisited()){
                  //calculates new distance for edges
                  double newDistance = verdad.getDistance() + road.getWeight();
                  //adjustes priority queue by comparing each edge distance
                  if(newDistance < mark.getDistance()){
                      prioridad.remove(mark);
                      mark.setDistance(newDistance);
                      mark.setPredecessor(verdad);
                      prioridad.add(mark);
                  }
              }
           }
           verdad.setVisited(true);
       }
    }
}
