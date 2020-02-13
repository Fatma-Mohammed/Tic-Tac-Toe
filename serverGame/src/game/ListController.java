/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author FreeComp
 */
public class ListController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private AnchorPane listPane;

    @FXML
    private ListView<?> replayList;

    @FXML
    private Button listBackBtn;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
     @FXML
    void goMain(ActionEvent event) {
        try {
            Pane main = FXMLLoader.load(getClass().getResource("MainXML.fxml"));
            listPane.getChildren().setAll(main);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void goReplaysGrid(MouseEvent event) {
        try {
            System.out.println("aaaaa");
            Pane main = FXMLLoader.load(getClass().getResource("Replays.fxml"));
            System.out.println("bbbbbb");
            listPane.getChildren().setAll(main);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
