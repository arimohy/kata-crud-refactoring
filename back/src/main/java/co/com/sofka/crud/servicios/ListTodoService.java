package co.com.sofka.crud.servicios;

import co.com.sofka.crud.entidades.ListTodo;
import co.com.sofka.crud.repositorio.ListTodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListTodoService {
    @Autowired
    private ListTodoRepository repository;

    public Iterable<ListTodo> list(){
        return repository.findAll();
    }

    public ListTodo save(ListTodo listTodo){
        return repository.save(listTodo);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }

    public ListTodo get(Long id){
        return repository.findById(id).orElseThrow();
    }

}
