package com.library.repositories;

import com.library.titles.Titles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
