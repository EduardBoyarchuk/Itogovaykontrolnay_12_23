package Model;

import java.util.Date;

public class Animal {
    private String name;
    private Date birthdate;

    public Animal(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return birthdate;
    }
}

