package org.example.repository;

import org.example.entity.EquationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquationRepository extends JpaRepository<EquationEntity, Long> {
}
