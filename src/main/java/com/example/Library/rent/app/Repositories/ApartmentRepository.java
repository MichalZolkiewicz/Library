package com.example.Library.rent.app.Repositories;

import com.example.Library.rent.app.Core.Apartment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ApartmentRepository extends CrudRepository<Apartment, Long> {

    Apartment findById(long id);

    List<Apartment> findAll();

    Apartment save(Apartment apartment);

    void deleteById(Long id);

    void deleteAll();
}
