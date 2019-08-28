package br.edu.ifpb.domain.model;

import java.util.Objects;

public class SessionClient {

    private String name;
    private String email;
    private String token;

    public SessionClient() {}

    public SessionClient(String name, String email, String token) {
        this.name = name;
        this.email = email;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SessionClient{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionClient that = (SessionClient) o;
        return name.equals(that.name) &&
                email.equals(that.email) &&
                token.equals(that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, token);
    }
}
