import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AutorRepository implements PanacheRepository<ModelAutor> {
    public boolean existsByCorreo(String correo){
        return find("correo", correo).firstResultOptional().isPresent();
}
}
