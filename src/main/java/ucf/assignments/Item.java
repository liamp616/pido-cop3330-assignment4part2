package ucf.assignments;

import java.time.LocalDate;

public class Item {
    //  desc: String
    private String description;
    //  dueDate: String
    private LocalDate date;
    //  complete: boolean
    private Boolean complete;

    //  create constructor
    public Item(String description, LocalDate date, Boolean complete) {
        this.description = description;
        this.date = date;
        this.complete = complete;
    }

    @Override
    public String toString(){
        String isComplete;
        if(getComplete().equals(true)) {
            isComplete = "completed";
        } else {
            isComplete = "incomplete";
        }
        //  return this.getDate() + "\t" + this.getDescription()+ "\t\t\t" + complete;
        return (this.getDate() + "\t" + this.getDescription() + " - " + isComplete);
    }

    //  create getter and setter methods for variables
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public String getCompletedBoolean(Boolean complete) {
        String temp;
        if(getComplete().equals(true)) {
            temp = "completed";
        } else {
            temp = "incomplete";
        }

        return temp;
    }
}
