package pl.thewalkingcode.model.dto;

import javax.validation.constraints.NotNull;

public class NewUserDto {

    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String matchingPassword;

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

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

}
