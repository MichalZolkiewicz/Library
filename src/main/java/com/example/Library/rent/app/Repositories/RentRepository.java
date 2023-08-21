package com.example.Library.rent.app.Repositories;

import com.example.Library.rent.app.Core.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {

    Rent findById(long id);

    List<Rent> findAll();

    Rent save (Rent rent);
}
