package com.library.service;

import com.library.domain.Copy;
import com.library.domain.Rental;
import com.library.domain.Titles;
import com.library.domain.Users;
import com.library.repositories.CopyRepository;
import com.library.repositories.RentalRepository;
import com.library.repositories.TitlesRepository;
import com.library.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    @Autowired
    private TitlesRepository titlesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private RentalRepository rentalRepository;

    public List<Titles> getAllTitles() {
       return titlesRepository.findAll();
    }

    public List<Users> getAllUsers() {
       return usersRepository.findAll();
    }

    public List<Copy> getAllCopies() {
        return copyRepository.findAll();
    }

    public List<Rental> getAllRental() {
        return rentalRepository.findAll();
    }

    public Optional<Copy> getCopy(final Long id) {
        return copyRepository.findById(id);
    }

    public Optional<Titles> getTitle(final Long id) {
        return titlesRepository.findById(id);
    }

    public Titles saveTitle(final Titles title) {
        return titlesRepository.save(title);
    }

    public Users saveUser(final Users user) {
        return usersRepository.save(user);
    }

    public Copy saveCopy(final Copy copy) {
        return copyRepository.save(copy);
    }

    public Rental saveRental(final Rental rental) {
        return rentalRepository.save(rental);
    }

    public void deleteRental(final Long id) {
        rentalRepository.deleteById(id);
    }
}
