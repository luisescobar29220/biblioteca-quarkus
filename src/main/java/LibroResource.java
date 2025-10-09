import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/libros")
public class LibroResource {

    @Inject
    LibroService libroService;

    @GET
    public List<ModelLibro> listar() {
        return libroService.lista();
    }

    @GET
    @Path("/{id}")
    public ModelLibro buscarId(@PathParam("id") Long id) {
        return libroService.obtener(id);
    }

    @POST
    public ModelLibro crear(@Valid LibroDTO dto) {
        return libroService.crear(dto);
    }

    @PUT
    @Path("/{id}")
    public ModelLibro actualizar(@PathParam("id") Long id, @Valid LibroDTO dto) {
        return libroService.actualizar(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void eliminar(@PathParam("id") Long id) {
        libroService.eliminar(id);
    }
}
