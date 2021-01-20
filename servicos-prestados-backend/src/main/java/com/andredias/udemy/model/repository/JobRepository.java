package com.andredias.udemy.model.repository;

import com.andredias.udemy.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    @Query("SELECT j FROM Job j JOIN j.client c " +
            "WHERE upper(c.name) LIKE upper(:nome) " +
            "AND month(j.date) = :mes")
    List<Job> findByNomeClienteAndMes(
            @Param("nome") String nome,
            @Param("mes") Integer mes);
}
