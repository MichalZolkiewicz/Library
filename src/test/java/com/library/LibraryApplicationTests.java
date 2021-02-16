package com.library;

import com.library.domain.Copy;
import com.library.domain.Rental;
import com.library.domain.Users;
import com.library.repositories.CopyRepository;
import com.library.repositories.RentalRepository;
import com.library.repositories.TitlesRepository;
import com.library.repositories.UsersRepository;
import com.library.domain.Titles;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class LibraryApplicationTests {

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private TitlesRepository titlesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testTitlesAdding() {
        //Given
        Titles starWars3 = new Titles("Star Wars: Revange of the Sith", "Matthew Stover", 2005);
        Titles starWars4 = new Titles("Star Wars: New Hope", "George Lucas", 2018);

        //When
        titlesRepository.save(starWars3);
        titlesRepository.save(starWars4);

        Long id = starWars3.getId();
        Long id2 = starWars4.getId();

        //Then
        assertNotEquals(0, id);
        assertNotEquals(0, id2);

        //CleanUp
        titlesRepository.deleteAll();
    }

    @Test
    void creatingCopiesAndCombiningWithTitles() {
        //Given
        Titles starWars3 = new Titles("Star Wars: Revange of the Sith", "Matthew Stover", 2005);
        Titles starWars4 = new Titles("Star Wars: New Hope", "George Lucas", 2018);

        Copy copy1 = new Copy("active");
        Copy copy2 = new Copy("active");
        Copy copy3 = new Copy("active");
        Copy copy4 = new Copy("active");

        starWars3.getCopies().add(copy1);
        starWars3.getCopies().add(copy2);
        starWars4.getCopies().add(copy3);
        starWars4.getCopies().add(copy4);

        copy1.setTitles(starWars3);
        copy2.setTitles(starWars3);
        copy3.setTitles(starWars4);
        copy4.setTitles(starWars4);

        //When
        titlesRepository.save(starWars3);
        titlesRepository.save(starWars4);

        copyRepository.save(copy1);
        copyRepository.save(copy2);
        copyRepository.save(copy3);
        copyRepository.save(copy4);

        int copiesQuantity = starWars3.getCopies().size();
        Long starWars3Id = starWars3.getId();
        Long starWars4Id = starWars4.getId();

        //Then
        assertEquals(2, copiesQuantity);
        assertNotEquals(0, copy1.getTitles().getId());
        assertEquals(starWars3Id, copy1.getTitles().getId());
        assertEquals(starWars4Id, copy3.getTitles().getId());

        //CleanUp
        titlesRepository.deleteAll();
        copyRepository.deleteAll();
    }

    @Test
    void checkUsersCreation() {
        //Given
        Users michal = new Users("Michał", "Żółkiewicz", "23.07.1991");
        Users kasia = new Users("Katarzyna", "Żółkiewicz", "28.03.1986");

        //When
        usersRepository.save(michal);
        usersRepository.save(kasia);

        Long id = michal.getId();
        Long id2 = kasia.getId();

        String firstName = michal.getFirstname();

        //Then
        assertNotEquals(0, id);
        assertNotEquals(0, id2);
        assertEquals("Michał", firstName);

        //CleanUp
        usersRepository.deleteAll();
    }

    @Test
    void checkBookRental() {
        //Given
        Users michal = new Users("Michał", "Żółkiewicz", "23.07.1991");
        Titles starWars3 = new Titles("Star Wars: Revange of the Sith", "Matthew Stover", 2005);
        Copy copy1 = new Copy("active");
        Rental rental = new Rental(LocalDate.now(), LocalDate.of(2021,02,21));

        starWars3.getCopies().add(copy1);
        copy1.setTitles(starWars3);

        rental.setCopy(copy1);
        rental.setUser(michal);

        //When
        usersRepository.save(michal);
        titlesRepository.save(starWars3);
        copyRepository.save(copy1);
        rentalRepository.save(rental);

        Long userId = michal.getId();
        Long copyId = copy1.getId();

        //Then
        assertNotEquals(0, rental.getId());
        assertEquals(userId, rental.getUser().getId());
        assertEquals(copyId, rental.getCopy().getId());

        //CleanUp
        rentalRepository.deleteAll();
        titlesRepository.deleteAll();
        copyRepository.deleteAll();
        usersRepository.deleteAll();
    }

}
