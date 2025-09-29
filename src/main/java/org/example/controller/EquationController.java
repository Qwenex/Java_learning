package org.example.controller;

import org.example.entity.EquationRootEntity;
import org.example.service.EquationService;
import org.example.entity.EquationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class EquationController {

    private final EquationService equationService;

    @Autowired
    public EquationController(EquationService equationService) {
        this.equationService = equationService;
    }

    @GetMapping("/")
    public String index() {
        return "quadraticEquation";
    }

    @PostMapping("/solve")
    @ResponseBody
    public EquationRootEntity solve(@RequestBody EquationEntity equationEntity) {
        return equationService.solve(equationEntity);
    }

    @GetMapping("/history")
    @ResponseBody
    public List<Map<String, Object>> getHistory() {
        return equationService.getLastTenSolutions();
    }
}