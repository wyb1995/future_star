package com.thoughtworks.future_star.api;

import com.thoughtworks.firstProject.Calculator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculatorController {
    @GetMapping(value = "/evenSum", params = "list")
    public Integer evenSum(@RequestParam("list") List<Integer> list) {
        return Calculator.sumEvens(list);
    }
}
