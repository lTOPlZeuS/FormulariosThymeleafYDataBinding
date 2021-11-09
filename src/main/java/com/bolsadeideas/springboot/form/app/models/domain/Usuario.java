package com.bolsadeideas.springboot.form.app.models.domain;

import javax.validation.constraints.NotEmpty;

public class Usuario {
  private String identificador;
  @NotEmpty
  private String nombre;
  @NotEmpty
  private String apellido;
  @NotEmpty
  private String username;
  @NotEmpty
  private String email;
  @NotEmpty
  private String password;

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return this.apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
