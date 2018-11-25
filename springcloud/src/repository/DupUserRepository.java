package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.DupUser;

@Repository
public interface DupUserRepository extends CrudRepository<DupUser, Integer> {

}
