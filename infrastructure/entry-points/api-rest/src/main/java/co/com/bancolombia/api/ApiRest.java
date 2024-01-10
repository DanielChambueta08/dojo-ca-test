package co.com.bancolombia.api;
import co.com.bancolombia.model.tarea.Tarea;
import co.com.bancolombia.usecase.listartareas.ListarTareasUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final ListarTareasUseCase listarTareasUseCase;


    @GetMapping(path = "/path")
    public String commandName() {
        return "Hello World";
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Tarea>> getTareas() {
        return new ResponseEntity<List<Tarea>>(
                listarTareasUseCase.getTareas(), new HttpHeaders(), HttpStatus.OK);
    }
}
