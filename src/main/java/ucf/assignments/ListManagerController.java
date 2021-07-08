package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListManagerController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datePicker.setValue(LocalDate.now());
    }

    //  make @FXML variables
    @FXML
    Button addButton;

    @FXML
    Button removeButton;

    @FXML
    Button clearButton;

    @FXML
    Button updateButton;

    @FXML
    Button exportButton;

    @FXML
    Button importButton;

    @FXML
    Button markCompleteButton;

    @FXML
    Button markIncompleteButton;

    @FXML
    Button displayCompletedButton;

    @FXML
    Button displayIncompletedButton;

    @FXML
    Button displayAllButton;

    @FXML
    DatePicker datePicker;

    @FXML
    TextField descriptionTextField;

    @FXML
    ListView<Item> itemList;

    //  create observable list
    ObservableList<Item> list = FXCollections.observableArrayList();

    //  refreshes the date picker and the description text box
    private void refresh() {
        datePicker.setValue(LocalDate.now());
        descriptionTextField.setText(null);
        itemList.refresh();
    }

    @FXML
    private void addItem(Event e) {
        //  make a new item and add it to the observable list
        list.add(new Item(descriptionTextField.getText(), datePicker.getValue()));
        //  add the observable list to the list view
        itemList.setItems(list);
        refresh();
    }

    @FXML
    private void removeItem(Event e) {
        //  find the index of the selected item
        int index = itemList.getSelectionModel().getSelectedIndex();
        //  remove the index of the list
        itemList.getItems().remove(index);
        refresh();
    }

    @FXML
    private void clearAll(Event e) {
        itemList.getItems().clear();
        refresh();
    }

    public void listViewSelectedItem() {
        itemList.setOnMouseClicked(event -> {
            String selectedItem = itemList.getSelectionModel().getSelectedItem().getDescription();
            int index = itemList.getSelectionModel().getSelectedIndex();
            descriptionTextField.setText(selectedItem);
            datePicker.setValue(itemList.getItems().get(index).getDate());
        });
        refresh();
    }

    @FXML
    private void updateItem(Event e) {
        int index = itemList.getSelectionModel().getSelectedIndex();
        itemList.getItems().get(index).setDate(datePicker.getValue());
        itemList.getItems().get(index).setDescription(descriptionTextField.getText());
        refresh();
    }

    @FXML
    private void exportList(Event e) {
        //  this can be used from the menu bar
        //  open up a save as window and can save the file
    }

    @FXML
    private void importList(Event e) {
        //  this can be used from the menu bar
        //  open up an open window and can select the file
    }

    @FXML
    private void markComplete(Event e) {
        //  find the index of the selected item
        int index = itemList.getSelectionModel().getSelectedIndex();
        //  change the value of the boolean to true
        list.get(index).setComplete(true);
        refresh();
    }

    @FXML void markIncomplete(Event e) {
        //  find the index of the selected item
        int index = itemList.getSelectionModel().getSelectedIndex();
        //  change the value of the boolean to false
        list.get(index).setComplete(false);
        refresh();
    }

    @FXML
    private void displayComplete(Event e) {
        ObservableList<Item> complete = FXCollections.observableArrayList();

        //  find all items that have the complete boolean to true
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getComplete().equals(true)) {
                complete.add(list.get(i));
            }
        }
        //  display those items
        itemList.setItems(complete);
        refresh();
    }

    @FXML
    private void displayIncomplete(Event e) {
        ObservableList<Item> incomplete = FXCollections.observableArrayList();

        //  find all items that have the complete boolean to false
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getComplete().equals(false)) {
                incomplete.add(list.get(i));
            }
        }
        //  display those items
        itemList.setItems(incomplete);
        refresh();
    }

    @FXML
    private void displayAll(Event e) {
        itemList.setItems(list);
        refresh();
    }
}
