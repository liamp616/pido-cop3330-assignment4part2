package ucf.assignments;

import java.time.LocalDate;

public class Item {
    //  desc: String
    private String description;
    //  dueDate: String
    private LocalDate date;
    //  complete: boolean
    private Boolean complete = false;

    //  create constructor
    public Item(String description, LocalDate date) {
        this.description = description;
        this.date = date;
    }

    @Override
    public String toString(){
        //  return this.getDate() + "\t" + this.getDescription()+ "\t\t\t" + complete;
        return String.format(this.getDate() + "\t" + "%-140s\t" + this.getComplete(), description);
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
}
