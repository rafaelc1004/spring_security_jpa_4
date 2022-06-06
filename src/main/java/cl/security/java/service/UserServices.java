/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.security.java.service;

import cl.security.java.modelo.Usuario;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements UserDetailsService{
    

    @Autowired
    private UsuarioService usuarioService;
    
    @Override
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<Usuario> usuarioOp = usuarioService.searchUsername(username);
       if(usuarioOp.isPresent()){
           return contruirObjetoUserDetails(usuarioOp.get());
       }else{
           throw new UsernameNotFoundException("Usuario no Encontrado");
       }
    }

    private UserDetails contruirObjetoUserDetails(Usuario usuario) {
        User.UserBuilder builder = User.builder();
        Collection<GrantedAuthority>roles = construirRolesDeUsuario(usuario);
        builder.username(usuario.getUser())
                .password(usuario.getPassword())
                .authorities(roles);
        return builder.build();
    }

    private Collection<GrantedAuthority> construirRolesDeUsuario(Usuario usuario) {
        HashSet<GrantedAuthority> roles = new HashSet<>();
        for(String rol : usuario.getRoles().split(",")){
            roles.add(new SimpleGrantedAuthority(rol));
        }
        return roles;
    }
    
}
