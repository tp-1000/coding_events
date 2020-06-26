package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class EventCategory extends AbstractEntity{


    @Size(min = 3, max = 50, message = "Category must be between 3-50 characters")
    @NotBlank(message="Category is required")
    private String name;

    @OneToMany(mappedBy = "eventCategory")
    private List<Event> EVENT = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEVENT() {
        return EVENT;
    }

    @Override
    public String toString() {
        return name;
    }

}
