package com.portolio.forms;


public class RegistroUsuarioForm {

    private String login;
    private String senha;
    private String email;

    public RegistroUsuarioForm() {
    }

    public RegistroUsuarioForm(String login, String senha, String email) {
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }
}

