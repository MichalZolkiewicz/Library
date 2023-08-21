package com.example.Library.rent.app.Repositories;

import com.example.Library.rent.app.Core.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findById(long id);

    List<User> findAll();

    User save(User user);

    void deleteById(Long id);
}
