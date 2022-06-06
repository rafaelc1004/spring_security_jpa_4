
package cl.security.java.interfaceRepository;

import cl.security.java.modelo.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    @Query("select u from Usuario u where u.user = ?1")
    public Optional<Usuario> finnByUser(String user);
}
