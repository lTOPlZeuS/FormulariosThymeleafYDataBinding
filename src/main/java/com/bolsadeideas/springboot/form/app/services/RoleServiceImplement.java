package com.bolsadeideas.springboot.form.app.services;

import java.util.ArrayList;
import java.util.List;

import com.bolsadeideas.springboot.form.app.models.domain.Role;

import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplement implements RoleService {

  private List<Role> roles;

  public RoleServiceImplement() {
    this.roles =  new ArrayList<>();
    this.roles.add(new Role(1,"USER","ROLE_USER"));
    this.roles.add(new Role(2,"ADMIN","ROLE_ADMIN"));
    this.roles.add(new Role(3,"DBA","ROLE_DBA"));
    this.roles.add(new Role(4,"ROOT","ROLE_ROOT"));
  }

  @Override
  public List<Role> listar() {
    return this.roles;
  }

  @Override
  public Role obtenerPorId(Integer id) {
    Role resultado = null;
    for (Role role : roles) {
      if(role.getId() == id) {
        resultado = role;
        break;
      }
    }
    return resultado  ;
  }
}
