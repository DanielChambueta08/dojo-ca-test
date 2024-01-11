package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.jpa.tarea.TareaDTO;
import co.com.bancolombia.model.tarea.Tarea;
import co.com.bancolombia.model.tarea.gateways.TareaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Tarea getTareaById(long id) {
        return super.findById(String.valueOf(id));
    }

    @Override
    public void crearTarea(Tarea tarea) {
        super.save(tarea);
    }

    @Override
    public boolean eliminarTarea(long id) {
        return super.deleteById(String.valueOf(id));
    }

}
