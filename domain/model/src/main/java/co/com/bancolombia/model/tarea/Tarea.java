package co.com.bancolombia.model.tarea;
import lombok.*;
//import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Tarea {
    private Long id;
    private String titulo;
    private String descripcion;
    private String estado;
}
