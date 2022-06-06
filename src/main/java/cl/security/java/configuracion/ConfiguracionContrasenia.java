
package cl.security.java.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ConfiguracionContrasenia {
    
    @Bean
    public PasswordEncoder codificadorContrasenia(){
        return new BCryptPasswordEncoder();
    }
    
    
}
