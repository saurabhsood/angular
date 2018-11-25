package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
