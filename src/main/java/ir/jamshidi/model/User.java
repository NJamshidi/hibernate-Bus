package ir.jamshidi.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends BaseModel {
    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "USERNAME", unique = true,length = 32)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
