package faketaxi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author carloschavez
 */
public class MapController implements Initializable {
    
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private void handleHistory(ActionEvent event) throws Exception {
        //opens locations page
        AnchorPane pane = FXMLLoader.load(getClass().getResource("History.fxml"));
        rootPane.getChildren().setAll(pane);
        
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        //opens locations page
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Locations.fxml"));
     
        rootPane.getChildren().setAll(pane);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
