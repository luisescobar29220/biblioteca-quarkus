import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
@Transactional
public class LibroService {

    @Inject
    LibroRepository libroRepository;
    AutorRepository autorRepository;

    public List<ModelLibro> lista(){
        return libroRepository.listAll();
    }

    public ModelLibro obtener(Long id){
        return libroRepository.findByIdOptional(id)
                .orElseThrow(()-> new NotFoundException("libr "+id+" no se encontrado"));
    }

    public ModelLibro crear(LibroDTO dto){
        ModelAutor autor = autorRepository.findByIdOptional(dto.autorId())
                .orElseThrow(()->new NotFoundException("Autor " +dto.autorId()+ " no encontrado"));

        var l = new ModelLibro(dto.titulo(), dto.cantidadP(), dto.publicacion());
        l.setAutor(autor);
        libroRepository.persist(l);
        return l;
    }

    public ModelLibro actualizar(Long id, LibroDTO dto){
        var l = obtener(id);
        var autor = autorRepository.findByIdOptional(dto.autorId())
                .orElseThrow(() -> new NotFoundException("Autor " + dto.autorId() + " no encontrado"));

        l.setTitulo(dto.titulo());
        l.setCantidadP(dto.cantidadP());
        l.setPublicacion(dto.publicacion());
        l.setAutor(autor);
        return l;
    }

    public void eliminar(Long id){
        if (!libroRepository.deleteById(id))
            throw new NotFoundException("Libro " + id + " no encontrado");
    }
}
