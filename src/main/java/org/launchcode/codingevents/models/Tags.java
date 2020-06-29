package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Tags extends AbstractEntity {

    @NotBlank(message = "Cannot be Blank")
    @Size(message = "Needs 3-15 characters", min=3, max=15)
    private String name;

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
