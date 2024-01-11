package co.com.bancolombia.model.tarea.gateways;

import co.com.bancolombia.model.tarea.Tarea;

import java.util.List;

public interface TareaRepository {
    List<Tarea> getTareas();

    Tarea getTareaById(long id);
    void crearTarea(Tarea tarea);
    boolean eliminarTarea(long id);
}
