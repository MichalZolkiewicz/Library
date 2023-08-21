package com.example.Library.rent.app.Repositories;

import com.example.Library.rent.app.Core.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {


    Owner findById(long id);

    List<Owner> findAll();

    Owner save(Owner owner);

    void deleteById(Long id);
}
