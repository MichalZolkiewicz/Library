package com.library.repositories;

import com.library.domain.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface RentalRepository extends CrudRepository<Rental, Long> {

    @Override
    Rental save(Rental rental);

    @Override
    List<Rental> findAll();

    @Override
    Optional<Rental> findById(Long id);

    @Override
    void deleteById(Long id);
}
