package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ListManagerController implements Initializable {

    FileChooser fileChooser = new FileChooser();

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
        list.add(new Item(descriptionTextField.getText(), datePicker.getValue(), false));
        System.out.println(datePicker.getValue());
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
        //  clear
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
    void exportList(javafx.scene.input.MouseEvent mouseEvent) {
        //  open up an open window and can select the file
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV (Comma delimited)", "*.csv"));
        File file = fileChooser.showSaveDialog(new Stage());

        if(file != null) {
            try {
                PrintWriter pw = new PrintWriter(file);
                StringBuilder sb = new StringBuilder();

                for(int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i).getDate());
                    sb.append(",");
                    sb.append(list.get(i).getDescription());
                    sb.append(",");
                    sb.append(list.get(i).getCompletedBoolean(list.get(i).getComplete()));
                    sb.append("\r\n");
                }
                pw.write(sb.toString());
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void importList(javafx.scene.input.MouseEvent mouseEvent) {
        String line = "";

        //  open up an open window and can select the file
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV (Comma delimited)", "*.csv"));
        File file = fileChooser.showOpenDialog(new Stage());
        itemList.getItems().clear();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null) {
                Boolean fromCSV;
                String[] values = line.split(",");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(values[0], formatter);

                if(values[2].equals("incomplete")) {
                    fromCSV = false;
                } else {
                    fromCSV = true;
                }
                list.add(new Item(values[1], date, fromCSV));

                itemList.setItems(list);
                refresh();
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
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
