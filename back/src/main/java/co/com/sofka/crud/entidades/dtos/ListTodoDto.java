package co.com.sofka.crud.entidades.dtos;

import co.com.sofka.crud.entidades.Todo;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;

public class ListTodoDto implements DTOentidadListTodo{
    private Long id;
    private String name;
    private Set<Todo> List;

    public ListTodoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Todo> getList() {
        return List;
    }

    public void setList(Set<Todo> list) {
        List = list;
    }
}
