package co.com.bancolombia.api;
import co.com.bancolombia.model.tarea.Tarea;
import co.com.bancolombia.usecase.creartarea.CrearTareaUseCase;
import co.com.bancolombia.usecase.eliminartareaporid.EliminarTareaPorIdUseCase;
import co.com.bancolombia.usecase.listartareaporid.ListarTareaPorIdUseCase;
import co.com.bancolombia.usecase.listartareas.ListarTareasUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final ListarTareasUseCase listarTareasUseCase;
    private final CrearTareaUseCase crearTareaUseCase;
    private final ListarTareaPorIdUseCase listarTareaPorIdUseCase;
    private final EliminarTareaPorIdUseCase eliminarTareaPorIdUseCase;


    @GetMapping(path = "/path")
    public String commandName() {
        return "Hello World";
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Tarea>> getTareas() {
        return new ResponseEntity<List<Tarea>>(
                listarTareasUseCase.getTareas(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/list/{id}")
    public ResponseEntity<Tarea> getTareaById(@PathVariable("id") long id) {
        Tarea tarea = listarTareaPorIdUseCase.listarTareaPorId(id);
        if (tarea != null) {
            System.out.println("Tarea encontrada con éxito");
            return new ResponseEntity<>(tarea, HttpStatus.OK);
        } else {
            System.out.println("Tarea no encontrada");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea newTarea) {
        Tarea tareaCreada = crearTareaUseCase.crearTarea(newTarea);
        if (tareaCreada == null) {
            System.out.println("Tarea ya existe");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else{
            System.out.println("Tarea creada con éxito");
            return new ResponseEntity<Tarea>(tareaCreada, new HttpHeaders(), HttpStatus.CREATED);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Tarea> eliminarTarea(@PathVariable("id") long id) {
        boolean tareaEliminada = eliminarTareaPorIdUseCase.eliminarTareaPorId(id);
        if (tareaEliminada) {
            System.out.println("Tarea eliminada con éxito");
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            System.out.println("Tarea no encontrada");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
