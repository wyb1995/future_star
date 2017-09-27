package com.thoughtworks.futurestar.service;

import com.thoughtworks.futurestar.dto.AddressDTO;
import com.thoughtworks.futurestar.entity.Address;

import java.util.List;

public interface AddressService {
    void create(AddressDTO addressDTO, String user_id);

    List<Address> getList(String user_id);
}
