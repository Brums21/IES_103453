package ex3_1a.demo;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);
}
