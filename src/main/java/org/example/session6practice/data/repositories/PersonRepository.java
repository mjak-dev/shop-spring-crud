package org.example.session6practice.data.repositories;

import org.example.session6practice.data.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person,Long> {
    @Query(value = "select Person from Person p where p.basePersonalInfo.name=:name and p.basePersonalInfo.family=:family")
    Page<Person> findPersonByNameAndFamily(String name, String family, Pageable pageable);
}
