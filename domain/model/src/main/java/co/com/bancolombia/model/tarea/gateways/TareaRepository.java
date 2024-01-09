package co.com.bancolombia.model.tarea.gateways;

import co.com.bancolombia.model.tarea.Tarea;

import java.util.List;

public interface TareaRepository {
    public List<Tarea> getTareas();
}
