package org.example.repository;

import org.example.entity.EquationSolvedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquationSolvedRepository extends JpaRepository<EquationSolvedEntity, Long> {
    List<EquationSolvedEntity> findTop10ByOrderByCreatedAtDesc();
}
