package com.Dio.PersonApi.Repository;

import com.Dio.PersonApi.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    static void DeleteById(Long id) {
    }
}
