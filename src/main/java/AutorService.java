import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
@Transactional
public class AutorService {

    @Inject
    AutorRepository autorRepository;

    public List<ModelAutor> listar(){
        return autorRepository.listAll();
    }

    public ModelAutor obtener(Long id){
        return autorRepository.findByIdOptional(id)
                .orElseThrow(()-> new NotFoundException("Autor "+id+" no se encontrado"));
    }

    public ModelAutor crear(AutorDTO dto){
        if (autorRepository.existsByCorreo(dto.correo()))
            throw new IllegalArgumentException("El correo ya está registrado");
        var a = new ModelAutor(dto.nombre(), dto.correo());
        autorRepository.persist(a);
        return a;
    }

    public ModelAutor actualizar(Long id, AutorDTO dto){
        var a = obtener(id);
        a.setNombre(dto.nombre());
        a.setCorreo(dto.correo());
        return a;
    }

    public void eliminar(Long id){
        if(!autorRepository.deleteById(id))
            throw new NotFoundException("Autor " +id+ " no encontrado");
    }
}
