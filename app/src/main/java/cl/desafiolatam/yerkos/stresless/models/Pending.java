package cl.desafiolatam.yerkos.stresless.models;

import com.orm.SugarRecord;

public class Pending extends SugarRecord {

    private String name, description;
    private boolean done;

    public Pending() {
    }

    public Pending(String name, String description, boolean done) {
        this.name = name;
        this.description = description;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
