package com.bolsadeideas.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import com.bolsadeideas.springboot.form.app.models.domain.Pais;

import org.springframework.stereotype.Service;

@Service
public class PaisServiceImplement implements PaisService {

  private List<Pais> lista;

  public PaisServiceImplement() {
    this.lista = Arrays.asList(new Pais (1,"MX","México"),new Pais(2,"US","Estados Unidos"), new Pais(3,"CA","Canadá"), new Pais(4,"BR","Brasil"), new Pais(5,"CL","Chile"));
  }

  @Override
  public List<Pais> listar() {
    return lista;
  }

  @Override
  public Pais obtenerPorId(Integer id) {
    Pais resultado = null;
    for (Pais pais : lista) {
      if (pais.getId().equals(id)) {
        resultado = pais;
        break;
      }
    }
    return resultado;
  }
  
}
