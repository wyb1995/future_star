package com.thoughtworks.futurestar.api;

import com.thoughtworks.firstProject.Sorter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StringController {
    @GetMapping(value = "/wordLength", params = "string")
    public String countWordLengthAsc(@RequestParam("string") String string) {
        return Sorter.countWordLengthAsc(string);
    }
}
