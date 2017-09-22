package com.thoughtworks.future_star.api;

import com.thoughtworks.firstProject.Calculator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculatorController {
    @GetMapping(value = "/even-sum", params = "numbers")
    public Integer evenSum(@RequestParam("numbers") List<Integer> numbers) {
        return Calculator.sumEvens(numbers);
    }
}
