package com.bolsadeideas.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;
import java.security.Provider.Service;

import com.bolsadeideas.springboot.form.app.services.PaisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaisPropertyEditors extends PropertyEditorSupport {

  @Autowired
  private PaisService paisService;

  @Override
  public void setAsText(String idString) throws IllegalArgumentException {
    try {
      Integer id = Integer.parseInt(idString);
    this.setValue(paisService.obtenerPorId(id));
    } catch (NumberFormatException e) {
      this.setValue(null);
    }
  }
}
