import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LibroActualizarDTO(
        @NotBlank @Size(max = 200) String titulo,
        int cantidadP,
        int publicacion,
        Long autorId // opcional
) {
}
