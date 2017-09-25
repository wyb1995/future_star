package com.thoughtworks.future_star.api;

import com.thoughtworks.firstProject.Calculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculatorController {
    @GetMapping(value = "/even-sum", params = "numbers")
    public Integer evenSum(@RequestParam("numbers") List<Integer> numbers) {
        return Calculator.sumEvens(numbers);
    }
}
