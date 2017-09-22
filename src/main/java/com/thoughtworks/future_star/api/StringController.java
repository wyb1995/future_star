package com.thoughtworks.future_star.api;

import com.thoughtworks.firstProject.Sorter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StringController {
    @GetMapping(value = "/wordLength", params = "string")
    public String countWordLengthAsc(@RequestParam("string") String string) {
        return Sorter.countWordLengthAsc(string);
    }
}
