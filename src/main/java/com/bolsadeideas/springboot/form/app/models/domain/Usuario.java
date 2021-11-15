package com.bolsadeideas.springboot.form.app.models.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.bolsadeideas.springboot.form.app.validation.IdentificadorRegex;
import com.bolsadeideas.springboot.form.app.validation.Requerido;

import org.springframework.format.annotation.DateTimeFormat;

public class Usuario {
  //@Pattern(regexp = "[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}")
  @IdentificadorRegex
  private String identificador;
  
  //@NotEmpty(message = "El campo nombre no puede estar vacío")
  private String nombre;
  
  // @NotEmpty
  @Requerido
  private String apellido;
  
  @NotBlank
  @Size(min = 6, max = 8)
  private String username;
  
  @NotEmpty
  @Email
  private String email;
  
  @NotEmpty
  private String password;
  
  @NotNull
  @Min(5)@Max(15)
  private Integer cuenta;

  @NotNull
  @Past
  // @Future
  // @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date fechaNacimiento;

  @NotNull
  private Pais pais;
  
  @NotEmpty
  private List<Role> roles;

  private Boolean habilitado;

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

  public Integer getCuenta() {
    return cuenta;
  }
	
  public void setCuenta(Integer cuenta) {
    this.cuenta = cuenta;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public Pais getPais() {
    return pais;
  }

  public void setPais(Pais pais) {
    this.pais = pais;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public Boolean getHabilitado() {
    return habilitado;
  }

  public void setHabilitado(Boolean habilitado) {
    this.habilitado = habilitado;
  }
}
