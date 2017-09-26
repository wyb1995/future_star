package com.thoughtworks.futurestar.service;

import com.thoughtworks.futurestar.dto.AddressDTO;
import com.thoughtworks.futurestar.entity.Address;

import java.util.List;

public interface AddressService {
    void createAddress(AddressDTO addressDTO, String user_id);

    List<Address> getAddressList(String user_id);
}
