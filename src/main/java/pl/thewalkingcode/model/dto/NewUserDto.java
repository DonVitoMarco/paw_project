package pl.thewalkingcode.model.dto;

public class NewUserDto {

    private String username;
    private String password;

    public NewUserDto() {
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
