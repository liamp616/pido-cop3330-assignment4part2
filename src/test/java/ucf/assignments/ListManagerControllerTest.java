package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListManagerControllerTest {


    @Test
    void addListClicked() {
        //  click the "Add List" button
        //  get the new arraylist with one list in it
        //  assert that the created arraylist equals an already made arraylist with one list in it
    }

    @Test
    void removeListClicked() {
        //  click the "Remove List" button
        //  remove the list from the arraylist
        //  assert that the arraylist equals an empty arraylist
    }

    @Test
    void editListTitleClicked() {
        //  click the "Edit List" button
        //  input "Test" for the new title
        //  assert that the arraylist that contains the list equals another arraylist with list that contains the title "Test"
    }

    @Test
    void addItemClicked() {
        //  click the "Add Item" button
        //  assert that the list equals another list that has an item in it
    }

    @Test
    void removeItemClicked() {
        //  click the "Remove Item" button
        //  assert that the list equals an empty list
    }

    @Test
    void editDescClicked() {
        //  click the "Edit Description" button
        //  input "Test" for the new description
        //  assert that the arraylist that contains the list equals another arraylist with list that contains the description "Test"
    }

    @Test
    void editDueDateClicked() {
        //  click the "Edit Due Date" button
        //  input "Test" for the new due date
        //  assert that the arraylist that contains the list equals another arraylist with list that contains the due date "Test"
    }

    @Test
    void markAsCompleteClicked() {
        //  click the "Mark as Complete" button
        //  assert that the list's complete boolean is true
    }

    @Test
    void displayIncompleteClicked() {
        //  not sure how to test this to be quite honest
    }

    @Test
    void displayCompletedClicked() {
        //  not sure how to test this to be quite honest
    }

    @Test
    void exportListClicked() {
        //  click the "Export List" button and export an empty list
        //  assert that the txt file made equals a pre-made txt file that contains the contents of an empty list
    }

    @Test
    void exportAllListsClicked() {
        //  click the "Export All Lists" button and export several empty lists
        //  assert that the txt file made equals a pre-made txt file that contains the contents of the empty lists
    }

    @Test
    void importListClicked() {
        //  click the "Import List" button and import the txt file

        //  not sure how to test this to be quite honest
    }

    @Test
    void importListsClicked() {
        //  click the "Import All Lists" button and import the txt file

        //  not sure how to test this to be quite honest
    }
}