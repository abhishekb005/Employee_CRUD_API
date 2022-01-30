package com.consultadd.training.model;

public class AuthenticationRequest {
    public String getUsername() {
        return username;
    }
    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public AuthenticationRequest() {

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
    private String username;
    private String password;
}
