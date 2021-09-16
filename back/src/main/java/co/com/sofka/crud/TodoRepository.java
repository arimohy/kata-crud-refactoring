package co.com.sofka.crud;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    @Query("select t from Todo t where t.groupListId = ?1")
    List<Todo> findByGroupListId(String grouplistid);

    @Transactional
    @Modifying
    @Query("delete from Todo b where b.groupListId=:grouplistid")
    void deleteGroupListId(String grouplistid);

}
