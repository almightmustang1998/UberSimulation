package faketaxi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author carloschavez
 */
public class FastestRouteController implements Initializable {
    @FXML
    private Pane rootPane;
    
    @FXML private Text rapido = new Text();
    
    //reloads the main page
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
    Node node = (Node) event.getSource();
    Stage stage = (Stage) node.getScene().getWindow();
    Scene scene = stage.getScene();
    
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Map.fxml"));
    rootPane =fxmlLoader.load();
    //puts drivers in different random locations
    for (int i = 0; i < FakeTaxi.drivers.size(); i++) {
            Driver driver = FakeTaxi.drivers.get(i);
         	ImageView carview = new ImageView("faketaxi/topcar.jpg");
                carview.setFitWidth(30);
                carview.setFitHeight(30);
         	carview.setX((double)driver.location.getX());
                carview.setY((double)driver.location.getY());
               rootPane.getChildren().add(carview); //adds drivers to map
       	}
    scene.setRoot(rootPane);
  }
    /**
     * Initializes the controller class.
     */
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        Vertex at = new Vertex("at");  //used to figure out shortest path
        Vertex go = new Vertex("go");  //used to figure out shortest path
        
        //holds algorithm for shortest path
        DijkstraShortestPath dijkstra = new DijkstraShortestPath();
        
     //goes through map set to create vertices
     //based on user input
      for(String key : FakeTaxi.vertices.keySet()){
          if(FakeTaxi.currently.equals(key))
             at = FakeTaxi.vertices.get(key);
          
          if(FakeTaxi.destiny.equals(key))
              go = FakeTaxi.vertices.get(key);    
      }
        //determine shortest path
        dijkstra.calculateShortestPaths(at);
        rapido.setText("Shortest path distance is :" + go.getDistance());
         
    }
}
