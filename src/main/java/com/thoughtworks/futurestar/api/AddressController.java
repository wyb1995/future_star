package com.thoughtworks.futurestar.api;

import com.thoughtworks.futurestar.cache.SessionCache;
import com.thoughtworks.futurestar.dto.AddressDTO;
import com.thoughtworks.futurestar.entity.Address;
import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private AddressService addressServiceImpl;

    private SessionCache sessionCache = new SessionCache();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAddress(@RequestBody AddressDTO addressDTO) {
        User user = sessionCache.loadCurrentUser();
        addressServiceImpl.createAddress(addressDTO, user.getId());
    }

    @GetMapping
    public List<Address> getAddressList() {
        User user = sessionCache.loadCurrentUser();
        return addressServiceImpl.getAddressList(user.getId());
    }
}
