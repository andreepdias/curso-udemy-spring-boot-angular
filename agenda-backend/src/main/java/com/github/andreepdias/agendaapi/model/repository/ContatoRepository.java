package com.github.andreepdias.agendaapi.model.repository;

import com.github.andreepdias.agendaapi.model.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
