package ru.taratonov.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.taratonov.dbservice.model.LoanRequest;

@Repository
public interface DbRepository extends JpaRepository<LoanRequest, Long> {

}
