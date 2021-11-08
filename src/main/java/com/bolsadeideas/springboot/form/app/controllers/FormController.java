package com.bolsadeideas.springboot.form.app.controllers;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
  @GetMapping("/form")
  public String form(Model model) {
    model.addAttribute("titulo", "Formulario");
    return "form";
  }

  //Asignando valor por valor a un objeto
  // @PostMapping("/form")
  // public String procesar(Model model, @RequestParam String username, @RequestParam String password, @RequestParam String email) {
  //   Usuario usuario = new Usuario();
  //   usuario.setUsername(username);
  //   usuario.setPassword(password);
  //   usuario.setEmail(email);
  //   model.addAttribute("titulo", "Formulario");
  //   model.addAttribute("usuario", usuario);
  //   return "resultado";
  // }

  //Asignando valor por referencia a un objeto de manera dinamica y mas corta de la manera anterior
  @PostMapping("/form")
  public String procesar(Usuario usuario, Model model) {
    model.addAttribute("titulo", "Formulario");
    model.addAttribute("usuario", usuario);
    return "resultado";
  }
}
