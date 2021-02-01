package com.library.repositories;

import com.library.users.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    @Override
    Users save(Users user);

    @Override
    List<Users> findAll();

    @Override
    Optional<Users> findById(Long id);

    @Override
    void deleteById(Long id);

}
