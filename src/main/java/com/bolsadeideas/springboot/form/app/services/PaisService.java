package com.bolsadeideas.springboot.form.app.services;

import java.util.List;

import com.bolsadeideas.springboot.form.app.models.domain.Pais;

import org.springframework.stereotype.Component;

public interface PaisService {
  public List<Pais> listar();
  public Pais obtenerPorId(Integer id);
}
