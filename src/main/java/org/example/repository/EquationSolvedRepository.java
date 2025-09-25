package org.example.repository;

import org.example.entity.EquationSolvedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquationSolvedRepository extends JpaRepository<EquationSolvedEntity, Long> {
}
