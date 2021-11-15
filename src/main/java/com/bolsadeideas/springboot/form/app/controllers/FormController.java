package com.bolsadeideas.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bolsadeideas.springboot.form.app.editors.NombreMayusculaEditor;
import com.bolsadeideas.springboot.form.app.editors.PaisPropertyEditors;
import com.bolsadeideas.springboot.form.app.editors.RolesEditor;
import com.bolsadeideas.springboot.form.app.models.domain.Pais;
import com.bolsadeideas.springboot.form.app.models.domain.Role;
import com.bolsadeideas.springboot.form.app.models.domain.Usuario;
import com.bolsadeideas.springboot.form.app.services.PaisService;
import com.bolsadeideas.springboot.form.app.services.RoleService;
import com.bolsadeideas.springboot.form.app.validation.UsuarioValidador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("usuario")
public class FormController {
  @Autowired
  private UsuarioValidador usuarioValidador;

  @Autowired
  private PaisService paisService;

  @Autowired
  private RoleService roleService;

  @Autowired
  private PaisPropertyEditors paisPropertyEditors;

  @Autowired
  private RolesEditor rolesEditor;

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.addValidators(usuarioValidador);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
    dateFormat.setLenient(false); // si estricto o tolerante
    // binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false)); pero si quieres mas especifico puedes hacer sobrescribir el metodo
    binder.registerCustomEditor(Date.class,"fechaNacimiento",new CustomDateEditor(dateFormat, true));
    binder.registerCustomEditor(String.class,"nombre",new NombreMayusculaEditor());

    binder.registerCustomEditor(Pais.class, "pais", paisPropertyEditors);
    binder.registerCustomEditor(Role.class, "roles", rolesEditor);
  }

  @ModelAttribute("listaRoles")
  public List<Role> listaRoles() {
    return this.roleService.listar();
  }

  @ModelAttribute("listaRolesString")
  public List<String> listaRolesString() {
    List<String> roles = new ArrayList<String>();
    roles.add("ROLE_USER");
    roles.add("ROLE_ADMIN");
    roles.add("ROLE_SUPERVISOR");
    return roles;
  }

  @ModelAttribute("listaRolesMap")
  public Map<String,String> listaRolesMap() {
    Map<String,String> roles = new HashMap<String,String>();
    roles.put("ROLE_USER", "USER");
    roles.put("ROLE_ADMIN", "ADMIN");
    roles.put("ROLE_SUPERVISOR", "SUPERVISOR");
    return roles;
  }

  @ModelAttribute("listaPaises")
  public List<Pais> listaPaises() {
    return paisService.listar();
  }

  @ModelAttribute("paises")
  public List<String> paises() {
    return Arrays.asList("México", "Estados Unidos", "Canadá", "Brasil", "Chile");
  }

  @ModelAttribute("paisesMap")
  public Map<String,String> paisesMap() {
    Map<String,String> paises = new HashMap<String,String>();
    paises.put("MX", "México");
    paises.put("US", "Estados Unidos");
    paises.put("CA", "Canadá");
    paises.put("BR", "Brasil");
    paises.put("CL", "Chile");
    return paises;
  }

  @GetMapping("/form")
  public String form(Model model) {
    Usuario usuario = new Usuario();
    usuario.setNombre("Juan");
    usuario.setApellido("Perez");
    usuario.setIdentificador("22.212.666-F");
    usuario.setHabilitado(true);
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
    // usuarioValidador.validate(usuario, result);
    if (result.hasErrors()) {
      model.addAttribute("titulo", "Formulario");
      // Manera larga de validar errores
      // Map<String, String> errors = new HashMap<>();
      // result.getFieldErrors().forEach(error -> {
      //   errors.put(error.getField(), error.getDefaultMessage());
      // });
      // model.addAttribute("errors", errors);
      return "form";
    }
    return "redirect:/ver";
  }

  @GetMapping("/ver")
  public String ver(@SessionAttribute(name="usuario", required=false) Usuario usuario, Model model, SessionStatus status) {
    if (usuario == null) {
      return "redirect:/form";
    }
    model.addAttribute("titulo", "Formulario");
    status.setComplete();
    return "resultado";
  }
}
