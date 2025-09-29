package org.example.repository;

import org.example.entity.EquationRootEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquationRootRepository extends JpaRepository<EquationRootEntity, Long> {
}
