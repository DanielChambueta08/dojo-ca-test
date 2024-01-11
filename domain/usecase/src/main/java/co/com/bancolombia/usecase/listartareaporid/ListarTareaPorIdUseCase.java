package co.com.bancolombia.usecase.listartareaporid;

import co.com.bancolombia.model.tarea.Tarea;
import co.com.bancolombia.model.tarea.gateways.TareaRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class ListarTareaPorIdUseCase {
    private final TareaRepository tareaRepository;

    public Tarea listarTareaPorId(long id) {
        return tareaRepository.getTareaById(id);
    }
}
