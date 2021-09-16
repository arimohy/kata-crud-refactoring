package co.com.sofka.crud.entidades;

import javax.persistence.*;
import java.util.Set;
@Entity
public class ListTodo {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "list")
    private Set<Todo> List;


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
