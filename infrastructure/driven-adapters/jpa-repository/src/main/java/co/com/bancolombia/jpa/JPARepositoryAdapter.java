package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.jpa.tarea.TareaDTO;
import co.com.bancolombia.model.tarea.Tarea;
import co.com.bancolombia.model.tarea.gateways.TareaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<Tarea, TareaDTO, String, JPARepository>
implements TareaRepository
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Tarea.class));
    }

    @Override
    public List<Tarea> getTareas() {
        return super.findAll();
    }

    //El error sale porque espera un objeto tipo tarea y recibe un arreglo con id, nombre, titulo, estado
    @Override
    public void crearTarea(Tarea tarea) {
        super.save(tarea);
    }

}
