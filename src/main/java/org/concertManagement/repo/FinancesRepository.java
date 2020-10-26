package org.concertManagement.repo;

import org.concertManagement.entities.Finances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedQuery;
import java.util.List;
import java.util.UUID;

public interface FinancesRepository extends JpaRepository<Finances, UUID>{

    @Query("SELECT f FROM Finances f WHERE concert_id = :concert_id")
    public List<Finances> findByConcert_id(@Param("concert_id")UUID concert_id);
}
