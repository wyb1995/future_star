package com.thoughtworks.future_star.api;

import com.thoughtworks.firstProject.Calculator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculatorController {
    @PostMapping("/evenSum")
    public Integer evenSum(@RequestBody List<Integer> list) {
        return Calculator.sumEvens(list);
    }
}
