package com.thoughtworks.future_star.api;

import com.thoughtworks.firstProject.Sorter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StringController {
    @PostMapping("/wordLength")
    public String countWordLengthAsc(@RequestBody String string) {
        return Sorter.countWordLengthAsc(string);
    }
}
