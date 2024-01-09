package co.com.bancolombia.model.tarea;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Tarea {
    private Long id;
    private String titulo;
    private String descripcion;
    private String estado;
}
