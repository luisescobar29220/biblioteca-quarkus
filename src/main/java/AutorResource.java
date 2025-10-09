import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/autores")
public class AutorResource {

    @Inject
    AutorService autorService;

    @GET
    public List<ModelAutor> listar(){
        return autorService.listar();
    }

    @GET
    @Path("/{id}")
    public ModelAutor buscarId(@PathParam("id") Long id){
        return autorService.obtener(id);
    }

    @POST
    public ModelAutor crearA(@Valid AutorDTO dto){
        return autorService.crear(dto);
    }

    @PUT
    @Path("/{id}")
    public ModelAutor actualizarA(@PathParam("id") Long id, @Valid AutorDTO dto){
        return autorService.actualizar(id,dto);
    }
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){ autorService.eliminar(id); }
}
