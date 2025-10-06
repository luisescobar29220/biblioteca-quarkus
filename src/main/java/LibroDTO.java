import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LibroDTO(@NotBlank @Size(max = 200) String titulo,
                       int cantidadP,            // sin @Min/@Max como pediste
                       int publicacion,          // año de publicación
                       @NotNull Long autorId) {
}
