/* CIS 112
 *
 */
package faketaxi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author carloschavez
 */
public class HistoryController implements Initializable {

    @FXML
    private Text trip;
    @FXML
    private AnchorPane rootPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        while(!FakeTaxi.userHistory.isEmpty()){
          History obj = FakeTaxi.userHistory.pop();
          trip.setText(obj.toString());
        }   
    }  
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
    Node node = (Node) event.getSource();
    Stage stage = (Stage) node.getScene().getWindow();
    Scene scene = stage.getScene();
    
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Map.fxml"));
    rootPane =fxmlLoader.load();
    for (int i = 0; i < FakeTaxi.drivers.size(); i++) {
            Driver driver = FakeTaxi.drivers.get(i);
         	ImageView carview = new ImageView("faketaxi/topcar.jpg");
                carview.setFitWidth(30);
                carview.setFitHeight(30);
       		//carview.relocate((double)driver.location.getX(), (double)driver.location.getY());
         	carview.setX((double)driver.location.getX());
                carview.setY((double)driver.location.getY());
               rootPane.getChildren().add(carview); //adds drivers to map
       	}
    scene.setRoot(rootPane);
  }
    
}
