package org.example.controller;

import org.example.entity.EquationRootEntity;
import org.example.service.EquationService;
import org.example.entity.EquationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EquationController {

    private final EquationService equationService;

    @Autowired
    public EquationController(EquationService equationService){
        this.equationService = equationService;
    }

    @GetMapping("/")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("quadraticEquation");
        return modelAndView;
    }

    @GetMapping
    public EquationRootEntity solve(EquationEntity equationEntity) {
        return equationService.solve(equationEntity);
    }




}
