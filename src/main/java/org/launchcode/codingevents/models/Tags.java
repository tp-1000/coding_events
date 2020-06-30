package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tags extends AbstractEntity {

    @NotBlank(message = "Cannot be Blank")
    @Size(message = "Needs 3-15 characters", min=3, max=15)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private final List<Event> events = new ArrayList<>();

    public String getName() {
        if(name==null) {
            return "";
        }

        return "#"+name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
