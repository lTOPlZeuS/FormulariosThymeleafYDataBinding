package com.bolsadeideas.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import com.bolsadeideas.springboot.form.app.services.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolesEditor extends PropertyEditorSupport {
  
  @Autowired
  private RoleService roleService;

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    try {
      Integer id = Integer.parseInt(text);
      setValue(roleService.obtenerPorId(id));
    } catch (NumberFormatException e) {
      setValue(null);
    }
  }
}
