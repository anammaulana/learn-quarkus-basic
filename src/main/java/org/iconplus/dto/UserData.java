package org.iconplus.dto;

public class UserData {
    private String name;
    private String email;
    
    // Constructor with parameters
    public UserData(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }
}
