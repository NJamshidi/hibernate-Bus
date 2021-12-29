package ir.jamshidi.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Company extends BaseModel {
    @Column(name = "NAME", unique = true, length = 32)
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
