package com.bolsadeideas.springboot.form.app.controllers;

import java.util.HashMap;
import java.util.Map;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
  @GetMapping("/form")
  public String form(Model model) {
    Usuario usuario = new Usuario();
    model.addAttribute("usuario", usuario);
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
  public String procesar(@Validated Usuario usuario, BindingResult result, Model model) {
    model.addAttribute("titulo", "Formulario");
    if (result.hasErrors()) {
      Map<String, String> errors = new HashMap<>();
      result.getFieldErrors().forEach(error -> {
        errors.put(error.getField(), error.getDefaultMessage());
      });
      model.addAttribute("errors", errors);
      return "form";
    }
    model.addAttribute("usuario", usuario);
    return "resultado";
  }
}
