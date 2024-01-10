package co.com.bancolombia.model.tarea.gateways;

import co.com.bancolombia.model.tarea.Tarea;

import java.util.List;

public interface TareaRepository {
    List<Tarea> getTareas();
    void crearTarea(Tarea tarea);
//    void deleteTarea(long id);
}
