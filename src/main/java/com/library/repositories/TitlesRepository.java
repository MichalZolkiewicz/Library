package com.library.repositories;

import com.library.domain.Titles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TitlesRepository extends CrudRepository<Titles, Long> {

    @Override
    Titles save(Titles title);

    @Override
    List<Titles> findAll();

    @Override
    Optional<Titles> findById(Long id);

    @Override
    void deleteById(Long id);

}
