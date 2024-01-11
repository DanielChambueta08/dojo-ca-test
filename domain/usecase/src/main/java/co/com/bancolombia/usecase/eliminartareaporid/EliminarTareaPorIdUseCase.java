package co.com.bancolombia.usecase.eliminartareaporid;

import co.com.bancolombia.model.tarea.Tarea;
import co.com.bancolombia.model.tarea.gateways.TareaRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class EliminarTareaPorIdUseCase {
    private final TareaRepository tareaRepository;

    public boolean eliminarTareaPorId(long id) {
        Tarea tarea = tareaRepository.getTareaById(id);
        if (tarea != null) {
            tareaRepository.eliminarTarea(id);
            return true; // Tarea eliminada con éxito
        } else {
            return false; // Tarea no encontrada
        }
    }
}
