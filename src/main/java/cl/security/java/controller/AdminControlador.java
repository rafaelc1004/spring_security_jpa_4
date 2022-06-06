/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.security.java.controller;

import cl.security.java.modelo.Usuario;
import cl.security.java.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminControlador {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/instalar")
    public String instalar(){
        long cantidadUsuarios = usuarioService.cantidadUsuarios();
        if(cantidadUsuarios ==0){
            Usuario usuario = new Usuario(null, "rafael", "123456", "ADMIN");
            usuarioService.crearUsuario(usuario);
        }
        return"redirect:/";
    }

    @GetMapping("/index")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/reporte")
    public String reporte() {
        return "admin/reporte";
    }
}
