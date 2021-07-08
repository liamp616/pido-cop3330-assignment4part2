package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListManagerController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    //  make @FXML variables

    //  make observable list

    @FXML
    private void addList(ActionEvent actionEvent) {
        //  get the title from titleTextField and a new eventList to the list with that title
    }

    @FXML
    private void removeList(ActionEvent actionEvent) {
        //  find the index of the selected item
        //  remove the index of the list
    }

    @FXML
    private void handleRightClick(ActionEvent actionEvent) {
        //  open a context menu when right clicking an element on the listview
    }

    @FXML
    private void exportList(ActionEvent actionEvent) {
        //  this can be used from the menu bar
        //  open up a save as window and can save the file
    }

    @FXML
    private void exportAllLists(ActionEvent actionEvent) {
        //  this can be used from the menu bar
        //  open up a save as window and can save the file
    }

    @FXML
    private void importList(ActionEvent actionEvent) {
        //  this can be used from the menu bar
        //  open up an open window and can select the file
    }

    @FXML
    private void importAllList(ActionEvent actionEvent) {
        //  this can be used from the menu bar
        //  open up an open window and can select the file
    }

    @FXML
    private void renameList(ActionEvent actionEvent) {
        //  this can be used from a right click
        //  open up another window where user can input a new title
    }

    @FXML
    private void addItem(ActionEvent actionEvent) {
        //  this can be used from a right click to open a new window
        //  open up another listview window where it will show all the items
    }

    @FXML
    private void removeItem(ActionEvent actionEvent) {
        //  find the index of the selected item
        //  remove the index of the list
    }

    @FXML
    private void editDueDate(ActionEvent actionEvent) {
        //  this can be used from a right click
        //  open up another window where user can input a new due date
    }

    @FXML
    private void editDesc(ActionEvent actionEvent) {
        //  this can be used from a right click
        //  open up another window where user can input a new due description
    }

    @FXML
    private void markComplete(ActionEvent actionEvent) {
        //  this can be used from a right click
        //  mark the complete boolean to true for this item
    }

    @FXML
    private void displayIncomplete(ActionEvent actionEvent) {
        //  find all items that have the complete boolean to false
        //  display those items
    }

    @FXML
    private void displayComplete(ActionEvent actionEvent) {
        //  find all items that have the complete boolean to true
        //  display those items
    }
}
