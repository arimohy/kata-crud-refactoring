package co.com.sofka.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;


    public Iterable<Todo> list(){
        return repository.findAll();
    }

    public Todo save(Todo todo){
        return repository.save(todo);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }

    public Todo get(Long id){
         return repository.findById(id).orElseThrow();
    }

    public Iterable<Todo> listporlist(String grouplistid){
        return repository.findByGroupListId(grouplistid);
    }
    public void deleteGrouplistid(String grouplistid){
        repository.deleteGroupListId(grouplistid);
    }
}
