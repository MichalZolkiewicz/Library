package com.library.repositories;

import com.library.domain.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {

    @Override
    Copy save(Copy copy);

    @Override
    List<Copy> findAll();

    @Override
    Optional<Copy> findById(Long id);

    @Override
    void deleteById(Long id);
}
