package co.com.bancolombia.usecase.creartarea;

import co.com.bancolombia.model.tarea.Tarea;
import co.com.bancolombia.model.tarea.gateways.TareaRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class CrearTareaUseCase {
    private final TareaRepository tareaRepository;

    public Tarea crearTarea(Tarea tarea) {
        tareaRepository.crearTarea(tarea);
        return tarea;
    }
}
