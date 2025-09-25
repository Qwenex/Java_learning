package org.example.service;

import org.example.entity.EquationRootEntity;
import org.example.entity.EquationSolvedEntity;
import org.example.entity.EquationEntity;
import org.example.repository.EquationSolvedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquationService {

    private final EquationSolvedRepository equationSolvedRepository;

    @Autowired
    public EquationService(EquationSolvedRepository equationSolvedRepository) {
        this.equationSolvedRepository = equationSolvedRepository;
    }

    public EquationRootEntity solve(EquationEntity equationEntity) {
        Double a = equationEntity.getA();
        Double b = equationEntity.getB();
        Double c = equationEntity.getC();

        double d = (Math.pow(b, 2) - 4 * a * c);
        Double x1 = ((-b + Math.sqrt(d)) / 2 * a);
        Double x2 = ((-b - Math.sqrt(d)) / 2 * a);

        EquationRootEntity equationRootEntity = d < 0 ? new EquationRootEntity() : d == 0 ? new EquationRootEntity(x1) : new EquationRootEntity(x1, x2);

        EquationSolvedEntity equationSolvedEntity = new EquationSolvedEntity(equationEntity, equationRootEntity);
        equationSolvedRepository.save(equationSolvedEntity);
        return equationRootEntity;
    }
}
