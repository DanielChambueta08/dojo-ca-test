package co.com.bancolombia.jpa.tarea;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class TareaDTO {
    @Id
    private Long id;

    private String titulo;

    private String descripcion;

    private String estado;
}
