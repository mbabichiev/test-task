package com.foy.maxach.test.testtask.services;

import com.foy.maxach.test.testtask.exceptions.UserNotFoundException;
import com.foy.maxach.test.testtask.models.User;
import com.foy.maxach.test.testtask.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Slf4j
@Service
@Data
@AllArgsConstructor
public class UserService {


    private UserRepository userRepository;
    private static final String ERROR_TEMPLATE = "User with id: '%s' not found";


    public User getById(String id){
        log.info("Get user with id: {}", id);

        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(String.format(ERROR_TEMPLATE, id));
                    throw new UserNotFoundException(String.format(ERROR_TEMPLATE, id));
                });

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.parse(user.getDateOfBirth(), formatter);
        LocalDate endDate = LocalDate.now();
        Period period = Period.between(startDate, endDate);
        user.setAge(period.getYears());

        return user;
    }

}
