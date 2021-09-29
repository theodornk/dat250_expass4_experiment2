package no.hvl.dat110.rest.counters;

import lombok.Data;
import com.google.gson.Gson;

@Data
public class Todo {
    private Long id;
    private String summary;
    private String description;

    public Todo() {
        this.id = 0L;
        this.summary = "Study";
        this.description = "Remember to do the DAT250 assignment.";
    }


    public Todo(Long id, String summary, String description){
        this.id = id;
        this.summary = summary;
        this.description = description;
    }



    String toJson () {

        Gson gson = new Gson();

        String jsonInString = gson.toJson(this);

        return jsonInString;
    }
}
