/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.security.java.service;

import cl.security.java.interfaceRepository.UsuarioRepository;
import cl.security.java.modelo.Usuario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private PasswordEncoder codificadorContrasenia;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public long cantidadUsuarios(){
        return usuarioRepository.count();
    }
    
    public Optional searchUsername(String user){
        return usuarioRepository.finnByUser(user);
    }
    
    public Usuario crearUsuario(Usuario usuario){
        String contraseniaCodificada = codificadorContrasenia.encode(usuario.getPassword());
        usuario.setPassword(contraseniaCodificada);
        return usuarioRepository.saveAndFlush(usuario);
    }
    
}
