package Serialization;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String password;
    private static int total = 0;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        total++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", password=" + password + ", total=" + total + "]";
    }
}
