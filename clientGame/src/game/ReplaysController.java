/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author yasmine
 */
public class ReplaysController implements Initializable {
    @FXML
    private AnchorPane replayPane;

    @FXML
    private ListView<?> replays;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button back;

    @FXML
    private Button next;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
          }
    
    @FXML
    void cell00Click(ActionEvent event) {

    }

    @FXML
    void cell01Click(ActionEvent event) {

    }

    @FXML
    void cell03Click(ActionEvent event) {

    }

    @FXML
    void cell10Click(ActionEvent event) {

    }

    @FXML
    void cell11Click(ActionEvent event) {

    }

    @FXML
    void cell12Click(ActionEvent event) {

    }

    @FXML
    void cell20Click(ActionEvent event) {

    }

    @FXML
    void cell21Click(ActionEvent event) {

    }

    @FXML
    void cell22Click(ActionEvent event) {

    }

    @FXML
    void onBack(ActionEvent event) {

    }

    @FXML
    void onNext(ActionEvent event) {

    }

    @FXML
    void openVideo(MouseEvent event) {

    }


    
}
