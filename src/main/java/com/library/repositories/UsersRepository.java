package com.library.repositories;

import com.library.domain.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
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
