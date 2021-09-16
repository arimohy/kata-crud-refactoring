package co.com.sofka.crud.controlador;

import co.com.sofka.crud.entidades.ListTodo;
import co.com.sofka.crud.entidades.Todo;
import co.com.sofka.crud.servicios.ListTodoService;
import co.com.sofka.crud.servicios.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ListTodoController {
    @Autowired
    private ListTodoService service;

    @GetMapping(value = "api/lists")
    public Iterable<ListTodo> list(){
        return service.list();
    }

    @PostMapping(value = "api/list")
    public ListTodo save(@RequestBody ListTodo listTodo){
        return service.save(listTodo);
    }

    @PutMapping(value = "api/list")
    public ListTodo update(@RequestBody ListTodo listTodo){
        if(listTodo.getId() != null){
            return service.save(listTodo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/list")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/list")
    public ListTodo get(@PathVariable("id") Long id){
        return service.get(id);
    }

}