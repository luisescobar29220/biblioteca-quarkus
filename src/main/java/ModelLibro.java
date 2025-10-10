import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "libro")
public class ModelLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String titulo;

    @Column(name = "paginas")
    private int cantidadP;

    private int publicacion;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id", nullable = false)
    private ModelAutor autor;

    // 🔹 Constructor vacío (necesario para JPA)
    public ModelLibro() {}

    // 🔹 Constructor con parámetros (opcional)
    public ModelLibro(String titulo, int cantidadP, int publicacion) {
        this.titulo = titulo;
        this.cantidadP = cantidadP;
        this.publicacion = publicacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantidadP() {
        return cantidadP;
    }

    public void setCantidadP(int cantidadP) {
        this.cantidadP = cantidadP;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public ModelAutor getAutor() {
        return autor;
    }

    public void setAutor(ModelAutor autor) {
        this.autor = autor;
    }
}
