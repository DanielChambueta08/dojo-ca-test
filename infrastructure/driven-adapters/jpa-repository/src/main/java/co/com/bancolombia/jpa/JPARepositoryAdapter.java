package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.jpa.tarea.TareaDTO;
import co.com.bancolombia.model.tarea.Tarea;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<Tarea, TareaDTO, String, JPARepository>
// implements ModelRepository from domain
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Tarea.class));
    }

    @Override
    public List<Tarea> getTareas() {
        return super.findAll();
    }
}
