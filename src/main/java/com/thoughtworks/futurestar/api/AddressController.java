package com.thoughtworks.futurestar.api;

import com.thoughtworks.futurestar.dto.AddressDTO;
import com.thoughtworks.futurestar.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private AddressService addressServiceImpl;

    @PostMapping("/{user_id}")
    public void createAddress(@RequestBody AddressDTO addressDTO, @PathVariable String user_id) {
        addressServiceImpl.createAddress(addressDTO, user_id);
    }

    @GetMapping("/{user_id}")
    public List<String> getAddressList(@PathVariable String user_id) {
        return addressServiceImpl.getAddressList(user_id);
    }
}
